import java.util.Arrays;

/**
 * 0923gxm
 * 插入排序：重复的将新的元素插入到排好序的子线性表中，直到整个线性表排好序
 * 复杂度：O(n^2)
 */
public class InsertionSort {
    public static void insertionSort(int[] list){
        //外循环i：获取已经排好序的子线性表
        for (int i = 0; i < list.length; i++) {
            //内循环k：将list[i]插入子线性表中
            int currentElement=list[i];
            int k;
            for (k = i-1; k >= 0 && list[k]>currentElement; k--) {
                list[k+1]=list[k];
            }
            list[k+1]=currentElement;
        }
    }
    public static void main(String[] args) {
        int [] list={1,3,2};
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
