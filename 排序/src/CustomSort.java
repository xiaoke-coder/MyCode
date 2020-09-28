import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
学习自定义排序
（lambda表达式：该解法待学习）
参考：https://leetcode-cn.com/problems/relative-sort-array/solution/ming-que-bi-jiao-fang-shi-hou-xiang-zen-yao-pai-ji/
 */
public class CustomSort {
    //hashmap便于查询元素
    Map<Integer,Integer> record;
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        record = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            record.put(arr2[i], i);
        }
        quickSort(arr1, 0, arr1.length-1);
        return arr1;
    }
        //自定义比较函数
        public boolean lessEqual(int num1, int num2){
            if(record.containsKey(num1)&& record.containsKey(num2)){
                return record.get(num1) <= record.get(num2);
            }else if(record.containsKey(num1)){
                return true;
            }else if(record.containsKey(num2)){
                return false;
            }
            else
            {
                return num1<=num2;
            }
        }
        //排序
       // QuickSort.quickSort(arr1);
        //对特定范围内的子数组排序
        public  void quickSort(int[] list, int first, int last) {
            if (last > first) {
                int pivotIndex = partition(list, first, last);
                quickSort(list, first, pivotIndex - 1);
                quickSort(list, pivotIndex + 1, last);
            }
        }

        //使用主元划分数组，将子数组第一个元素选为主元。返回主元下标
        //该方法将主元放置在正确的位置后返回主元的下标
        public  int partition(int[] list, int first, int last) {
            int pivot = list[first];
            int low = first + 1;
            int high = last;
            //划分元素
            while (high > low) {
                while (low <= high && lessEqual(list[low] , pivot))
                    low++;
                while (low <= high && lessEqual(pivot,list[high]))
                    high--;
                if (high > low) {
                    int temp = list[high];
                    list[high] = list[low];
                    list[low] = temp;
                }
            }
//更新主元位置
            while (high > first && lessEqual(pivot,list[high]))
                high--;

            if (lessEqual(list[high] , pivot)) {
                list[first] = list[high];
                list[high] = pivot;
                return high;
            } else {
                return first;
            }
        }

    public static void main (String[] args) {
     int [] arr1= {2,3,1,3,2,4,6,77,9,2,19};
     int [] arr2= {2,1,4,3,9,6};
     CustomSort ans=new CustomSort();
     System.out.println(Arrays.toString(ans.relativeSortArray(arr1,arr2)));
    }
}
