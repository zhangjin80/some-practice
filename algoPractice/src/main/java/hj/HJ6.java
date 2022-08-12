package hj;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhangjin
 * @Date: 2022/08/01/16:02
 * @Description: 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 */
public class HJ6 {
    public static void main(String[] args) {
        List<Integer> primeFactor = getPrimeFactor2(180);
        System.out.println(primeFactor);
    }

    public static List<Integer> getPrimeFactor(int num) {
        List<Integer> reList = new ArrayList<>();
        int k = 2;
        while (num >= k) {
            if (num == k) {
                reList.add(k++);
            }
            if (num % k == 0) {
                reList.add(k);
                num = num / k;
            } else {
                k++;
            }
        }
        return reList;
    }

    public static List<Integer> getPrimeFactor2(int num) {
        List<Integer> reList = new ArrayList<>();
        long k = (long) Math.sqrt(num);
        for (int i = 2; i <= k; i++) {
            while (num % i == 0) {
                reList.add(i);
                num /= i;
            }
        }
        return reList;
    }


}
