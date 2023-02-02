package com.ttk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ttk.entity.MessageRecord;

public interface AsyncService extends IService<MessageRecord> {

    void test();

}
