package com.ttk.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ttk.entity.MessageRecord;

import java.util.List;

/**
 * @author Administrator
 */
public interface MessageRecordService extends IService<MessageRecord> {

    List<MessageRecord> getMessageRecordByRoomId(String roomId);

}
