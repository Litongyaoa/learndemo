import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */

interface Human{
    String getBelief();

    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);

    }
}

/**
 * 要想实现代理，需要解决的问题
 * 1：如何根据加载到内存中的被代理类，动态的创建一个代理及其对象
 * 2:当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 */

class ProxyFactory1{
    //调用此方法，返回一个代理类的对象。解决问题1
    public static Object getProxyInstance(Object obj){//obj:被代理对象
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), myInvocationHandler);
    }
}

class  MyInvocationHandler implements InvocationHandler{
    private Object obj;//赋值时也需要使用被代理类的对象赋值
    public void bind(Object obj){
        this.obj = obj;
    }
    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法:invoke()
    //将代理类要执行的方法a的功能就声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类调用的方法，此方法也就作为被代理类对象要调用的方法
        //obj:被代理类的对象
        System.out.println("真的强");
        Object returnValue = method.invoke(obj, args);
        System.out.println("确实强");
        //上述方法的方绘制就作为当前类中的invoke()的返回值
        return returnValue;
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactory1.getProxyInstance(superMan);
        proxyInstance.eat("123");
        //
        NikeFactory nikeFactory = new NikeFactory();
        ClothFactory proxyInstance1 = (ClothFactory) ProxyFactory1.getProxyInstance(nikeFactory);
        proxyInstance1.produceCLoth();
    }
}
