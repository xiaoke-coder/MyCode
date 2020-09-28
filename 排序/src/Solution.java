
class Solution {
    //核心：一图胜千言，学会自己画图！！！！！数位置越靠前，权重越高，数越大所以下一个比当前数大的数应该是
    /*1、从后往前找第一个逆序对a(i-1)<a(i)，为反转点（该数前后翻转都不可以）
      2、然后往后找和该数最接近的数，与该数交换，将其他数字升序排列即可得所求
    */
    public  int nextGreaterElement(int n) {
        char[] a=(""+n).toCharArray();
        int i=a.length-2;
        while(i>=0&&a[i+1]<=a[i]){
            i--;
        }
        if(i<0)
            return -1;
            int j=a.length-1;
            while(j>=0&&a[j]<=a[i]){
                j--;
            }
            swap(a,i,j);
            reverse(a,i+1);
            try{
                return Integer.parseInt(new String (a));
            }catch(Exception e){
                return -1;
            }
    }

    private void reverse(char[] a,int start){
        int i=start,j=a.length-1;
        while(i<j){
            swap(a,i,j);
            i++;
            j--;
        }
    }
    private void swap(char[] a,int i,int j){
        char temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }


    public static void main(String[] args) {
        int list=132;
        Solution s=new Solution();
        System.out.println(s.nextGreaterElement(list));
    }
}