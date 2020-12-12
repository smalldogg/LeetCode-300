package 双指针;

/**
 * @author wangyh
 * @create 2020-08-03 17:44
 */

public class 字符串相加 {
    public String addStrings(String nums1, String nums2) {
        char[] chs1 = nums1.toCharArray();
        char[] chs2 = nums2.toCharArray();
        int carry = 0;
        int idx1 = chs1.length - 1;
        int idx2 = chs2.length - 1;
        StringBuilder sb = new StringBuilder();
        while (idx1 >= 0 || idx2 >= 0) {
            int num1 = idx1 >= 0 ? chs1[idx1] - '0' : 0;
            int num2 = idx2 >= 0 ? chs2[idx2] - '0' : 0;
            int cur = num1 + num2 + carry;
            carry = cur / 10;
            sb.append(cur % 10);
            idx1--;
            idx2--;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
