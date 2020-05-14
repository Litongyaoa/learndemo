package jvm;

import java.util.HashMap;
import java.util.Random;

public class T2 {
    public static void main(String[] args) {
        /*long maxMemory = Runtime.getRuntime().maxMemory();//返回java虚拟机师徒使用的最大内存容量
        long totalMemory = Runtime.getRuntime().totalMemory();//返回java虚拟机中的内存总量
        System.out.println("-Xmm:MAX_MEMORY="+maxMemory+" (字节)、"+(maxMemory/(double)1024/1024 +"MB"));
        System.out.println("-Xms:TOTAL_MEMORY="+totalMemory+" (字节)、"+(totalMemory/(double)1024/1024 +"MB"));*/
      /*  String str ="lity";
        while(true){
            str+=str+new Random().nextInt(888888888)+new Random().nextInt(999999999);
        }*/

        System.out.println(1&0);
        System.out.println(1&1);
        new HashMap<>();

    }
}
