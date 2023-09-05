package com.ttk.examplecase.designpattern.behaviorpattern.observer;

import com.google.common.collect.Lists;

import java.util.List;

public class NoticeObserver implements Subject{

    private List<Observer> observersList;

    public NoticeObserver() {
        this.observersList = Lists.newArrayList();
    }

    @Override
    public void registerObserver(Observer observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observersList.remove(observer);
    }

    @Override
    public void noticeObserver(String message) {
        for (Observer observer : observersList) {
            observer.send(message);
        }
    }

}
