package search.binary;

import org.junit.Assert;
import org.junit.Test;

/**
 * @Author: zhangjin
 * @Date: 2021/10/31/3:40 下午
 * @Description: 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
 * <p>
 * 正数的平方根有两个，只输出其中的正数平方根。
 * <p>
 * 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: x = 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: x = 8
 * 输出: 2
 * 解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
 */
public class Mysqrt {
    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (start == end || start + 1 == end) {
                break;
            } else if (mid * mid > x) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        if (end * end <= x) {
            return end;
        } else {
            return start;
        }
    }

    /**
     * 方法二
     */
    public int mySqrt2(int x) {
        int left = 1;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, mySqrt2(4));
        Assert.assertEquals(2, mySqrt2(8));
    }
}
