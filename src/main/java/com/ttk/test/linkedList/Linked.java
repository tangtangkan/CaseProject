package com.ttk.test.linkedList;

import java.util.Objects;

public class Linked<T> {

    // 头节点
    private Node head;

    // 链表元素个数
    private int size;

    // 链表元素
    private class Node {

        // 元素对象
        private T t;

        // 指向的下一个元素
        private Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
            this.t = t;
        }
    }

    public Linked() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    // 添加头部元素
    public void addFirst(T t) {
        // new一个元素对象
        Node node = new Node(t);
        // 先将添加元素的next指向当前头结点
        node.next = this.head;
        // 然后将头结点设置为添加的元素
        this.head = node;

        // 一行代码抵上面三行代码
        // this.head = new Node(t,head);

        // 将元素数量+1
        this.size++;
    }

    // 添加尾部元素
    public void addLast(T t) {

        // new一个元素对象，不设置next，假设为newNode
        // 找到最后一个元素
        // 将最后一个元素的next指向newNode
        // 将元素数量+1

        this.add(t, this.size);
    }

    /**
     * 指定位置添加元素
     *
     * @param t     元素
     * @param index 插入元素的索引
     */
    public void add(T t, int index) {

        // 1. new一个元素对象，假设为newNode
        // 2. 根据指定元素位置找到此位置前一个位置的元素，假设为proNode
        // 3. 将newNode的next指定到proNode.next
        // 4. 将proNode.next指定到newNode

        // TODO 注意：3和4的步骤不能乱，如果先执行4，将将proNode.next指定到newNode，再执行3，将newNode的next指定到将proNode.next，此时将proNode.next已经是newNode，会导致将插入的节点指向了自己

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is error");
        }

        // 如果index == 0，说明是添加头元素
        if (index == 0) {
            this.addFirst(t);
            return;
        }

        // 找到要插入节点的前一个节点
        Node preNode = this.head;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }

        Node node = new Node(t);
        // 新插入的节点的next指向preNode节点的next
        node.next = preNode.next;

        // preNode的下一个节点指向要插入节点node
        preNode.next = node;

        // 一行代码抵上面三行代码
        // preNode.next = new Node(t, head);

        // 将元素数量+1
        this.size++;
    }

    // 删除头部元素
    public T delFirst() {
        // 判断是否有元素
        if (this.head == null) {
            System.out.println("无元素可删除");
        }

        Node delNode = this.head;
        // 将头部元素设置为头部元素的next
        this.head = head.next;

        // 将删除的头部元素的next设置为null
        delNode.next = null;

        // 将元素数量-1
        this.size--;

        return delNode.t;
    }

    // 删除尾部元素
    public T delLast() {
        // 判断是否有元素
        if (this.size == 0) {
            System.out.println("无元素可删除");
        }

        // 如果只有一个元素，删除头部元素
        if (this.size == 1) {
            return delFirst();
        }

        // 找到尾部元素的前一个元素

        // 定义当前节点
        Node curNode = this.head;
        // 定义当前节点的前一个节点
        Node preNode = this.head;

        // 最后一个节点的next一定是null，如果curNode.next为空的话，说明curNode.next是最后一个节点，而curNode是最后一个节点的前一个节点
        while (curNode.next != null) {
            preNode = curNode;
            curNode = curNode.next;
        }
        // 直到curNode.next为空，curNode为最后一个节点，preNode为倒数第二个节点，将倒数第二个节点的next设置为最后一个节点的next，其实就是设置为null
        preNode.next = curNode.next;

        // 将元素数量-1
        this.size--;

        return curNode.t;
    }

    // 删除指定元素
    public void del(T t) {

        if (this.size == 0) {
            System.out.println("无元素可删除");
        }

        // 判断删除的是否是头结点
        if (Objects.equals(this.head, t)) {
            delFirst();
            return;
        }

        // 定义删除节点
        Node delNode = this.head;
        // 定义删除节点的上一节点
        Node preNode = this.head;

        for (int i = 0; i < this.size; i++) {
            preNode = delNode;
            delNode = delNode.next;
            if (Objects.equals(delNode.t, t)) {
                preNode.next = delNode.next;
                delNode.next = null;

                // 将元素数量-1
                this.size--;
                return;
            }
        }

        System.out.println("删除元素不存在");
    }

    // 根据索引获取元素
    public T get(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is error");
        }

        int start = 0;
        Node node = this.head;
        while (start != index) {
            node = node.next;
            start++;
        }
        return node.t;
    }

}
