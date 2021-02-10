package 数据结构;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        dfs(n, 0, 0, results, "");
        return results;
    }

    private void dfs(int n, int left, int right, List<String> results, String cur) {
        if (left == n && right == n) {
            results.add(cur);
            return;
        }
        if (left < n) {
            dfs(n, left + 1, right, results, cur + "(");
        }
        if (right < left) {
            dfs(n, left, right + 1, results, cur + ")");
        }
    }
}
