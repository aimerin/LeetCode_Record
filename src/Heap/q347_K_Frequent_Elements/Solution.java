package Heap.q347_K_Frequent_Elements;

import java.util.*;

public class Solution {
    Map<Integer, Integer> occurans = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {

        for (int num : nums) {
            occurans.put(num, occurans.getOrDefault(num, 0) + 1);
        }

        int[] heap = new int[k];
        Iterator iterator = occurans.keySet().iterator();
        int i=0;
        while (iterator.hasNext()) {
            if (i < k) {
                heap[i] = (Integer) iterator.next();
                i++;
                if (i == k) {
                    for (int j = k / 2 - 1; j >= 0; j--) {
                        heapSort(heap, j);
                    }
                }
            }else{
                int key = (Integer) iterator.next();
                if(occurans.get(key)>occurans.get(heap[0])) heap[0]=key;
                heapSort(heap, 0);
            }
        }
        return heap;
    }

    public void heapSort(int[] heap, int i) {
        int temp = heap[i];
        for (int j = 2 * i + 1; j < heap.length; j = 2 * j + 1) {
            if(j+1<heap.length&&occurans.get(heap[j+1])<occurans.get(heap[j])) j++;
            if (occurans.get(heap[j]) < occurans.get(temp)) {
                heap[i] = heap[j];
                i=j;
            } else break;
            heap[i] = temp;
        }
    }
}
