package com.liang.leetcode.daily.history;

/**
 * @ClassName: L999
 * @Description: 车的可用捕获量
 * @Author: LiaNg
 * @Date: 2020/3/26 19:19
 */
public class L999 {

    public static void main(String[] args) {
        L999 l999 = new L999();

        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};

        System.out.println("l999.numRookCaptures(board) = " + l999.numRookCaptures(board));
    }

    /**
     * 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
     * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
     * 返回车能够在一次移动中捕获到的卒的数量。
     * 提示：
     * board.length == board[i].length == 8
     * board[i][j] 可以是 'R'，'.'，'B' 或 'p'
     * 只有一个格子上存在 board[i][j] == 'R'
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/available-captures-for-rook
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int numRookCaptures(char[][] board) {

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (board[i][j] == 'R') {
                    int res = 0;
                    for (int[] direction : directions) {
                        if (burnout(board, i, j, direction)) {
                            res++;
                        }
                    }
                    return res;
                }
            }
        }

        return 0;
    }

    /**
     * burnout 横冲直撞的意思（来自欧路词典）
     *
     * @param board 输入棋盘
     * @param x 当前白象位置的横坐标
     * @param y 当前白象位置的纵坐标
     * @param direction 方向向量
     * @return 消灭一个 p，就返回 true
     */
    private boolean burnout(char[][] board, int x, int y, int[] direction) {
        int i = x;
        int j = y;
        while (inArea(i, j)) {
            if (board[i][j] == 'B') {
                break;
            }

            if (board[i][j] == 'p') {
                return true;
            }

            i += direction[0];
            j += direction[1];
        }
        return false;
    }

    /**
     * @param i 当前位置横坐标
     * @param j 当前位置纵坐标
     * @return 是否在棋盘有效范围内
     */
    private boolean inArea(int i, int j) {
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }
}
