package com.test;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目:三个售票员 卖出 30张票
 * <p>
 * 笔记:如何编写企业级的多线程代码
 * 固定的编程套路+模板是什么?
 * <p>
 * 1.在高内聚低耦合的前提下，线程    操作    资源类
 * 1.1  一言不合，先创建一个资源类
 */
public class SaleTicketDemo01 {

    public static void main(String[] args) {//主线程,一切程序的入口
        Ticket ticket = new Ticket();

        new Thread( ()->{ for (int i=1;i<40;i++) ticket.sale();},"A").start();
        new Thread( ()->{ for (int i=1;i<40;i++) ticket.sale();},"B").start();
        new Thread( ()->{ for (int i=1;i<40;i++) ticket.sale();},"C").start();


       /* //线程中状态 Thread.State()
        new Thread(new Runnable() {//匿名内部类
            public void run() {
                for (int i=1;i<40;i++){
                    ticket.sale();
                }

            }
        }, "A").start();

        //线程6中状态 Thread.State()
        new Thread(new Runnable() {//匿名内部类
            public void run() {
                for (int i=1;i<40;i++){
                    ticket.sale();
                }

            }
        }, "B").start();

        //线程中状态 Thread.State()
        new Thread(new Runnable() {//匿名内部类
            @Override
            public void run() {
                for (int i=1;i<40;i++){
                    ticket.sale();
                }

            }
        }, "C").start();*/

    }

}


class Ticket {//资源类  = 实例变量 + 实例方法

    private int number = 30;
    //List list = new ArrayList<>();
    Lock lock = new ReentrantLock();//可重入锁

    public void sale() {
        lock.lock();
        try {

            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "\t 卖出第: " + (number--) + "\t 还剩下 " + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }


}
