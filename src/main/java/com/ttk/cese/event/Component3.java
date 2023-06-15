package com.ttk.cese.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Component3 {

    @EventListener
    public void send(UserLogOutEvent userLogOutEvent) {
        System.out.println("发送短信：" + userLogOutEvent.getSource());
    }

}
