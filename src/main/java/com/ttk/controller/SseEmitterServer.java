package com.ttk.controller;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * SSE通知工具类
 */
@Slf4j
public class SseEmitterServer {

    /**
     * 使用map对象，便于根据userId来获取对应的SseEmitter
     */
    private static Map<Long, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    /**
     * 创建用户连接并返回 SseEmitter
     *
     * @param userId 用户ID
     * @return SseEmitter
     */
    public static SseEmitter connect(Long userId) {
        log.info("SseEmitterServer -> connect");
        // 设置超时时间，0表示不过期。默认30秒，超过时间未完成会抛出异常：AsyncRequestTimeoutException
        SseEmitter sseEmitter = new SseEmitter(0L);
        // 注册回调
        sseEmitter.onCompletion(completionCallBack(userId));
        sseEmitter.onError(errorCallBack(userId));
        sseEmitter.onTimeout(timeoutCallBack(userId));
        sseEmitterMap.put(userId, sseEmitter);
        log.info("创建新的sse连接, 当前用户: {}", userId);
        String str = Lists.newArrayList(sseEmitterMap.keySet()).stream().map(String::valueOf).collect(Collectors.joining(","));
        log.info("当前连接用户: {}", str);
        return sseEmitter;
    }

    public static void test(Long id) {
        sseEmitterMap.get(id).completeWithError(new Exception("重复连接 -> id: " + id));
    }

    /**
     * 给指定用户发送信息
     * @param userId    用户id
     * @param message   消息内容
     */
    public static void sendMessage(Long userId, String message) {
        log.info("SseEmitterServer -> sendMessage");
        if (sseEmitterMap.containsKey(userId)) {
            try {
                sseEmitterMap.get(userId).send(message);
                log.info("用户: {}推送通知: {}", userId, message);
            } catch (IOException e) {
                log.error("用户: {}, 推送异常: {}", userId, e.getMessage());
                removeUser(userId);
            }
        }
    }

    /**
     * 移除用户连接
     * @param userId    用户ID
     */
    public static void removeUser(Long userId) {
        log.info("SseEmitterServer -> removeUser");
        sseEmitterMap.remove(userId);
        log.info("移除用户: {}", userId);
    }

    private static Runnable completionCallBack(Long userId) {
        return () -> {
            log.info("结束连接: {}", userId);
            removeUser(userId);
        };
    }

    private static Runnable timeoutCallBack(Long userId) {
        return () -> {
            log.info("连接超时: {}", userId);
            removeUser(userId);
        };
    }

    private static Consumer<Throwable> errorCallBack(Long userId) {
        return throwable -> {
            log.info("连接异常: {}", userId);
            removeUser(userId);
        };
    }
}
