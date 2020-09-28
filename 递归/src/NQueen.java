import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQueen {
    static int N = 4;
    int[] queenPos = new int[N];
    static int count=0;

    public static void main(String[] args) {
        /*System.out.print("Enter the number of queens: ");
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();*/
        NQueen nQueen = new NQueen();
        nQueen.check(0);//从第0行开始摆皇后
        System.out.println(count);
    }

    public void check(int k) {
        //！！！在0~k-1行皇后已经摆好的情况下，摆第k行及其后的皇后
        if (k == N) {//N个皇后已经摆好
           /* for (int j = 0; j < N; j++) {
                System.out.printf("%d ", queenPos[j] + 1);
            }*/
            count++;
           List<String> board= print();
            System.out.println(board);

            return;
        }
        for (int i = 0; i < N; i++) {//逐个尝试第k个皇后的位置
            int j;
            for (j = 0; j < k; j++) {//和已经摆好的k个皇后的位置作比较，看是否冲突
                if (queenPos[j] == i || Math.abs(queenPos[j] - i) == Math.abs(k - j))
                    break;//冲突（不在同一列或者斜对角线），则试下一个位置
            }
            if (j == k) {//当前选的位置i不冲突
                queenPos[k] = i;//将K个皇后摆在位置i
                check(k + 1);
            }
        }


    }

    public List<String>  print() {
        List<String> board=new ArrayList<String>();
        for (int i = 0; i < N; i++) {
            char[] row=new char[N];
            Arrays.fill(row,'.');
            row[queenPos[i]]='Q';
            board.add(new String(row));
        }
        return board;

    }
}
