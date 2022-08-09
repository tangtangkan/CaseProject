package com.ttk.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.ttk.entity.MessageRecord;
import com.ttk.entity.MessageRecordVo;
import com.ttk.enums.SendTypeEnum;
import com.ttk.service.MessageRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 多个群
 * 注意在websocket通信中只能传string
 */
@ServerEndpoint("/socket/{room_username}")
@Component
public class WebSocketServerTwo {

    // 存储房间和人员
    private static final Map<String, ConcurrentHashMap<String, WebSocketServerTwo>> roomMap = new ConcurrentHashMap<>();

    // 用来发送消息
    private Session session;

    private String roomId;

    private String username;

    private static MessageRecordService messageRecordService;

    @Autowired
    public void setMessageRecordService(MessageRecordService messageRecordService) {
        WebSocketServerTwo.messageRecordService = messageRecordService;
    }

    /**
     * 建立连接
     * 1.把登录用户存到sessionMap中
     * 2.发送给所有人当前登录人员信息
     * @param session
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("room_username") String room_username) {
        System.out.println("onOpen===" + room_username);

        this.session = session;
        String[] s = room_username.split("_");
        this.roomId = s[0];
        this.username = s[1];
        ConcurrentHashMap<String, WebSocketServerTwo> concurrentHashMap = roomMap.get(roomId);
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            // 房间不存在，新建房间
            concurrentHashMap = new ConcurrentHashMap<>();
            concurrentHashMap.put(username, this);
            roomMap.put(roomId, concurrentHashMap);
            System.out.println("新建房间" + roomId + "人员：" + username);
        } else {
            // 将人加入房间
            concurrentHashMap.put(username, this);

            System.out.println(username + "加入房间" + roomId);
            ConcurrentHashMap<String, WebSocketServerTwo> concurrentHashMap1 = roomMap.get(roomId);
            for (String username : concurrentHashMap1.keySet()) {
                System.out.println("人员：" + username);
            }
        }

        // 刷新聊天室成员
        MessageRecordVo messageRecordVo = new MessageRecordVo();
        messageRecordVo.setUserNames(getRoomMember(roomId));
        String msg = JSON.toJSONString(messageRecordVo);
        sendAllMessage(msg);
    }

    /**
     * 关闭连接
     * 1.把登出的用户从sessionMap中剃除
     * 2.发送给所有人当前登录人员信息
     */
    @OnClose
    public void onClose() {

        System.out.println("onClose===" + username + "，退出房间：" + roomId);

        ConcurrentHashMap<String, WebSocketServerTwo> concurrentHashMap = roomMap.get(roomId);
        if (!concurrentHashMap.isEmpty()) {
            concurrentHashMap.remove(username);
            if (concurrentHashMap.isEmpty()) {
                System.out.println("房间无人，解散房间");
                roomMap.put(roomId, new ConcurrentHashMap<>());
            }
        }

        // 刷新聊天室成员
        MessageRecordVo messageRecordVo = new MessageRecordVo();
        messageRecordVo.setUserNames(getRoomMember(roomId));
        String msg = JSON.toJSONString(messageRecordVo);
        sendAllMessage(msg);
    }

    /**
     * 接收处理客户端发来的数据
     */
    @OnMessage
    public void onMessage(String message) {


        System.out.println("onMessage=========" + message);

        System.out.println("房间号：" + roomId + "，username" + username);

        // 解析消息为java对象
        MessageRecordVo msg = JSON.parseObject(message, MessageRecordVo.class);

        MessageRecord messageRecord = new MessageRecord();
        BeanUtils.copyProperties(msg, messageRecord);
        messageRecordService.save(messageRecord);

        if(SendTypeEnum.ALL.name().equals(msg.getSendType())){
            // 发送群消息
            sendAllMessage(JSON.toJSONString(msg));
        }else{
            // 发送指定消息
            // Session sessionTo = sessionMap.get(msg.getTo());
            // sendMessage(message,sessionTo);
        }
    }

    /**
     * 获取聊天室成员
     * @param roomId
     * @return
     */
    public List<String> getRoomMember(String roomId) {
        List<String> userNames = Lists.newArrayList();
        ConcurrentHashMap<String, WebSocketServerTwo> concurrentHashMap = roomMap.get(roomId);
        for (String username : concurrentHashMap.keySet()) {
            userNames.add(username);
        }
        return userNames;
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("onError===");
        error.printStackTrace();
    }

    // 服务端发送消息给指定客户端
    private void sendMessage(String message, Session toSession) {
        try {
            toSession.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 服务端发送消息给所有客户端
    private void sendAllMessage(String message) {
        try {
            ConcurrentHashMap<String, WebSocketServerTwo> concurrentHashMap = roomMap.get(roomId);
            if (!concurrentHashMap.isEmpty()) {
                for (String username : concurrentHashMap.keySet()) {
                    concurrentHashMap.get(username).session.getBasicRemote().sendText(message);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
