import java.util.Arrays;

/*
0923gxm
冒泡排序：多次遍历数组，在每次遍历中连续比较相邻的元素，如果元素没有按照顺序排列，则互换他们的值
复杂度：O(n^2)
 */
public class BubbleSort {
    public static void bubbleSort(int [] list){

        //优化变量：如果一次比较中没有交换，则认为数组有序，输出即可
        boolean needNextPass =true;
        for (int k = 1; k < list.length && needNextPass; k++) {//k从1开始，不然容易越界因为每次都和后面一个数比较
            needNextPass=false;
            for (int i = 0; i < list.length-k; i++) {
                if(list[i]>list[i+1]){
                    //交换
                    int temp=list[i];
                    list[i]=list[i+1];
                    list[i+1]=temp;

                    needNextPass=true;
                }
            }
        }
    }
    public static void main(String[] args) {
        int [] list={1,3,2};
        bubbleSort(list);
        System.out.println(Arrays.toString(list));
    }
}
