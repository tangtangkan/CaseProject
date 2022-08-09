// package com.ttk.controller;
//
// import com.alibaba.fastjson.JSON;
// import com.baomidou.mybatisplus.core.toolkit.StringUtils;
// import com.ttk.entity.Message;
// import com.ttk.service.UserService;
// import com.ttk.shiro.AccountProfile;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.RestController;
//
// import javax.websocket.*;
// import javax.websocket.server.ServerEndpoint;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Map;
// import java.util.concurrent.ConcurrentHashMap;
//
// /**
//  * 注意在websocket通信中只能传string
//  */
// @ServerEndpoint(value = "/socket")
// @RestController
// public class WebSocketServerOne {
//
//     private final UserService userService;
//
//     @Autowired
//     public WebSocketServerOne (UserService userService) {
//         this.userService = userService;
//     }
//
//     // 存储当前对象
//     public static final Map<String, Session> sessionMap = new ConcurrentHashMap<>();
//
//     // session会话
//     private Session session;
//
//     /**
//      * 建立连接
//      * 1.把登录用户存到sessionMap中
//      * 2.发送给所有人当前登录人员信息
//      * @param session
//      */
//     @OnOpen
//     public void onOpen(Session session) {
//         System.out.println("onOpen");
//         // AccountProfile accountProfile = userService.getCurrentLoginUser();
//         AccountProfile accountProfile = (AccountProfile) session.getUserProperties().get("user");
//         System.out.println("当前用户名=="+JSON.toJSONString(accountProfile));
//         this.session = session;
//
//         sessionMap.put(accountProfile.getUsername(), session);
//         // 发送登录人员消息给所有的客户端
//         sendAllMessage(setUserList());
//     }
//
//     /**
//      * 关闭连接
//      * 1.把登出的用户从sessionMap中剃除
//      * 2.发送给所有人当前登录人员信息
//      */
//     @OnClose
//     public void onClose() {
//         System.out.println("onClose");
//         AccountProfile accountProfile = (AccountProfile) session.getUserProperties().get("user");
//         System.out.println("当前用户名=="+JSON.toJSONString(accountProfile));
//         sessionMap.remove(accountProfile.getUsername());
//         sendAllMessage(setUserList());
//     }
//
//     /**
//      * 接收处理客户端发来的数据
//      */
//     @OnMessage
//     public void onMessage(String message) {
//
//         System.out.println("onMessage");
//         AccountProfile accountProfile = (AccountProfile) session.getUserProperties().get("user");
//         System.out.println("当前用户名=="+JSON.toJSONString(accountProfile));
//
//         // 解析消息为java对象
//         Message msg = JSON.parseObject(message, Message.class);
//         if(StringUtils.isEmpty(msg.getTo())){
//             sendAllMessage(JSON.toJSONString(msg));
//         }else{
//             Session sessionTo = sessionMap.get(msg.getTo());
//             sendMessage(message,sessionTo);
//         }
//     }
//
//     @OnError
//     public void onError(Session session, Throwable error) {
//         System.out.println("发生错误");
//         error.printStackTrace();
//     }
//
//     /**
//      * 发送登录人员消息给所有的客户端
//      * @return
//      */
//     private String setUserList(){
//         ArrayList<String> list = new ArrayList<>();
//         for(String key:sessionMap.keySet()){
//             list.add(key);
//         }
//         Message message = new Message();
//         message.setUserNames(list);
//         return JSON.toJSONString(message);
//     }
//
// //    服务端发送消息给指定客户端
//     private void sendMessage(String message, Session toSession) {
//         try {
//             toSession.getBasicRemote().sendText(message);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
//
// //   服务端发送消息给所有客户端
//     private void sendAllMessage(String message) {
//         try {
//             for (Session session : sessionMap.values()) {
//                 session.getBasicRemote().sendText(message);
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
