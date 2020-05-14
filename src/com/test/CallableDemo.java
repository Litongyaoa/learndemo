package com.test;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Runnable {


    @Override
    public void run() {

    }
}


class MyThread2 implements Callable<Integer> {

    public Integer call() throws Exception {




        System.out.println("*******come in callable");
        return 111;
    }
}


public class CallableDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new MyThread2());
        new Thread(futureTask,"A").start();
        Integer integer = futureTask.get();
        System.out.println(integer);
    }

}
