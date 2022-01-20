package tree.common;

/**
 * @Author: zhangjin
 * @Date: 2021/10/18/2:41 下午
 * @Description:
 */
public class TreeUtil {
    public static TreeNode createBinaryTreeByArray(Integer[] array) {
        return createBinaryTreeByArray(array, 0);
    }


    private static TreeNode createBinaryTreeByArray(Integer[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value != null) {
                tn = new TreeNode(value);
                tn.left = createBinaryTreeByArray(array, 2 * index + 1);
                tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            }
        }
        return tn;
    }
}
