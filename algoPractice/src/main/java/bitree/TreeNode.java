package bitree;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

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

    /**
     * 反序列化
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Integer index = 0;
        return dfs(split, index);
    }

    private TreeNode dfs(String[] data, Integer index) {
        String str = data[index];
        if (str.equals("#")) {
            return null;
        }

        TreeNode curNode = new TreeNode(Integer.valueOf(str));

        index = index + 1;
        curNode.left = dfs(data, index);
        curNode.right = dfs(data, index);
        return curNode;
    }
}
