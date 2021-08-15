package jzoffer;

/**
 * 把字符串前n位的子串移动到末尾
 */
public class Offer58II_reverseLeftWords {
    public String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=n;i<s.length();i++){
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {

    }
}
