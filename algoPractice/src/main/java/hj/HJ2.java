package hj;

import java.util.Scanner;

/**
 * @Author: zhangjin
 * @Date: 2022/05/24/19:56
 * @Description:  goto https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&rp=1&ru=%2Fexam%2Foj%2Fta&qru=%2Fexam%2Foj%2Fta&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D37%26type%3D37&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */
public class HJ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        String target = in.nextLine();
        System.out.println(countChar(str, target));
    }

    public static int countChar(String line, String target) {
        int length = line.toUpperCase().replace(target.toUpperCase(), "").length();
        return line.length() - length;
    }
}
