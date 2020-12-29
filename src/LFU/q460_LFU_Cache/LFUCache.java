package LFU.q460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    //key 到 val 的映射
    HashMap<Integer, Integer> keyToVal;
    //key 到 freq 的映射
    HashMap<Integer, Integer> keyToFreq;

    // freq 到 key列表 的映射
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;

    //记录最小频次
    int minFreq;

    //记录LFU缓存的最大容量
    int cap;

    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.cap = capacity;
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        //增加key对应的freq
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if(this.cap<=0) return;

        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
            return;
        }

        if (this.cap <= keyToVal.size()) {
            removeMinFreqKey();
        }

        keyToVal.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        int deletekey = keyList.iterator().next();
        keyList.remove(deletekey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
        }
        keyToVal.remove(deletekey);
        keyToFreq.remove(deletekey);
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq + 1).add(key);

        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if (freq == minFreq) {
                this.minFreq++;
            }
        }
    }
}
