package com.ttk.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRecord {

    @TableId(type = IdType.AUTO)
    private Long id;

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
}
