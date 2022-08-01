package hj;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author: zhangjin
 * @Date: 2022/05/24/20:19
 * @Description: goto https://www.nowcoder.com/practice/3245215fffb84b7b81285493eae92ff0?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D37%26type%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * 明明生成了NN个1到500之间的随机整数。请你删去其中重复的数字，即相同的数字只保留一个，把其余相同的数去掉，然后再把这些数从小到大排序，按照排好的顺序输出。
 * 数据范围： 1≤n≤1000  ，输入的数字大小满足 1≤val≤500
 * 输入描述：
 * 第一行先输入随机整数的个数 N 。 接下来的 N 行每行输入一个整数，代表明明生成的随机数。 具体格式可以参考下面的"示例"。
 * 输出描述：
 * 输出多行，表示输入数据处理后的结果
 */
public class HJ3 {
    public static void main(String[] args) {
        System.out.print("请输入数字的个数：\t");
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        TreeSet<Integer> integers = new TreeSet<>();
        for (int i = 0; i < number; i++) {
            System.out.print(String.format("请输入第%s个随机数：\t", i + 1));
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
