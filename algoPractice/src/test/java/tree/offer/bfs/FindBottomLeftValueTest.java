package tree.offer.bfs;

import org.junit.Assert;
import org.junit.Test;
import tree.common.TreeNode;
import tree.common.TreeUtil;

/**
 * @Author: zhangjin
 * @Date: 2022/02/12/9:40 上午
 * @Description:
 */
public class FindBottomLeftValueTest {

    @Test
    public void findBottomLeftValue() {
        Integer[] initArr = {8, 6, 10, 5, 7, 9, 11};
        TreeNode root = TreeUtil.createBinaryTreeByArray(initArr);
        FindBottomLeftValue findBottomLeftValue = new FindBottomLeftValue();
        Integer bottomLeftValue = findBottomLeftValue.findBottomLeftValue(root);
        Assert.assertEquals(5, bottomLeftValue.intValue());
    }
}