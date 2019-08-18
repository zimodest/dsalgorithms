package com.modest.ds.heap;


/**
 * 创建堆
 *
 * @author modest
 * @date 2019/08/17
 */
public class Heap {


    private int capacity;
    public int[] heap ;
    private int size = 0;

    public Heap() {
        this.capacity = 50;
        this.heap= new int[50] ;
    }

    public Heap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
    }


    /**
     * 建立大堆
     * 从数组后面开始向下调整
     * @param arr
     */
    public int[] createBigHeap(int[] arr) {
        if(arr == null || arr.length == 0) {
            return null;
        }

        for(int j=0; j<arr.length; j++) {
            this.heap[j] = arr[j];
            this.size++;
        }
        // 求出最后一个元素对应的根节点，以后每个根节点为上一个节点下标减1
        int i = (this.size -1) / 2;

        // 每个根节点进行向下调整
        while(i>=0) {
            heapAdjustDown(i);
            i--;
        }

        return this.heap;
    }

    /**
     *
     * 向下调整某个节点
     *
     * @param root 要调整的节点
     */
    public void heapAdjustDown(int root) {
        int length = this.heap.length;
        int cur = root;
        int maxChild = 0;

        while(cur < length) {
            //计算根节点的左节点下标
            int left = 2 * cur + 1;
            //计算根节点的右节点下标
            int right = 2 * cur + 2;

            //如果left 越界，没有子节点，不需要调整
            if(left >= length) {
                break;
            }

            //到这，有左节点，可能有右节点

            //right 不越界的，既有右节点，又有左节点
            if(right < length) {
                //到这，既有右节点，又有左节点
                maxChild = this.heap[left] >= this.heap[right] ? left : right;

                if(this.heap[cur] > this.heap[maxChild]) {
                    break;
                }

                swap(this.heap, maxChild, cur);
                cur = maxChild;
            } else {
                //只有左节点
                if(this.heap[left] <= this.heap[cur]) {
                    break;
                }

                swap(this.heap, left, cur) ;
                cur = left;
            }
        }
    }


    /**
     * 交换数组中的两个数
     * @param arr 交换的数组
     * @param i 交换的下标
     * @param j 交换的下标
     */
    private void swap(int[] arr, int i, int j) {
        if(arr[i] != arr[j]) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
        }
    }

}
