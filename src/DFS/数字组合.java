package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数字组合 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs(candidates, target, 0, 0, list, results);
        return results;
    }

    //1.递归的定义：找到所有和为target的组合
    private void dfs(int[] nums, int target, int curSum, int start, List<Integer> list,
                     List<List<Integer>> results) {
        //3.递归的出口
        if (curSum == target) {
            results.add(new ArrayList<>(list));
            return;
        }
        //2.递归的拆解
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target - curSum) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, target, curSum + nums[i], i, list, results);
            list.remove(list.size() - 1);
        }
    }
}
