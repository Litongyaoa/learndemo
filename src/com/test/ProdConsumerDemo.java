package com.test;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class AirCondition{
    private int number = 0;

    private Lock lock = new ReentrantLock();//可重入非公平递归锁
    private Condition condition = lock.newCondition();

     public  void increment() throws Exception{
         lock.lock();
         try {
             //1、判断
             while(number != 0){
                 //this.wait();(synchronized)
                 condition.await();
             }
             //2、干活
             number++;
             System.out.println(Thread.currentThread().getName()+"\t"+number);
             //3、通知
             condition.signalAll();
         }
         catch (Exception e){
                e.printStackTrace();
         }
         finally {
            lock.unlock();
         }

    }

    public  void decrement()throws  Exception{
        lock.lock();
        try {
            //1、判断
            while(number == 0){
                //this.wait();(synchronized)
                condition.await();
            }
            //2、干活
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            //3、通知
            condition.signalAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }


   /* public synchronized void increment() throws Exception{
        //1、判断
        while(number != 0){
            this.wait();
        }
        //2、干活
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3、通知
        this.notifyAll();
    }

    public synchronized void decrement()throws  Exception{
        //1、判断
        while(number == 0){
            this.wait();
        }
        //2、干活
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        //3、通知
        this.notifyAll();
    }*/
}


/**
 * 题目:现在两个线程,可以操作初始值为零的一个变量，
 * 实现 一个线程对该变量加一，另一个线程对该变量减一
 * 实现交替，来10轮，变量初始值为零
 *
 *
 *  1 高聚低合前提下，线程操作资源类
 *  2 判断/干活/通知
 *  3 防止虚假唤醒
 * 知识总结 = 多线程的编程套路 + while判断 + 新版写法
 *
 */

public class ProdConsumerDemo {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();

        new Thread(()->{
            for(int i=1;i<=10;i++){
                try{
                    airCondition.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(()->{
            for(int i=1;i<=10;i++){
                try{
                    airCondition.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(()->{
            for(int i=1;i<=10;i++){
                try{
                    airCondition.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(()->{
            for(int i=1;i<=10;i++){
                try{
                    airCondition.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        },"D").start();



    }
}
