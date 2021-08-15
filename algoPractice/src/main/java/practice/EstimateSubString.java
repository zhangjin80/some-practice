package practice;

/**
 * 查找子串
 * i从0开始一直到数组主串长度-子串长度为止
 * 如果第一个字符和第一个字符相等才进行第二层循环比较
 * j从0开始，主串的从i+j开始
 * 如果有一个不匹配就退出
 * 每次都判断j是否和子串长度一致，一致则表示找到
 */
public class EstimateSubString {
    public static void main(String[] args) {
        String s = "goodgoogle";
        String t = "google";
        System.out.println(isSub(s, t));
    }
    public static Boolean isSub(String base, String sub) {
        Boolean isFind = false;
        for (int i = 0; i < base.length() - sub.length() + 1; i++) {
            if (base.charAt(i) == sub.charAt(0)) {
                for (int j = 0; j < sub.length(); j++) {
                    if (base.charAt(i + j) != sub.charAt(j)) {
                        break;
                    }
                    if (j == sub.length() - 1) {
                        isFind = true;
                    }
                }
            }
        }
        return isFind;
    }

}
