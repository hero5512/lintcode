package lintcode.lfu;

import java.util.HashMap;
import java.util.PriorityQueue;

public class LFUCache {
    private HashMap<Integer, Element> map;
    private PriorityQueue<Element> minStack;
    private int capacity;
    private static int tick = 0;

    /*
     * @param capacity: An integer
     */
    public LFUCache(int capacity) {
        // do intialization if necessary
        this.map = new HashMap<>();
        this.minStack = new PriorityQueue<Element>((a, b) -> {
            if (a.fre > b.fre) {
                return 1;
            } else if (a.fre == b.fre) {
                if (a.tick > b.tick) {
                    return 1;
                } else if (a.tick < b.tick) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        });
        this.capacity = capacity;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        this.tick++;
        if (map.containsKey(key)) {
            Element cur = map.get(key);
            minStack.remove(cur);
            cur.fre++;
            cur.val = value;
            cur.tick = this.tick;
            minStack.add(cur);
        } else {
            if (map.size() >= capacity) {
                Element cur = minStack.poll();
                map.remove(cur.key);
            }
            Element cur = new Element(key, value, 1, this.tick);
            minStack.add(cur);
            map.put(key, cur);
        }
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        tick++;
        // write your code here
        if (map.containsKey(key)) {
            Element cur = map.get(key);
            minStack.remove(cur);
            cur.fre++;
            cur.tick = this.tick;
            minStack.add(cur);
            return cur.val;
        }
        return -1;
    }


    public static void main(String[] args) {
        LFUCache cache = new LFUCache(3);
        cache.set(1, 10);
        cache.set(2, 20);
        cache.set(3, 30);
        cache.get(1);
        cache.set(4, 40);
        cache.get(4);
    }
}

class Element {
    public int key;
    public int val;
    public int fre;
    public int tick;

    public Element(int key, int val, int fre, int tick) {
        this.key = key;
        this.val = val;
        this.fre = fre;
        this.tick = tick;
    }

}