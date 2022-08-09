package com.ttk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRecordVo {

    /**
     * 服务空间id（房间号）
     */
    private Long roomId;

    /**
     * 消息发送类型（SendTypeEnum）
     */
    private String sendType;

    /**
     * 消息发送者
     */
    private String fromUser;

    /**
     * 消息接受者
     */
    private String toUser;

    /**
     * 聊天内容类型（MessageTypeEnum）
     */
    private String messageType;

    /**
     * 聊天内容
     */
    private String message;

    /**
     * 发送时间
     */
    private Date createtime;

    /**
     * 聊天室成员
     */
    private List<String> userNames;
}
