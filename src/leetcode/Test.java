package leetcode;

/**
 * @Description:
 * @Auther: hanshihao
 * @Date: 2023/06/15/11:47
 */

import java.util.ArrayList;

/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 *
 * 输入：candidates = [2,3,6,7], target = 5
 * 输出：[[2,2,3],[7]]
 */
public class Test {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;


    }
    public static ArrayList<ArrayList<Integer>> getTarget(int[] candidates ,int target){
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        ArrayList<Integer> temp = new ArrayList<>();

        int len = candidates.length;
        if(candidates == null || len ==0) return res;

        dfs(candidates,target,res,temp,0);
        return res;
    }

    private static void dfs(int[] candidates, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int num) {


    }
}
