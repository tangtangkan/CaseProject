package com.ttk.examplecase.event;

import org.springframework.context.ApplicationEvent;

public class UserLogOutEvent extends ApplicationEvent {

    public UserLogOutEvent(Object source) {
        super(source);
    }
}
