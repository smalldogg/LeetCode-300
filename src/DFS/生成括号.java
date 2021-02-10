package DFS;

import java.util.ArrayList;
import java.util.List;

public class 生成括号 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result, n, 0, 0, "");
        return result;
    }

    //没有改变cur
    private void dfs(List<String> result, int n, int nleft, int nright, String cur) {
        if (n == nleft && n == nright) {
            result.add(cur);
            return;
        }
        if (nleft < n) {
            dfs(result, n, nleft + 1, nright, cur + "(");
        }
        if (nright < nleft) {
            dfs(result, n, nleft, nright + 1, cur + ")");
        }
    }
}
