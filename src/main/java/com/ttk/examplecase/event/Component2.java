package com.ttk.examplecase.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Component2 {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void send() {
        System.out.println("发送邮件");
        applicationEventPublisher.publishEvent(new UserLogOutEvent(this));
    }

}
