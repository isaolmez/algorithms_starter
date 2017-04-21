package com.isa.section1.chapter3.reiterate;

public class Exercise_1_3_20 {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 20; i >= 0; i--) {
            linkedList.addFirst(i);
        }

        System.out.println(linkedList.deleteKth(4));
        System.out.println(linkedList.deleteKth(4));
        System.out.println(linkedList.deleteKth(4));
        System.out.println(linkedList.deleteKth(4));
        System.out.println(linkedList.size());
    }

    private static class MyLinkedList<T> {
        private int size;
        private Node head;

        public MyLinkedList() {
            size = 0;
            head = null;
        }

        public void addFirst(T value) {
            size++;
            head = new Node(value, head);
        }

        public T removeFirst() {
            if (head == null) {
                return null;
            }

            size--;
            T result = head.value;
            head = head.next;
            return result;
        }

        public T getFirst() {
            return head == null ? null : head.value;
        }

        public T deleteKth(int k) {
            if (k > size()) {
                return null;
            }

            Node traverser = head;
            for (int i = 1; i < k - 1; i++) {
                traverser = traverser.next;
            }

            size--;
            Node found = traverser.next;
            traverser.next = found.next;
            return found.value;
        }

        public boolean isEmpty() {
            return size() == 0;
        }

        public int size() {
            return size;
        }

        private class Node {
            T value;
            Node next;

            public Node(T value) {
                this(value, null);
            }

            public Node(T value, Node next) {
                this.value = value;
                this.next = next;
            }
        }
    }
}