package tree.util;

import tree.common.TreeNode;
import tree.TreeSerializeDeserialize;
import org.junit.Test;

/**
 * @Author: zhangjin
 * @Date: 2021/10/18/2:44 下午
 * @Description:
 */
public class TreeUtilTest {

    @Test
    public void deserialize() {
        TreeNode node = TreeSerializeDeserialize.deserialize("1,2,3,null,null,4,5");
        System.out.println(node);
        String serialize = TreeSerializeDeserialize.serialize(node);
        System.out.println(serialize);
        TreeNode deserialize = TreeSerializeDeserialize.deserialize(serialize);
        System.out.println(deserialize);
        String serialize1 = TreeSerializeDeserialize.serialize(deserialize);
        System.out.println(serialize1);
    }
}