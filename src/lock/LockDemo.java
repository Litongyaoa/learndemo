package lock;


import java.util.concurrent.TimeUnit;

class Phone{
    public synchronized void sendEmail() throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendEmail");
    }

    public synchronized void sendSMS() throws Exception{
        System.out.println("sendSMS");
    }

    public synchronized void sayHello() throws Exception{
        System.out.println("sayHello");
    }
}

/**
 * 8 lock
 * 1.标准访问，请问先打印邮件还是短信
 * 2.暂停4秒钟，请问先打印邮件还是短信
 * 3 新增普通sayHello方法,请问先打印邮件还是sayHello
 * 4 两部手机 先打印邮件还是短信
 * 5两个静态同步方法
 *
 * 一个对象里面有多个synchronized方法，某一时刻内，只要一个线程去调用其中的一个synchronized方法了
 * 其他线程只能等待，换句话说，某时刻，只能有一个线程去访问这些synchronized方法
 * 锁的是当前对象this，被锁定后，其他的线程都不能进入到当前对象的其他的synchronized方法，其他普通方法可以调用
 *
 *
 *
 *
 */

public class LockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();


    }

}
