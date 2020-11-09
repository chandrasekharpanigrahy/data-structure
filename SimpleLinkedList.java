package com.example.stream.api.service.datastructure;

// No size limitation
public class SimpleLinkedList<X> {
    private SimpleNode head;
    private SimpleNode tail;
    private int nodeCount;

    public SimpleLinkedList() {
        this.head = null;
        this.tail = null;
        this.nodeCount = 0;
    }

    public int size() {
        return nodeCount;
    }

    public void add(X item){
        SimpleNode newNode = new SimpleNode(item);
        if(head == null && tail == null){
            head = newNode;
            tail = newNode;
        }
        else {
            head.setNext(newNode);
            head = newNode;
        }
        nodeCount++;
    }

    public void removeLast(){
        if(tail == null) {
            throw new IllegalStateException("no node in Linked list");
        }
        tail = tail.getNext();
        nodeCount--;
    }

    public void removeAt(int position) {
        int i = 1;
        SimpleNode nodeAtPosition = tail;
        if(position > nodeCount){
            throw new IllegalArgumentException("no nodeAtPosition present at position");
        }
        while (position == i-1) {
            nodeAtPosition = nodeAtPosition.getNext();
            i++;
        }
        SimpleNode newNode = nodeAtPosition.getNext().getNext();
        nodeAtPosition.setNext(newNode);
        nodeCount--;
    }

    public void insert(X item, int position) {
        if(position > nodeCount) {
            throw new IllegalArgumentException("no nodeAtPosition present at index");
        }
        SimpleNode newNode = new SimpleNode(item);
        int i = 1;
        SimpleNode nodeAtPosition = tail;
        while (position == i-1) {
            nodeAtPosition = nodeAtPosition.getNext();
            i++;
        }
        SimpleNode nextNodeAtPosition= nodeAtPosition.getNext();
        nodeAtPosition.setNext(newNode);
        newNode.setNext(nextNodeAtPosition);
        nodeCount++;
    }

    public SimpleNode get(int position) {
        int i = 1;
        SimpleNode nodeAtPosition = tail;
        if(position > nodeCount){
            throw new IllegalArgumentException("no nodeAtPosition present at position");
        }
        while (position == i-1) {
            nodeAtPosition = nodeAtPosition.getNext();
            i++;
        }
        return nodeAtPosition;
    }

    public int find(X item) {
        if (tail == null) {
            throw new IllegalArgumentException("no item found");
        }
        SimpleNode node = tail;
        for(int i = 0; i < nodeCount; i++) {
            if (node.getItem().equals(item)) {
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }

    private class SimpleNode {
        private X item;
        private SimpleNode next;

        public SimpleNode(X item) {
            this.item = item;
        }

        public X getItem() {
            return item;
        }

        public SimpleNode getNext() {
            return next;
        }

        public void setNext(SimpleNode next) {
            this.next = next;
        }

    }

}
