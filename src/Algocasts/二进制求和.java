package Algocasts;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author wangyh
 * @create 2020-06-23 19:52
 */

public class 二进制求和 {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String plainText = "admin";
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        System.out.println(md5code);
    }




    public static String addBinary(String a, String b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        char[] chsa = a.toCharArray();
        char[] chsb = b.toCharArray();
        int idxa = chsa.length - 1, idxb = chsb.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (idxa >= 0 || idxb >= 0) {
            int x1 = idxa >= 0 ? chsa[idxa--] - '0' : 0;
            int x2 = idxb >= 0 ? chsb[idxb--] - '0' : 0;
            int cur = (x1 + x2 + carry) % 2;
            carry = (x1 + x2 + carry) / 2;
            sb.append(cur);
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
