package com.ttk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * SSE controller
 */
@RestController
@RequestMapping("sse")
@CrossOrigin
@Slf4j
public class SseEmitterController {

    /**
     * 创建用户连接并返回SseEmitter
     *
     * @return SseEmitter
     */
    @GetMapping(value = "/connect")
    public SseEmitter connect(@RequestParam("userId") Long userId) {
        return SseEmitterServer.connect(userId);
    }

    /**
     * 移除用户连接
     */
    @GetMapping("/removeUser")
    public void removeUser(@RequestParam("userId")Long userId) {
        SseEmitterServer.removeUser(userId);
    }

}
