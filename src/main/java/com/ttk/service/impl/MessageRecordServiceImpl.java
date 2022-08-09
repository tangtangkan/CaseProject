package com.ttk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ttk.dao.MessageRecordMapper;
import com.ttk.entity.MessageRecord;
import com.ttk.service.MessageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */

@Service
public class MessageRecordServiceImpl extends ServiceImpl<MessageRecordMapper, MessageRecord> implements MessageRecordService {

    private final MessageRecordMapper messageRecordMapper;

    @Autowired
    public MessageRecordServiceImpl(MessageRecordMapper messageRecordMapper) {
        this.messageRecordMapper = messageRecordMapper;
    }

    @Override
    public List<MessageRecord> getMessageRecordByRoomId(String roomId) {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("room_id", roomId);
        return messageRecordMapper.selectList(queryWrapper);
    }
}
