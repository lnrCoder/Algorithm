package com.leetcode_new.editor.cn;

//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 10⁴ 
// arr.length 是偶数 
// -10⁵ <= arr[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 排序 👍 158 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * 954 二倍数对数组
 * @date 2022-04-01 23:16:30
 * @author shang.liang
 */
 public class ArrayOfDoubledPairs{
    public static void main(String[] args){
        Solution soution = new ArrayOfDoubledPairs().new Solution();
        
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canReorderDoubled(int[] arr) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (Integer num :map.keySet()){
            list.add(num);
        }

        Collections.sort(list, (a, b) -> Math.abs(a) - Math.abs(b));

        for (Integer integer : list) {

            if (map.getOrDefault(integer * 2, 0) < map.get(integer)) {
                return false;
            }

            map.put(integer * 2, map.getOrDefault(integer * 2, 0) - map.get(integer));

        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

 }
