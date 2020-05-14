package com.test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 1.故障现象
 *
 *  java.util.ConcurrentModificationException
 *
 * 2导致原因
 *
 *
 * 3解决方法
 *  new Vector<>()
 *  Collections.synchronizedList(new ArrayList<>())
 *  new CopyOnWriteArrayList<>() 推荐
 * 4 优化建议(同样的错不会犯第二次)
 *
 *
 */


public class NotSafeDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    //Collection 集合接口;
    //Collections 结合接口的工具类;

    public static void setNotSafe(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();//new Vector();   Collections.synchronizedList(new ArrayList<>());new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
