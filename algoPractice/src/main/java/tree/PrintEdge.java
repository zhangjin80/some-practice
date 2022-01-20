package tree;

import tree.common.TreeNode;

/**
 * 打印二叉树的边界节点
 * 【题目】
 * 给定一棵二叉树的头节点head，按照如下两种标准分别实现二叉树边界节点的逆时针打印。标准一：
 * 1.头节点为边界节点。
 * 2.叶节点为边界节点。
 * 3.如果节点在其所在的层中是最左的或最右的，那么该节点也是边界节点。标准二：
 * 1.头节点为边界节点。
 * 2.叶节点为边界节点。
 * 3.树左边界延伸下去的路径为边界节点。
 * 4.树右边界延伸下去的路径为边界节点。
 * 按标准一的打印结果为：1，2，4，7，11，13，14，15，16，12，10，6，3
 * 按标准二的打印结果为：1，2，4，7，13，14，15，16，10，6，3
 * 【要求】
 * 1.如果节点数为N，两种标准实现的时间复杂度要求都为O（N），额外空间[…]”
 */
public class PrintEdge {

    public void PrintEdgeM1(TreeNode head) {
        if (head == null) {
            return;
        }
        int heigh = getTreeHeigh(head);
        TreeNode[][] edgeNodeMatrix = new TreeNode[heigh][2];
        genEdgeNodeMatrix(head, edgeNodeMatrix);
        printLeftEdgeNode(head, 0, edgeNodeMatrix);
//        printLeaf(head, 0, edgeNode);
//        printRightEdgeNode(head, 0, edgeNode);
    }

    public void genEdgeNodeMatrix(TreeNode head, TreeNode[][] edgeNodeMatrix) {
        genEdgeNodeMatrix(head, edgeNodeMatrix, 0);


    }

    private void genEdgeNodeMatrix(TreeNode head, TreeNode[][] edgeNodeMatrix, int lay) {
        if (head == null) {
            return;
        }
        edgeNodeMatrix[lay][0] = edgeNodeMatrix[lay][0] == null ? head : edgeNodeMatrix[lay][0];
        edgeNodeMatrix[lay][1] = head;
        genEdgeNodeMatrix(head.left, edgeNodeMatrix, lay + 1);
        genEdgeNodeMatrix(head.right, edgeNodeMatrix, lay + 1);
    }


    private void printLeftEdgeNode(TreeNode head, int i, TreeNode[][] edgeNodeMatrix) {


    }


    public Integer getTreeHeigh(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return Math.max(getTreeHeigh(head.left) + 1, getTreeHeigh(head.right) + 1);
    }
}
