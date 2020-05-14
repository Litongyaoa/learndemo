package lock;

/**
 * 线程死锁描述的是这样一种情况：多个线程同时被阻塞，他们中的一个或者全部都在等待某个资源被释放
 * 由于线程被无限期的阻塞因此程序不可能正常终止
 *
 *
 * 产生死锁的必要条件
 * 1.互斥条件:该资源任意时刻只能有一个线程占用
 * 2.请求与保持条件"一个线程因请求资源而阻塞时，对已获得的资源保持不放
 * 3.不剥夺条件:线程已获得的资源在韦使用完之前不能被其他线程强行抢夺,只有自己使用完毕以后才能释放资源
 * 4.玄幻等待条件:若干进程之间形成一种头尾详解的循环等待资源关系
 *
 *
 */
public class DeadLockDemo {
    private static Object resource1 = new Object();
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2){
                    System.out.println(Thread.currentThread() + "get  resource2");
                }
            }
        },"线程1").start();

        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread() + "get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource1");
                synchronized (resource1){
                    System.out.println(Thread.currentThread() + "get  resource1");
                }
            }
        },"线程2").start();
    }
}
