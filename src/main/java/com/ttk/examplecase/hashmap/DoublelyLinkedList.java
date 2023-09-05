package com.ttk.examplecase.hashmap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 实现双向链表
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DoublelyLinkedList<T> {

    private int size;

    // 头结点
    private Node<T> first;

    // 尾结点
    private Node<T> last;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    private static class Node<T> {
        private T data;
        // 前驱指针
        private Node<T> pri;
        // 后驱指针
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

    }

    /**
     * 添加节点到头部
     */
    public boolean addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (size == 0) {
            first = node;
            last = first;
        } else {
            // 将插入节点的next指向头结点
            node.next = first;
            // 将头节点的前驱指针指向插入的节点
            first.pri = node;
            // 将头结点设置为插入的节点
            first = node;
        }
        size++;
        return true;
    }

    /**
     * 添加节点到尾部
     */
    public boolean addLast(T value) {
        if (size == 0) {
            return addFirst(value);
        } else {
            Node<T> node = new Node<>(value);
            // 将尾节点的后驱指针指向插入的节点
            last.next = node;
            // 将插入节点的前驱指针指向尾节点
            node.pri = last;
            // 将尾节点设置为插入的节点
            last = node;
        }
        size++;
        return true;
    }

    /**
     * 元素添加到指定位置
     */
    public boolean add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数据下标越界 Index:" + index + "\tsize:" + size);
        } else if (index == 0) {
            return addFirst(value);
        } else if (index == size) {
            return addLast(value);
        } else {
            Node<T> node = new Node<>(value);
            Node<T> head = first;
            for (int i = 0; i < index - 1; i++) {
                head = head.getNext();
            }
            // head：原位置节点的前驱节点
            // 将插入节点的后驱指针指向原位置节点
            node.next = head.next;
            // 将原位置节点的前驱指针指向插入节点
            head.next = node;
            // 将插入节点的前驱指针指向head
            node.pri = head;
            // 将原位置节点的后驱节点的前驱指针指向插入的节点
            node.next.pri = node;
        }
        size++;
        return true;
    }

    /**
     * 删除头结点
     */
    public T removeFirst() {
        if (size == 0) {
            throw new RuntimeException("链表为空！");
        }
        T data = first.getData();
        if (size == 1) {
            first = null;
            last = null;
            size--;
            return data;
        } else {
            first = first.next;
        }
        return data;
    }

    /**
     * 删除尾节点
     */
    public T removeLast() {
        if (size == 0) {
            throw new RuntimeException("链表为空！");
        }
        T data = last.getData();
        if (size == 1) {
            first = null;
            last = null;
            size--;
            return data;
        } else {
            // 获取尾结点的上一节点node
            Node<T> node = last.pri;
            // 设置node的后驱指针为空
            node.setNext(null);
            // 设置尾结点为node
            last = node;
        }
        return data;
    }

    /**
     * 删除指定下标结点
     */
    public T remove(int index) {
        if (size == 0) {
            throw new RuntimeException("链表为空！");
        }
        //注意添加的时候，下标取不到size，但是添加的位置可以是size，但是删除的时候不行
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("数据下标越界 Index:" + index + "\tsize:" + size);
        } else if (index == 0) {
            return removeFirst();
        } else {
            Node<T> node = first;
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            Node<T> temp = node.next;
            // 判断删除节点是不是最后一个节点
            if (temp != last) {
                T data = temp.getData();
                // A B C, 删除B 将A的next指向C
                node.next = temp.next;
                // 将C的pri指向A
                temp.next.pri = node;
                return data;
            } else {
                return removeLast();
            }
        }
    }

    /**
     * 获取对应下标数据
     */
    public T getData(int index) {
        if (size == 0) {
            throw new RuntimeException("链表为空");
        } else if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("数据下标越界 Index:" + index + "\tsize:" + size);
        } else if (size == 1) {
            return first.data;
        } else {
            Node<T> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.data;
        }
    }

    /**
     * 清空链表
     */
    public void clear() {
        first.next = null;
        last = first;
    }

    /**
     * 遍历输出当前所有数据
     */
    public void print() {
        if (size == 0) {
            System.out.println("该链表为空!");
        }
        Node<T> node = first;
        while (node != null) {
            System.out.println(node.getData());
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 详细遍历输出:
     * 前驱节点值
     * 当前节点值
     * 后继节点值
     */
    public void detailPrint() {
        if (size == 0) {
            System.out.println("该链表为空!");
        }
        Node<T> node = first;
        while (node != null) {
            System.out.print("前驱节点值：");
            System.out.printf("%-5s", node.pri == null ? "null\t" : node.pri.getData() + "\t");
            System.out.print("当前节点值：");
            System.out.printf("%-6s", node.getData() + "\t");
            System.out.print("后继节点值：");
            System.out.printf("%-5s", node.next == null ? "null\t" : node.next.getData() + "\t");
            System.out.println();
            node = node.getNext();
        }
        System.out.println();
    }
}
