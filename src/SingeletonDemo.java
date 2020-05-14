/**
 *
 */

public class SingeletonDemo {
    private  static volatile SingeletonDemo instance = null;
    private SingeletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t我是构造方法singletonDemo");
    }

    //DCL  (Double check Lock 双端检锁机制)
    public static synchronized SingeletonDemo getInstance(){
        if(instance == null){
            synchronized (SingeletonDemo.class){
                if(instance == null){
                    instance = new SingeletonDemo();
                }
            }
        }
        return  instance;
    }

    public static void main(String[] args) {
        //单线程(main线程的操作动作....)
//        System.out.println(SingeletonDemo.getInstance() == SingeletonDemo.getInstance());
//        System.out.println(SingeletonDemo.getInstance() == SingeletonDemo.getInstance());
//        System.out.println(SingeletonDemo.getInstance() == SingeletonDemo.getInstance());
        //并发多线程后，请客发生了很大的变法
        for(int i =0;i<10;i++){
            new Thread(()->{
                SingeletonDemo.getInstance();
            },String.valueOf(i)).start();
        }
    }
}
