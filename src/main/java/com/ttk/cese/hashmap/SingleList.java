package com.ttk.cese.hashmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 单向链表
 * @param <T>
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SingleList<T> {

    private int size;

    // 头节点
    private Node<T> head;

    // 尾节点
    private Node<T> tail;

    /**
     * 静态节点内部类
     * @param <T>
     */
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    /**
     * 头插法
     */
    boolean addFirst(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            // 如果头结点为空, 说明没有任何节点(也可以判断尾节点)
            head = node;
            tail = node;
        } else {
            // 如果头节点不为空, 将插入元素的next指针指向之前的头节点, 再将头结点设置为插入的元素
            node.next = head;
            head = node;
        }
        size++;
        return true;
    }

    /**
     * 尾插法
     */
    boolean addLast(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            // 将插入的元素设置为尾结点的next指针
            tail.next = node;
            tail = node;
        }
        size++;
        return true;
    }

    /**
     * 指定位置插入（下标）
     * 例：ABCD, 在位置3插入F, 结果 ABCFD
     */
    boolean add(int index, T data) {
        Node<T> node = new Node<>(data);
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数据下标越界 Index:" + index);
        } else if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            node.setNext(temp.next);
            temp.setNext(node);
            size++;
        }
        return true;
    }

    /**
     * 删除头节点
     */
    T delFirst() {
        if (head == null) {
            // 如果头结点为空, 说明没有任何节点(也可以判断尾节点)
            throw new RuntimeException("该链表为空！");
        } else {
            T data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    /**
     * 删除尾节点
     */
    T delLast() {
        if (head == null) {
            // 如果头结点为空, 说明没有任何节点(也可以判断尾节点)
            throw new RuntimeException("该链表为空！");
        } else if (size == 1){
            return delFirst();
        } else {
            Node<T> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.setNext(null);
            tail = temp;
            size--;
            return temp.data;
        }
    }

    /**
     * 指定位置删除（下标）
     * 例：ABCD, 删除位置3的元素, 结果 ABC
     */
    T del(int index) {
        if (head == null) {
            throw new RuntimeException("该链表为空！");
        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数据下标越界 Index:" + index);
        } else if (index == 0) {
            return delFirst();
        } else if (index == size - 1) {
            return delLast();
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            T data = temp.next.data;
            temp.next = temp.next.next;
            size--;
            return data;
        }
    }

    /**
     * 获取指定位置数据（下标）
     * 例：ABCD, 获取3的元素, 结果 D
     */
    T getData(int index) {
        if (head == null) {
            throw new RuntimeException("该链表为空！");
        } else if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数据下标越界 Index:" + index);
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.getData();
        }
    }

    /**
     * 遍历单链表
     */
    void print() {
        if (head == null) {
            throw new RuntimeException("该链表为空！");
        } else {
            Node<T> temp = head;
            while (temp != null) {
                System.out.println(temp.getData());
                temp = temp.next;
            }
            System.out.println();
        }
    }
}
