package sort;

import java.util.Arrays;

/**
 * 插入排序
 * 从第二位开始
 * 先保存好当前数值位target
 * 把j赋值给i
 * 如果j-1的值大于target就向后覆盖表j的值
 * j不断--，知道为0，或者值小于target
 * 第二层循环完之后把target的值赋给j
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        if (arr == null && arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > target) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 1, 5, 7};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));

    }

}
