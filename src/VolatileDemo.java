import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile  int number = 0;
    public void addT060(){
        this.number = 60;
    }
    //此时number前是加了volatile，不保证原子性
    public  void addPlusPlus(){
        number++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 验证volatile的可见性
 * 1.1假如int number = 0；，number变量之前根本没有添加volatile关键字修饰，没有可见性
 * 1.2添加了volatile，可以解决可见性
 * 2.验证volatile不保证原子性
 *      2.1原子性指的是什么意思？
 *         不可分割，完整性，也即某个线程正在做某个集体业务时，中间不可以被加塞或者被分割。
 *         需要整体完整要么同事成功，要么同时失败。
 *      2.3 why
 *      2.4如何解决原子性
 *          *加synchronized
 *          *使用我们的juc下AtomicInteger
 *
 */
public class VolatileDemo {
    public static void main(String[] args) {//main是一切方法的运行入口
        MyData mydata = new MyData();
        for (int i = 0;i < 20;i ++) {
            new Thread(()->{
                for (int j=1;j<=1000;j++){
                    mydata.addPlusPlus();
                    mydata.addAtomic();
                }
            },String.valueOf(i)).start();
            mydata.addPlusPlus();
        }
        //需要等上面20个线程全部计算完成之后，再用main线程取得最终结果看是多少
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value: "+mydata.number);
        System.out.println(Thread.currentThread().getName()+"\t finally atomicInteger number value: "+mydata.atomicInteger);
    }

    public static void SeeokByvolatile() {
        MyData myData = new MyData();//资源类
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\tcome in");
            try {
                TimeUnit.SECONDS.sleep(3);
                myData.addT060();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\tupdate number value:"+myData.number);
        },"AAA").start();
        while(myData.number == 0){
            //main线程一直在这里等待循环，知道number值不在等于零

        }
        System.out.println(Thread.currentThread().getName()+"mission is over ,main get number value:"+myData.number);
    }

}
