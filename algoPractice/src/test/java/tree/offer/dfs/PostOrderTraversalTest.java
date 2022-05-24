package tree.offer.dfs;

import org.junit.Test;
import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhangjin
 * @Date: 2022/02/12/11:28 上午
 * @Description:
 */
public class PostOrderTraversalTest {

    @Test
    public void postOrderTraversalStatck() {
        Integer[] initArr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = TreeUtil.createBinaryTreeByArray(initArr);
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        List<Integer> nodes = postOrderTraversal.postOrderTraversalStatck(root);
        nodes.forEach(e -> System.out.print(e + "\t"));
    }
}