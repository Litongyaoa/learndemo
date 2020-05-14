package datatype;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DataType {

    @Test
    public void test1() {
        Collection col = new ArrayList();
        col.contains(1);//遍历比较


        // public static native void arraycopy(Object src,  int  srcPos,  Object dest, int destPos,   int length);
        // 从指定源数组中复制一个数组，复制从指定的位置开始，到目标数组的指定位置结束。
        // 从 src 引用的源数组到 dest 引用的目标数组，数组组件的一个子序列被复制下来。
        // 被复制的组件的编号等于 length 参数。源数组中位置在 srcPos 到 srcPos+length-1 之间的组件被分别复制到目标数组中的 destPos 到 destPos+length-1 位置。

        col.remove(1);
    }
}
