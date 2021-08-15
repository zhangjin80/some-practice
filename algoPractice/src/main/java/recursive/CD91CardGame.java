package recursive;

/**
 * @author zhangjin
 * @date 2021-08-08 13:04
 * CD91 排成一条线的纸牌博弈问题
 */
public class CD91CardGame {
    public static void main(String[] args) {
        int[] arr = {1, 2, 100, 200,300,100, 4};
        System.out.println(getMaxScore(arr));

    }

    public static int getMaxScore(int[] arr) {
        return Math.max(early(arr, 0, arr.length - 1), late(arr, 0, arr.length - 1));
    }


    private static int early(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];
        }
        return Math.max(arr[start] + late(arr, start + 1, end),
                arr[end] + late(arr, start, end - 1));
    }

    private static int late(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        return Math.min(early(arr, start + 1, end), early(arr, start, end - 1));
    }
}
