import java.util.Arrays;

/**
 * 0925gxm
 *堆排序：使用二叉堆，首先将所有元素添加到一个堆上，然后不断移除最大的元素以获得一个排好序的线性表
 * 复杂度：O(n^2)
 */
public class HeapSort {
    public static <E extends Comparable<E>> void heapSort(E[] list){
        Heap<E> heap=new Heap<>();

        for(int i=0;i< list.length;i++){
            heap.add(list[i]);
        }
        for (int j = list.length-1;j >=0; j--) {
            list[j]=heap.remove();
        }

    }

    public static void main(String[] args) {
        Integer [] list={1,3,2};//Integer 不可int
        heapSort(list);
        System.out.println(Arrays.toString(list));
    }

}
