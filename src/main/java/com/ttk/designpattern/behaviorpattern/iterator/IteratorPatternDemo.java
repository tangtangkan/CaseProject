package com.ttk.designpattern.behaviorpattern.iterator;

public class IteratorPatternDemo {

    public static void main(String[] args) {

        NameRepository namesRepository = new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("名字 : " + name);
        }

        Iterator iterator = namesRepository.getIterator();
        while (iterator.hasNext()) {
            System.out.println("名字 : " + iterator.next());
        }

    }
}