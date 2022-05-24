package tree.offer.bfs;

import org.junit.Assert;
import org.junit.Test;
import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.List;

/**
 * @Author: zhangjin
 * @Date: 2022/01/13/12:00 下午
 * @Description:
 */
public class BiTreeBFSTest {

    @Test
    public void bfs() {
        Integer[] initArr = {8, 6, 10, 5, 7, 9, 11};
        TreeNode root = TreeUtil.createBinaryTreeByArray(initArr);
        BiTreeBFS biTreeBFS = new BiTreeBFS();
        List<Integer> bfsResult = biTreeBFS.bfs(root);
        Assert.assertArrayEquals(initArr, bfsResult.toArray());
    }

    @Test
    public void levelOrder() {
        Integer[] initArr = {8, 6, 10, 5, 7, 9, 11};
        TreeNode root = TreeUtil.createBinaryTreeByArray(initArr);
        BiTreeBFS biTreeBFS = new BiTreeBFS();
        List<List<Integer>> bfsResult = biTreeBFS.levelOrder(root);
        System.out.println(bfsResult);
    }
}