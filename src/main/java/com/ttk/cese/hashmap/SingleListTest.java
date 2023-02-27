package com.ttk.cese.hashmap;


public class SingleListTest {

    public static void main(String[] args) {

        /*SingleList<String> singleList = new SingleList();
        // 插入头
        singleList.addFirst("A");
        singleList.addFirst("B");
        // 插入尾
        singleList.addLast("C");
        singleList.addLast("D");
        // 指定位置插入
        singleList.add(1, "E");
        singleList.add(1, "F");

        // 删除头
        singleList.delFirst();
        // 删除尾
        singleList.delLast();
        // 指定位置删除
        singleList.del(0);
        // 获取指定位置的元素
        String data = singleList.getData(2);
        System.out.println(data);
        System.out.println();
        // 打印
        singleList.print();*/

        DoublelyLinkedList<String> doublelyLinkedList = new DoublelyLinkedList();
        doublelyLinkedList.addLast("A");
        doublelyLinkedList.addLast("B");
        doublelyLinkedList.addLast("C");
        doublelyLinkedList.addLast("D");
        doublelyLinkedList.addLast("E");
        // doublelyLinkedList.removeFirst();
        // doublelyLinkedList.removeLast();
        doublelyLinkedList.remove(2);
        doublelyLinkedList.detailPrint();

    }

}
