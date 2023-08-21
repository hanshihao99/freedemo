package leetcode.zijie;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/04/23/23:13
 * 一面是排序链表
 * 二面是全排列 （有重复元素 和 无重复元素） + 岛屿数量（四个方向与八个方向）
 * 反转链表 II
 */

// 全排列
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = new Solution().permute(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if(len == 0) return res;
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums , len ,0, path , used , res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if(depth == len){
            res.add(new ArrayList<Integer>(path));
            return ;
        }

        for (int i = 0; i < len; i++) {
            if(used[i]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            System.out.println("  递归之前 => " + path);

            dfs(nums , len , depth + 1 ,path , used , res);

            System.out.println("  递归之后 => " + path);
            path.removeLast();
            used[i] = false;
        }
    }
}
