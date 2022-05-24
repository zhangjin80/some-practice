package tree.offer.bfs;

import org.junit.Assert;
import org.junit.Test;
import tree.common.TreeNode;
import tree.common.TreeUtil;

import java.util.List;

/**
 * @Author: zhangjin
 * @Date: 2022/02/12/9:50 上午
 * @Description:
 */
public class RightSideViewTest {

    @Test
    public void rightSideView() {
        Integer[] initArr = {8, 6, 10, 5, 7};
        TreeNode root = TreeUtil.createBinaryTreeByArray(initArr);
        RightSideView rightSideView = new RightSideView();
        List<Integer> view = rightSideView.rightSideView(root);
        view.forEach(System.out::println);
        Integer[] expectArr = {8, 10, 7};
        Assert.assertArrayEquals(expectArr, view.toArray());
    }
}