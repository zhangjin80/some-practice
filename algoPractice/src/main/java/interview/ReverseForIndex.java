package interview;

/**
 * 给定一个数组，如 [2,4,5,1,7,8,9]
 * 指定其中任一下标，两边对调，比如指定下标2，对应的值为5，最终对调结果为 [1,7,8,9,5,2,4]
 * 要求：空间复杂度 O(1)
 * index:2,length:7
 *
 * @author zhangjin
 * @date 2021-05-19 15:31
 */
public class ReverseForIndex {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 1, 7, 8, 9};
        /**
         * 方法一
         * 8451729
         * 8951724 ok
         * 1895724
         * 1789524
         *
         *
         * 方法二
         * 1452789
         * 1752489 ok
         * 1785249
         * 1789524
         */

        reverseArrForIndex(arr, 5);
        for (int i : arr) {
            System.out.print(i);
        }
    }

    public static void reverseArrForIndex(int[] arr, int index) {
        reverseArr(arr, 0, arr.length);
        int revserIndex = arr.length - 1 - index;
        reverseArr(arr, 0, revserIndex);
        reverseArr(arr, revserIndex + 1, arr.length);
    }

    private static void reverseArr(int[] arr, int start, int end) {
        for (int i = start; i < end / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[end - 1 - i];
            arr[end - 1 - i] = tmp;
        }
    }

    public static void reverForIndex(int[] arr, int index) {
        for (int i = 0; i < index; i++) {
            int tmp = arr[index + i + 1];
            arr[index + i + 1] = arr[i];
            arr[i] = tmp;
        }
        int stop = index;
        for (int i = arr.length - index; i < arr.length; i++) {
            int tmp = arr[i];
            int point = i;
            while (point > stop) {
                arr[point] = arr[point - 1];
                point--;
            }
            arr[point] = tmp;
            stop++;
        }
    }

    public static void reverseForIndex(int[] arr, int index) {
        for (int i = 0; i < index; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - index + i];
            arr[arr.length - index + i] = temp;
        }

        int stop = 0;
        for (int point = index + 1; point < arr.length - index; point++) {
            int tmp = arr[point];
            int f = point;
            while (f > stop) {
                arr[f] = arr[f - 1];
                f--;
            }
            arr[f] = tmp;
            stop++;
        }
    }
}
