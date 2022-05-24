package hj;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author: zhangjin
 * @Date: 2022/05/24/20:19
 * @Description: goto https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D37%26type%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < number; i++) {
            integers.add(in.nextInt());
        }
        integers.forEach(e -> System.out.println(e));
    }

    public static void solution2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            int[] arr = new int[1001];
            for (int i = 0; i < num; i++) {
                int n = scanner.nextInt();
                arr[n] = 1;
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 1) {
                    System.out.println(i);
                }
            }
        }
    }
}
