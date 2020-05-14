import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.CAS是什么？===>compareAndSet
 *  比较并交换 Compare-And-Swap，他是一条CPU并发原语
 *      unsafe(来自rt.jar/sun.misc)
 *      unsafe.getAndAddInt(this(当前对象), valueOffset(内存偏移量，内存地址), 1);
 *
 *
 */

public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        //main doing something.....
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data:" +atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5, 1024)+"\t current data:" +atomicInteger.get());
        atomicInteger.getAndIncrement();//return unsafe.getAndAddInt(this(AtomicInteger当前对象), valueOffset(内存偏移量，内存地址), 1);
    }
}
