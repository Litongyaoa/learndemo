
interface ClothFactory {
    void produceCLoth();
}

/**
 * 静态代理
 * 特点:代理类和被代理类在编译期间都确定下来了
 */
class ProxyFactory implements ClothFactory{

    private ClothFactory factory;

    public ProxyFactory(ClothFactory factory){
        this.factory = factory;
    }

    @Override
    public void produceCLoth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCLoth();
        System.out.println("代理工厂做一些后续工作");
    }
}
class NikeFactory implements ClothFactory{

    @Override
    public void produceCLoth() {
        System.out.println("Nike公司生产服装");
    }
}


public class StaticProxy {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new NikeFactory());
        proxyFactory.produceCLoth();
    }
}
