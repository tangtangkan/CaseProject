package com.ttk.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ttk.entity.MessageRecord;

import java.util.List;

/**
 * @author Administrator
 */
public interface MessageRecordService extends IService<MessageRecord> {

    List<MessageRecord> getMessageRecordByRoomId(String roomId);

    /**
     * 不加@Transactional注解
     */
    void addMessageRecord1(MessageRecord messageRecord);

    /**
     * @Transactional
     */
    void addMessageRecord2(MessageRecord messageRecord);

    /**
     * @Transactional(propagation = Propagation.REQUIRES_NEW)
     */
    void addMessageRecord3(MessageRecord messageRecord);

}
