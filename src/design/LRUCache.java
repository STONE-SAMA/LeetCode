package design;

import java.util.LinkedHashMap;

/**
 * LRU 缓存
 * https://leetcode.cn/problems/lru-cache/description
 */
public class LRUCache {

    int cap;
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecent(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecent(key);
            return;
        }
        if (map.size() >= this.cap) {
            int oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }
        map.put(key, value);
    }

    private void makeRecent(int key) {
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
    }
}
