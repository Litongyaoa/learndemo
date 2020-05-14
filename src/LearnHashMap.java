import org.junit.Test;
import sun.applet.Main;

import java.util.HashMap;

/**
 *1.8 数组+链表(红黑树)
 * 数组:采用一段连续的存储单元来存储数据
 * 特点:指定下标O(1) 插入删除O(N) 查找快删除慢 java.util.ArrayList
 * 链表：插入删除快 查找慢
 */

public class LearnHashMap {
    public static void main(String[] args) {
        int n = 17 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n+1);
        System.out.println( new Thread(()->{

        }).getState());

    }

    @Test
    public void test2(){
        int i = 0;
        System.out.println("hahhda");
        i++;

    }


}
