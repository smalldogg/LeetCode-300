package DFS;

import java.util.HashSet;
import java.util.Set;

public class n皇后2 {
    Set<Integer> col = new HashSet<>();
    Set<Integer> dif = new HashSet<>();
    Set<Integer> sum = new HashSet<>();
    int res = 0;


    public int totalNQueens(int n) {
        dfs(0, n);
        return res;
    }

    private void dfs(int level, int n) {
        if (level == n) {
            res++;
            return;
        }
        //依次枚举每一列
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !dif.contains(level + i) && !sum.contains(level - i)) {
                col.add(i);
                dif.add(level + i);
                sum.add(level - i);

                dfs(level + 1, n);

                col.remove(i);
                dif.remove(level + i);
                sum.remove(level - i);
            }
        }
    }
}
