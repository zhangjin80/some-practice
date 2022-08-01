package hj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: zhangjin
 * @Date: 2022/07/26/11:31
 * @Description: •输入一个字符串，请按长度为8拆分每个输入字符串并进行输出；
 * <p>
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述：
 * 连续输入字符串(每个字符串长度小于等于100)
 * <p>
 * 输出描述：
 * 依次输出所有分割后的长度为8的新字符串
 */
public class HJ4 {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //String text = in.nextLine();
        String text = "1234567890abcdef";
        StringBuffer sb = new StringBuffer(text);
        int mod = text.length() % 8;
        if (mod > 0) {
            int fillSize = 8 - mod;
            for (int i = 0; i < fillSize; i++) {
                sb.append(0);
            }
        }

        List<String> lists = new ArrayList<>();
        for (int i = 0; i <= sb.length() - 8; i = i + 8) {
            String substring = sb.substring(i, i + 8);
            lists.add(substring);
        }

        System.out.println(lists);

    }
}
