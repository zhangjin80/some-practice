package hj;

import java.util.Scanner;

/**
 * @Author: zhangjin
 * @Date: 2022/05/24/19:56
 * @Description:  goto https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D37%26type%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围： 1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字符。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 */
public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        System.out.print("输入一个句子：");
        String str = in.nextLine();
        System.out.print("输入一个单词：");
        String target = in.nextLine();
        System.out.print("该单词在句子中出现的次数：");
        System.out.println(countChar(str, target));
    }

    public static int countChar(String line, String target) {
        int length = line.toUpperCase().replace(target.toUpperCase(), "").length();
        return line.length() - length;
    }
}
