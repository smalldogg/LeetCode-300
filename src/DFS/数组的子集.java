package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangyh
 * @create 2020-02-13 15:57
 */

public class 数组的子集 {
    public List<List<Integer>> subsetsRecursive(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void subsets(int[] nums, int start,
                         List<Integer> elem, List<List<Integer>> result) {
        result.add(new ArrayList<>(elem));
        for (int i = start; i < nums.length; ++i) {
            elem.add(nums[i]);
            subsets(nums, i + 1, elem, result);
            elem.remove(elem.size() - 1);
        }
    }
}
