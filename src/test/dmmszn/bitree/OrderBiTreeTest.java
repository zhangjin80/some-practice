package dmmszn.bitree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderBiTreeTest {
    OrderBiTree orderBiTree = new OrderBiTree();
    TreeNode head;

    public OrderBiTreeTest() {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7};
        this.head = TreeNode.createBinaryTreeByArray(arr);
    }

    @Test
    public void posOrderNoRecur() {
        Integer[] expect = {4, 5, 2, 6, 7, 3, 1};
        List<Integer> integers = orderBiTree.posOrderNoRecur(head);
        Assert.assertArrayEquals(integers.toArray(), expect);
    }

    @Test
    public void inOrderNoRecur() {
        Integer[] expect = {4, 2, 5, 1, 6, 3, 7};
        List<Integer> integers = orderBiTree.inOrderNoRecur(head);
        Assert.assertArrayEquals(integers.toArray(), expect);
    }

    @Test
    public void preOrderNoRecur() {
        Integer[] expect = {1, 2, 4, 5, 3, 6, 7};
        List<Integer> integers = orderBiTree.preOrderNoRecur(head);
        Assert.assertArrayEquals(integers.toArray(), expect);
    }

    @Test
    public void preOrder() {
        Integer[] expect = {1, 2, 4, 5, 3, 6, 7};
        List<Integer> actual = orderBiTree.preOrder(head);
        Assert.assertArrayEquals(actual.toArray(), expect);
    }
}