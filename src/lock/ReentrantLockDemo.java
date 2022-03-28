package lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author admin
 *
 * 可重入锁:
 *
 */
public class ReentrantLockDemo {


    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("第一次获取锁,这个锁是:" + this);
                    int index = 1;
                    while (true) {
                        synchronized (this) {
                            System.out.println("第" + (++index) + "次获取锁,这个锁收:" + this);
                        }
                        if (index == 11) {
                            break;
                        }
                    }
                }
            }
        }).start();
    }


    @Test
    public void testReentrantLock() {

        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(new Runnable() {


            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("第一次获取锁,这个锁是:" + this);
                int index = 1;
                while (true) {
                    reentrantLock.lock();
                    System.out.println("第" + (++index) + "次获取锁,这个锁收:" + this);
                    if (index == 11) {
                        break;
                    }
                    reentrantLock.unlock();
                }
                reentrantLock.unlock();

            }


        }).start();


    }







}
