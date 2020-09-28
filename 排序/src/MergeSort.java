import java.util.Arrays;

/*
 * 0923gxm
 * 归并排序：将数组分成两半，对每部分递归的应用归并排序。在两部分都排好序后，对他们进行归并。
 * 思路：分，分，和
 * 可以使用并行处理高效执行
 * 复杂度：O(n logn)
 */
public class MergeSort {
    public static void mergeSort(int[] list) {
    if(list.length>1){
        //分
        int[] firstHalf=new int[list.length / 2];
        System.arraycopy(list,0,firstHalf,0,list.length/2);
        mergeSort(firstHalf);
        //分
        int secondHalfLength=list.length- list.length/2;
        int[] secondHalf=new int[secondHalfLength];
        System.arraycopy(list,list.length/2,secondHalf,0,secondHalfLength);
        mergeSort(secondHalf);
        //合
        merge(firstHalf,secondHalf,list);
    }
    }
    //将拆好的 有序 程序合并
    public static void merge(int[] list1,int[] list2,int [] temp){
        int current1=0;
        int current2=0;
        int current3=0;

        while (current1< list1.length && current2< list2.length){
            if(list1[current1]<list2[current2]){
                temp[current3++]=list1[current1++];
            }
            else
            {
                temp[current3++]=list2[current2++];
            }
        }
        while (current1< list1.length){
            temp[current3++]=list1[current1++];
        }
        while (current2 < list2.length){
            temp[current3++]=list2[current2++];
        }
    }

    public static void main(String[] args) {
        int [] list={1,3,2};
        mergeSort(list);
        System.out.println(Arrays.toString(list));
    }
}