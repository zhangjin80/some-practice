package basic;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode 14. 最长公共前缀
 *
 * goto https://leetcode.cn/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public static String myLongestCommonPrefix(String[] strs) {
        String result = "";
        int minLenth = Integer.MAX_VALUE;
        for (String str : strs) {
            minLenth = minLenth < str.length() ? minLenth : str.length();
        }
        for (int i = 0; i < minLenth; i++) {
            Set<Character> oneSet = new HashSet<>();
            for (int j = 0; j < strs.length; j++) {
                oneSet.add(strs[j].charAt(i));
            }
            if (oneSet.size() > 1) {
                break;
            } else {
                result = result + oneSet.iterator().next();
            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private static String getCommonPrefix(String prefix, String str) {
        int index = 0;
        int minLenth = Math.min(prefix.length(), str.length());
        while (index < minLenth) {
            if (prefix.charAt(index) == str.charAt(index)) {
                index++;
            } else {
                break;
            }
        }
        return prefix.substring(0, index);

    }


    public static void main(String[] args) {

    }
}
