package Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
        int[] a = getRandomArray(10);
        Solution solution = new Solution();
//        solution.bucketSort(a);
//        solution.mergeSort(a, 0, a.length - 1);
//        solution.quickSort(a, 0, a.length - 1);
//        solution.bubbleSort(a);
        solution.countSort(a);
        print(a);
    }


    //冒泡排序
    //循环遍历多次，每次从前往后把大元素（如果是升序排序）往后调，每次确定一个最大元素
    //多次后达到升序序列
    //时间复杂度为O(n²)
    public void bubbleSort(int[] a) {
        //第一次排序的比较范围为[0,a.length-1]
        //第二次排序的比较范围为[0,a.length-2],因为第一次排序后，最末尾位置的元素是最大的
        //第n次排序的比较范围为[0,a.length-n]
        //直到排序范围为[0,0]则不用进行交换，排序完成
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    //快速排序 平均时间复杂度O(nlogn)
    //快速排序使用分治的思想，从待排序列中随机选取一个数
    //使该数左边序列的数小于该数
    //使该数右边序列的数大于该数
    //再递归使用该方法对左右序列排序
    public void quickSort(int[] a, int left, int right) {
        int lo = left;
        int hi = right;
        //递归终止条件
        if (lo > hi) return;

        //使用挖坑法交换元素
        //将左端第一个元素设为基准值，假设在lo这个位置挖坑，
        // 即看lo这个位置是空的，需要其他元素填补
        int pivot = a[lo];
        //左右交替交换元素，使基准值左序列的元素都小于基准值，
        // 使基准值右序列元素都大于基准值

        while (lo < hi) {
            //从右端向左找第一个比基准值pivot小的元素
            while (lo < hi && a[hi] >= pivot) {
                hi--;
            }
            //将第一个比基准值放在lo这个这个位置
            //此时坑为hi这个位置
            a[lo] = a[hi];
            //从左端向右找第一个比基准值pivot大的元素
            while (lo < hi && a[lo] <= pivot) {
                lo++;
            }
            //填坑
            a[hi] = a[lo];
        }
        //将基准值填入
        a[lo] = pivot;
        //递归排序左序列
        quickSort(a, left, lo - 1);
        //递归排序右序列
        quickSort(a, lo + 1, right);
    }

    //插入排序
    //平均时间复杂度O(n²)
    //从前往后开始遍历，每一躺将当前位置的元素插入到前面序列的合适位置
    //可以使用二分查找来加速查找当前位置的合适位置
    //值得注意的是插入排序是从第二个元素开始的即i=1
    public void insertSort(int[] a) {
        int temp = 0;
        for (int i = 1; i < a.length; i++) {
            temp = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                    a[j] = temp;
                } else break;
            }
        }
    }

    //希尔排序
    //基于插入排序，为了减少数据移动次数，希尔排序进行若干次分组计算，
    // 使序列前后之间小的尽量再后面，大的尽量在前面，最后一组使直接插入排序
    public void shellSort(int[] a) {
        int divider = a.length / 2;//初始间隔为数组长度的1/2
        int temp = 0;
        for (; divider >= 1; divider /= 2) {//分成divider组，每组间隔为divider
            for (int i = divider; i < a.length; i++) {
                temp = a[i];
                //从前往后遍历，每一躺将当前位置的元素插入到前面序列的合适位置
                for (int j = i - divider; j >= 0; j -= divider) {
                    if (a[j] > temp) {
                        a[j + divider] = a[j];
                        a[j] = temp;
                    } else break;
                }
            }
        }
    }

    //选择排序
    //每一次遍历首先在未排序序列种找到最小元素a[min]
    //与已排序列的末尾元素比较a[i]，若a[i]>a[min],则交换元素
    //进行下一趟遍历，遍历区间缩小
    public void selectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            //找出区间[i+1,len]最小的元素
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            //如果最小元素不是a[i],则交换元素
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

    //堆排序
    //所有结点大于孩子结点，该堆为大根堆
    //所有结点小于孩子结点，该堆为小根堆
    //1、建堆，从下往上进行调整
    void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    //下移调整
    void shiftDown(int a[], int index, int len) {
        //左孩子
        int leftChild = index * 2 + 1;
        //右孩子
        int rightChild = index * 2 + 2;
        //递归结束条件
        if (leftChild >= len) return;
            //如果右孩子大于根节点且大于左孩子，则让根节点与右孩子交换
        else if (rightChild < len && a[rightChild] < a[leftChild]
                && a[rightChild] < a[index]) {
            swap(a, index, rightChild);
            shiftDown(a, rightChild, len);
        }
        //则让根节点与左孩子交换
        else if (a[leftChild] < a[index]) {
            swap(a, index, leftChild);
            shiftDown(a, leftChild, len);
        }
    }

    public void heapSort(int[] a) {
        //建堆
        for (int i = a.length / 2; i >= 0; i--) {
            shiftDown(a, i, a.length);
        }

        int[] val = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            val[i] = a[0];
            a[0] = a[a.length - 1 - i];
            shiftDown(a, 0, a.length - i);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = val[i];
        }
    }


    //归并排序 时间复杂度O(nlogn)
    public void mergeSort(int[] a, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            mergeSort(a, left, mid);
            mergeSort(a, mid + 1, right);
            merge(a, left, mid, right);
        }
    }

    public void merge(int[] a, int l, int mid, int r) {
        int lindex = l, rindex = mid + 1;
        int[] temp = new int[r - l + 1];
        int tempIndex = 0;
        while (lindex <= mid && rindex <= r) {
            if (a[lindex] <= a[rindex]) {
                temp[tempIndex++] = a[lindex++];
            } else {
                temp[tempIndex++] = a[rindex++];
            }
        }
        while (lindex <= mid) {
            temp[tempIndex++] = a[lindex++];
        }
        while (rindex <= r) {
            temp[tempIndex++] = a[rindex++];
        }
        for (int i = 0; i < tempIndex; i++) {
            a[l + i] = temp[i];
        }
    }

    //桶排序


    public void bucketSort(int[] a) {
        int max=0;
        for (int i = 0; i < a.length; i++) {
//                System.out.print(a[i]+" ");
                if(a[i]>max) max = a[i];
        }
        List[] buckets = new ArrayList[max/10+1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < a.length; i++) {
            int index = a[i] / 10;
            buckets[index].add(a[i]);
        }
        for (int i = 0; i < buckets.length; i++) {
            buckets[i].sort(null);
        }
        int[] temp = new int[a.length];
        int count=0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                temp[count++] = (int) buckets[i].get(j);
            }
        }
        for (int i = 0; i < temp.length; i++) {
            a[i] = temp[i];
        }
    }


    //计数排序
    public void countSort(int[] a) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < min) {
                min = a[i];
            }
            if (a[i] > max) {
                max = a[i];
            }
        }
        int count[] = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            count[a[i] - min]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                a[index++] = i + min;
            }
        }
    }
    static int[] getRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 11);
        }
        return arr;
    }

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
