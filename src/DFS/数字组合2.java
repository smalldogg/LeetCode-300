package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 数字组合2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> results = new ArrayList<>();

        if (num == null) {
            return results;
        }
        Arrays.sort(num);
        dfs(num, 0, target, 0, new ArrayList<>(), results);
        return results;
    }

    private void dfs(int[] nums, int start, int target, int curSum, List<Integer> list, List<List<Integer>> results) {
        if (curSum == target) {
            results.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target - curSum) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1] && i != start) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, i + 1, target, curSum + nums[i], list, results);
            list.remove(list.size() - 1);
        }
    }
}
