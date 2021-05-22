package com.ash.ik.arrays;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUCache {

    class Node {
        int k;
        int v;

        Node prev;
        Node next;

        Node(int k, int v) {
            this.k= k;
            this.v = v;
            prev= null;
            next = null;
        }
    }

    Map<Integer, Node> map = new ConcurrentHashMap();
    int capacity;
    Node head;
    Node tail;
    int count;

    LRUCache(int size) {
        capacity = size;
        head.next = tail;
        tail.prev = head;
        count = 0;
    }

    public void add(int k, int v) {

        if(map.get(k) != null) {
            Node node = map.get(k);
            remove(node);
            addToHead(node);
        } else {
            Node node = new Node(k, v);
            map.put(k, node);

            if (isCapacityExhausted()) {
                map.remove(tail.k);
                removeTail();
                addToHead(node);
            } else {
                addToHead(node);
                count++;
            }
        }
    }

    public void addToHead(Node node) {
        node.next = head;
        head.prev = node;
        head = node;

    }
    public void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void removeTail() {
        Node prevNode = tail.prev;
        tail = null;
        tail = prevNode;
    }

    public int get(int k) {
        if(map.get(k) == null) {
            return -1;
        }
        Node node= map.get(k);
        remove(node);
        addToHead(node);
        return node.v;
    }

    public boolean isCapacityExhausted() {
        return count == capacity;
    }


}
