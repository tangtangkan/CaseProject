package com.ttk.controller;

import com.ttk.entity.MessageRecord;
import com.ttk.service.MessageRecordService;
import com.ttk.utils.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/messageRecord")
public class MessageRecordController {

    private final MessageRecordService messageRecordService;

    @Autowired
    public MessageRecordController(MessageRecordService messageRecordService) {
        this.messageRecordService = messageRecordService;
    }

    @GetMapping("/getMessageRecord")
    public CommonResult<List<MessageRecord>> getMessageRecord(@RequestParam(value = "roomId") String roomId) {
        return CommonResult.success("请求成功", messageRecordService.getMessageRecordByRoomId(roomId));
    }

}
