package com.ttk.examplecase.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Component1 {

    @EventListener
    public void send(UserRegisteredEvent userRegisteredEvent) {
        System.out.println("发送短信：" + userRegisteredEvent.getSource());
    }

}
