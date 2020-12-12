package DFS;

import java.util.ArrayList;
import java.util.List;

public class 分割回文串 {
    //n 个字母的组合问题  就是n - 1 个的组合问题
    // n - 1个组合问题
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), s, 0);
        return results;
    }

    private void dfs(List<List<String>> results, List<String> list, String str, int index) {
        if (index == str.length()) {
            results.add(new ArrayList<String>(list));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            String subString = str.substring(index, i + 1);
            if (!isPalindrome(subString)) {
                continue;
            }
            list.add(subString);
            dfs(results, list, str, i + 1);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

}
