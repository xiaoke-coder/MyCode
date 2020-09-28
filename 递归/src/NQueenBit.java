/*
9/23gxm
基于位运算的回溯
参考：https://leetcode-cn.com/problems/n-queens/solution/nhuang-hou-by-leetcode-solution/
* */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenBit {
    public static void main(String[] args) {

        NQueenBit nQueen = new NQueenBit();
        System.out.println(nQueen.solveNQueens(4));//参数：皇后个数！！！！！！
    }
    public List<List<String>> solveNQueens(int n){
        int[] queens=new int[n];
        Arrays.fill(queens,-1);
        List<List<String>> ans=new ArrayList<List<String>>();
        solve(ans,queens,n,0,0,0,0);
        return ans;
    }
    /*

    n:总行数
    row：当前行数
    colomns：不可选的列
    diagonals1：不可选的左斜边
    diagonals2：不可选的右斜边
    */
    public void solve(List<List<String>> ans, int[] queens, int n, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            ans.add(board);
        } else {

            //1表示可以放皇后的位置，利用位运算，将O(n)复杂度降为O(1),一次解决
            int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            //遍历所有可以放皇后的位置
            while(availablePositions!=0){
                int position=availablePositions & (-availablePositions);
                availablePositions=availablePositions & (availablePositions-1);
                int column=Integer.bitCount(position-1);
                queens[row]=column;
                //更新每列以及斜边不可以放皇后的位置，利用传递的参数进行更新  columns调半天╭(╯^╰)╮
                solve(ans,queens,n,row + 1,columns|position,(diagonals1|position)<<1,(diagonals2|position)>>1);
                /* queens[row]=-1;*/
           // int availablePositions = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
           // while (availablePositions != 0) {
                ///int position = availablePositions & (-availablePositions);
               // availablePositions = availablePositions & (availablePositions - 1);
               // int column = Integer.bitCount(position - 1);
               // queens[row] = column;
               // solve(ans, queens, n, row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
                queens[row] = -1;

            }
        }
    }
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;

    }
}



