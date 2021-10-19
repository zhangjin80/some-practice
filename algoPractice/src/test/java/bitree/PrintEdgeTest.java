package bitree;

import bitree.util.TreeUtil;
import org.junit.Assert;
import org.junit.Test;

public class PrintEdgeTest {
    PrintEdge printEdge;
    TreeNode head;

    public PrintEdgeTest() {
        Integer[] arr = {
                1,
                2, 3,
                null, 4, 5, 6,
                null, null, 7, 8, 9, 10, null, null,
                null, null, null, null, null, null, null, 11, 12, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, 13, 14, 15, 16, null, null, null, null, null, null, null, null, null, null, null, null, null, null
        };
        this.head = TreeUtil.createBinaryTreeByArray(arr);
        printEdge = new PrintEdge();
    }

    @Test
    public void printEdgeM1() {

    }

    @Test
    public void getTreeHeigh() {
        Assert.assertEquals(new Integer(6), printEdge.getTreeHeigh(head));
        new OrderBiTree().preOrder(head).forEach(v -> System.out.print(v + "\t"));
    }

    @Test
    public void genEdgeNodeMatrix() {
        TreeNode[][] treeNodes = new TreeNode[6][2];
        printEdge.genEdgeNodeMatrix(head, treeNodes);
        for (TreeNode[] treeNode : treeNodes) {
            for (TreeNode node : treeNode) {
                System.out.print(node.val + "\t");
            }
            System.out.println();
        }
    }

}