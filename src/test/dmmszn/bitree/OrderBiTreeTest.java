package dmmszn.bitree;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void posOrderUnRecur() {
        Integer[] expect = {4, 5, 2, 6, 7, 3, 1};
        List<Integer> integers = orderBiTree.posOrderUnRecur(head);
        Assert.assertArrayEquals(integers.toArray(), expect);
    }

    @Test
    public void inOrderUnRecur() {
        Integer[] expect = {4, 2, 5, 1, 6, 3, 7};
        List<Integer> integers = orderBiTree.inOrderUnRecur(head);
        Assert.assertArrayEquals(integers.toArray(), expect);
    }

    @Test
    public void preOrderUnRecur() {
        Integer[] expect = {1, 2, 4, 5, 3, 6, 7};
        List<Integer> integers = orderBiTree.preOrderUnRecur(head);
        Assert.assertArrayEquals(integers.toArray(), expect);
    }

    @Test
    public void preOrder() {
        Integer[] expect = {1, 2, 4, 5, 3, 6, 7};
        List<Integer> actual = orderBiTree.preOrder(head);
        Assert.assertArrayEquals(actual.toArray(), expect);
    }

    @Test
    public void levelOrder() {
        Integer[] expect = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> actual = orderBiTree.levelOrder(head);
        Assert.assertArrayEquals(actual.toArray(), expect);


    }

    @Test
    public void levelOrder2() {
        List<List<Integer>> expect = new ArrayList<>();
        expect.add(Lists.newArrayList(1));
        expect.add(Lists.newArrayList(2, 3));
        expect.add(Lists.newArrayList(4, 5, 6, 7));
        List<List<Integer>> actual = orderBiTree.levelOrder2(head);
        Assert.assertEquals(expect, actual);
    }
}