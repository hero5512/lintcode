package lintcode.lfu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LFUCache2 {
    class Element {
        int key;
        int val;
        Element prev;
        Element next;

        public Element(int key, int val, Element prev, Element next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    class ElementLRU {
        Map<Integer, Element> map;
        Element head;
        Element tail;

        public ElementLRU() {
            this.map = new HashMap<>();
            this.head = new Element(-1, -1, null, null);
            this.tail = new Element(-1, -1, null, null);
            this.head.next = tail;
            this.tail.prev = head;
        }

        public int getSize() {
            return map.size();
        }

        public void add(int key, int val) {
            Element element = new Element(key, val, null, null);
            addToHead(element);
            map.put(key, element);
        }

        public void remove(int key) {
            if (!map.containsKey(key)) return;

            Element element = map.get(key);
            removeElement(element);
            map.remove(key);
        }

        public int getLastKey() {
            return tail.prev.key;
        }

        public void removeLast() {
            if (tail.prev != head) {
                remove(tail.prev.key);
            }
        }

        private void removeElement(Element element) {
            Element prev = element.prev;
            Element next = element.next;

            prev.next = next;
            next.prev = prev;
        }

        private void addToHead(Element element) {
            Element next = head.next;

            head.next = element;
            element.prev = head;

            next.prev = element;
            element.next = next;
        }

        private String asString() {
            StringBuilder sb = new StringBuilder();
            Element curr = head;
            while (curr != null) {
                sb.append("<" + curr.key + " " + curr.val + "> ");
                curr = curr.next;
            }

            return sb.toString();
        }
    }

    class Bucket {
        int count;
        Bucket prev;
        Bucket next;
        ElementLRU elements;

        public Bucket(int count, Bucket prev, Bucket next) {
            this.count = count;
            this.prev = prev;
            this.next = next;
            this.elements = new ElementLRU();
        }

        public int getSize() {
            return elements.getSize();
        }
    }

    Map<Integer, Bucket> map;
    Bucket head;
    Bucket tail;
    int capacity;

    public LFUCache2(int capacity) {
        this.map = new HashMap<>();
        this.head = new Bucket(0, null, null);
        this.tail = new Bucket(-1, null, null);

        this.head.next = tail;
        this.tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        System.out.println("Get " + key);
        if(!map.containsKey(key)) {
            printStructure();
            return -1;
        } else {
            increaseCountByOne(key);

            printStructure();
            return map.get(key).elements.map.get(key).val;
        }
    }

    public void put(int key, int value) {
        System.out.println("Put " + key + " " + value);
        if(capacity == 0) return;
        if(map.containsKey(key)) {
            increaseCountByOne(key);
            Element element = map.get(key).elements.map.get(key);
            element.val = value;
        } else {
            if(map.size() == capacity) {
                int removeKey = head.next.elements.getLastKey();
                head.next.elements.removeLast();
                checkAndCleanUp(head.next);
                map.remove(removeKey);
            }

            if(head.next.count != 1) {
                insertNextBucket(head);
            }
            head.next.elements.add(key, value);
            map.put(key, head.next);
        }
        printStructure();
    }

    private void increaseCountByOne(int key) {
        // linkedList operations
        Bucket currBucket = map.get(key);
        if(currBucket.next.count != currBucket.count + 1) {
            insertNextBucket(currBucket);
        }
        Bucket nextBucket = currBucket.next;
        nextBucket.elements.add(key, currBucket.elements.map.get(key).val);
        currBucket.elements.remove(key);
        checkAndCleanUp(currBucket);
        // map operations
        map.put(key, nextBucket);
    }

    private void checkAndCleanUp(Bucket curr) {
        if(curr.getSize() == 0) {
            removeBucket(curr);
        }
    }

    private void removeBucket(Bucket curr) {
        Bucket prev = curr.prev;
        Bucket next = curr.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertNextBucket(Bucket curr) {
        int count = curr.count;

        Bucket newBucket = new Bucket(count + 1, null, null);
        Bucket next = curr.next;

        newBucket.next = next;
        next.prev = newBucket;
        curr.next = newBucket;
        newBucket.prev = curr;
    }

    private void printStructure() {
        System.out.print("Map: ");
        map.forEach((k, v) -> System.out.print("[" + k + " " + v.count + "] "));
        System.out.println("");

        Bucket curr = head;
        while(curr != null) {
            System.out.print("[" + curr.count + " " + curr.elements.asString() + "]");
            curr = curr.next;
        }
        System.out.println("");
    }
}


