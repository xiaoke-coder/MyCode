
/*
 * 0923gxm
 * 快速排序：在数组中选择一个称为主元的元素，将数组分为两部分，使得第一部分的所有元素都小于或等于主元，
 * 而第二部分中的所有元素都大于主元。分别对两部分递归的应用快速排序。
 * 思路：应该选择能平均划分两部分的主元：在线性表中的第一个、中间、最后一个元素中选择中位数作为主元
 *
 * 复杂度：O(n logn)
 */

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    //对特定范围内的子数组排序
    //list:待排序数组
    //first：数组第一个元素
    //last:数组最后一个元素坐标list.length - 1
    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    //使用主元划分数组，将子数组第一个元素选为主元。返回主元下标
    //该方法将主元放置在正确的位置后返回主元的下标
    public static int partition(int[] list, int first, int last) {
        int pivot = list[first];
        int low = first + 1;
        int high = last;
        //划分元素
        while (high > low) {
            while (low <= high && list[low] <= pivot)
                low++;
            while (low <= high && list[high] >= pivot)
                high--;
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
//更新主元位置
        while (high > first && list[high] >= pivot)
            high--;

            if (pivot > list[high]) {
                list[first] = list[high];
                list[high] = pivot;
                return high;
            } else {
                return first;
            }
        }

        public static void main (String[] args){
            int[] list = {1, 3, 2};
            quickSort(list);
            System.out.println(Arrays.toString(list));
        }
    }
