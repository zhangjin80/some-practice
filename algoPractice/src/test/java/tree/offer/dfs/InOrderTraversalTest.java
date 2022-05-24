package tree.offer.dfs;

import org.junit.After;
import org.junit.Test;
import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: zhangjin
 * @Date: 2022/02/12/10:45 上午
 * @Description:
 */
public class InOrderTraversalTest {
    @Test
    public void inOrderTraversalStack() {
        Integer[] initArr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = TreeUtil.createBinaryTreeByArray(initArr);
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        List<Integer> result = inOrderTraversal.inOrderTraversalStack(root);
        result.forEach(e -> System.out.print(e + "\t"));
    }

    @Test
    public void inOrderTraversal() {
        Integer[] initArr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = TreeUtil.createBinaryTreeByArray(initArr);
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        List<Integer> result = inOrderTraversal.inOrderTraversal(root);
        result.forEach(e -> System.out.print(e + "\t"));
    }
}