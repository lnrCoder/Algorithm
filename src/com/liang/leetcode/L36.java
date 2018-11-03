package com.liang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName L36
 * @description valid-sudoku
 * @Author LiaNg
 * @Date 2018/11/3
 */
public class L36 {

    /**
     * 有效的数独
     */
    public static void main(String[] args) {
        char[][] chars = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        L36 l = new L36();
        System.out.println(l.isValidSudoku(chars));
    }

    private static int length = 9;
    public static char[][] charBoard;

    /**
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     */
    public boolean isValidSudoku(char[][] board) {

        charBoard = board;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (charBoard[i][j] =='.') {
                    continue;
                }
                if (checkRow(i, j) && checkCol(i, j) && checkSquared(i, j)) {
                    continue;
                }else{

                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkRow(int row, int col) {
        for (int i = col+1; i < length; i++) {
            if (charBoard[row][col] == charBoard[row][i] && i != col) {
                System.out.println(i+"列内有重复数字"+charBoard[row][col]);
                return false;
            }
        }
        return true;
    }

    public static boolean checkCol(int row, int col) {
        for (int i = row+1; i < length; i++) {
            if (charBoard[row][col] == charBoard[i][col] && i != row) {
                System.out.println(i+"行内有重复数字"+charBoard[row][col]);
                return false;
            }
        }
        return true;
    }

    public static boolean checkSquared(int row, int col) {
        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();

        squaredList(row, rowList);
        squaredList(col, colList);

        for (Integer r : rowList) {
            for (Integer c : colList) {
                if(charBoard[row][col] == charBoard[r][c]){
                    System.out.println("row:"+row+"，col:"+col+"，所在"+" 3*3 宫内有重复数字"+charBoard[row][col]);
                    return false;
                }
            }
        }
        return true;
    }

    private static void squaredList(int n, List<Integer> rowList) {
        switch (n % 3) {
            case 0: {
                rowList.add(n + 1);
                rowList.add(n + 2);
                break;
            }
            case 1: {
                rowList.add(n-1);
                rowList.add(n+1);
                break;
            }
            case 2: {
                rowList.add(n-1);
                rowList.add(n-2);
                break;
            }
        }
    }
}
