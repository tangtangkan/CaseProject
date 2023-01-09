package com.ttk.cese.designpattern.behaviorpattern.memento;

import java.util.Random;

public class MementoPatternDemo {
    public static void main(String[] args) {

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(5));
        }


        // 发起类
        // Originator originator = new Originator();
        // originator.setState("State #1");
        // originator.setState("State #2");
        //
        // // 管理类
        // CareTaker careTaker = new CareTaker();
        // careTaker.add(originator.saveStateToMemento());
        //
        // originator.setState("State #3");
        // careTaker.add(originator.saveStateToMemento());
        //
        // originator.setState("State #4");
        // System.out.println("Current State: " + originator.getState());
        //
        // originator.getStateFromMemento(careTaker.get(0));
        // System.out.println("First saved State: " + originator.getState());
        //
        // originator.getStateFromMemento(careTaker.get(1));
        // System.out.println("Second saved State: " + originator.getState());

    }
}