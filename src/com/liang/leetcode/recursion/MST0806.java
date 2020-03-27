package com.liang.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MST0806
 * @Description: 汉诺塔问题
 * @Author: LiaNg
 * @Date: 2020/3/27 22:50
 */
public class MST0806 {

    public static void main(String[] args) {

        MST0806 mst0806 = new MST0806();
        
        List<Integer> A = new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        mst0806.hanota(A, B, C);

        System.out.println("C = " + C);
    }

    /**
     * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上 (即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
     * (1) 每次只能移动一个盘子；
     * (2) 盘子只能从柱子顶端滑出移到下一根柱子；
     * (3) 盘子只能叠在比它大的盘子上。
     * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
     * 你需要原地修改栈。
     * 提示:
     * A 中盘子的数目不大于 14 个。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hanota-lcci
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    public void move(int size, List<Integer> A, List<Integer> B, List<Integer> C) {

        if (size == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }
        move(size - 1, A, C, B);
        C.add(A.remove(A.size() - 1));
        move(size - 1, B, A, C);
    }
}
