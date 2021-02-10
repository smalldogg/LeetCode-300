package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        help(nums, 0, list, results);
        return results;
    }

    //1.递归的定义：找到所有子集
    private void help(int[] nums, int start, List<Integer> list, List<List<Integer>> results) {
        //3.递归的出口
        results.add(new ArrayList<>(list));
        //2.递归的拆解
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            help(nums, i + 1, list, results);
            list.remove(list.size() - 1);
        }
    }


    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> results) {
        results.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; ++i) {
            list.add(nums[i]);
            dfs(nums, i + 1, list, results);
            list.remove(list.size() - 1);
        }
    }


}
