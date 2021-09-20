package basic;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangjin
 * @date 2021-09-11 13:40
 * 微软第一次笔试题
 */

class MicroPreview {
    /**
     * 四种类型的箭头，要让所有箭头方向都一致，至少要翻转几个
     *
     * @param str
     * @return
     */
    public int numberOfFlippedArrows(String str) {
        int leftArrowSize = 0, rightArrowSize = 0, upArrowSize = 0, downArrowSize = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                leftArrowSize++;
            } else if (str.charAt(i) == '>') {
                rightArrowSize++;
            } else if (str.charAt(i) == '^') {
                upArrowSize++;
            } else {
                downArrowSize++;
            }
        }
        return (leftArrowSize + rightArrowSize + upArrowSize + downArrowSize)
                -
                Math.max(Math.max(
                        Math.max(leftArrowSize, rightArrowSize), upArrowSize)
                        , downArrowSize
                );
    }

    public void testNumberOfFlippedArrows() {
        System.out.println(numberOfFlippedArrows("v>>>vv"));
    }


    /**
     * 输入一个二进制，偶数就除以2，奇数就减1，需要几次最终转为0
     *
     * @param str
     * @return
     */
    public int binaryToZeroSize(String str) {
        boolean start = false;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            boolean isZero = false;
            if (str.charAt(i) == '0') {
                isZero = true;
            }
            if (!isZero && !start) {
                start = true;
                res++;
                continue;
            }
            if (start) {
                if (isZero) {
                    res++;
                } else {
                    res += 2;
                }
            }
        }
        return res;
    }

    public void testBinaryToZeroSize() {
        System.out.println(binaryToZeroSize("011100"));
    }

    /**
     * 求大小写平衡的最大子序列
     * @param str
     * @return
     */
    public int getMaxCasebalancince(String str) {
        int result = -1;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> existsChar = new HashSet<>();
            existsChar.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                final char c = str.charAt(j);
                char reversChar = caseReversal(c);
                existsChar.add(str.charAt(j));
                if (existsChar.contains(reversChar)) {
                    if (isBlance(existsChar)) {
                        result = Math.max(result, j - i + 1);
                    }
                }
            }
        }
        return result;
    }

    private boolean isBlance(Set<Character> existsChar) {
        if (existsChar.size() % 2 != 0) {
            return false;
        }
        boolean re = true;
        for (Character c : existsChar) {
            Character balanceChar = caseReversal(c);
            if (!existsChar.contains(balanceChar)) {
                re = false;
                break;
            }
        }
        return re;
    }
    private char caseReversal(char c) {
        if (c >= 65 && c <= 90) {
            return (char) (c + 32);
        } else {
            return (char) (c - 32);
        }
    }

    public void testGetMaxCasebalancince() {
        System.out.println(getMaxCasebalancince("abAB"));
        System.out.println(getMaxCasebalancince("abA"));
        System.out.println(getMaxCasebalancince(""));
        System.out.println(getMaxCasebalancince("abAAcB"));
        System.out.println(getMaxCasebalancince("abAAcBC"));

    }

    public static void main(String[] args) {
        final MicroPreview microPreview = new MicroPreview();
        microPreview.testGetMaxCasebalancince();
    }

}
