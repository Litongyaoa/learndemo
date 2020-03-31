import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射的实现
 */
public class Reflex {

    @Test
    public void test() throws Exception {
        //获取Class的三种方法
        int[] A = new int[10];
        //1.通过调用运行时类的属性 .class
        Class clazz = User.class;

        //2.通过运行时类的对象，调用getClass()
        User user = new User();
        Class clazz1 = user.getClass();

        //3.调用Class的静态方法 forName(String classPath) 最常用可以传递参数
        Class clazz2 = Class.forName("User");

        //4.使用类的加载器 :ClassLoader()
        ClassLoader classLoader = Reflex.class.getClassLoader();
        Class clazz3 = classLoader.loadClass("User");

        //获取实例
        User obj = (User) clazz.newInstance();

        //调用私有参数
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(obj, "张三");
        obj.show();

        //调用私有方法
        Method setAge = clazz.getDeclaredMethod("setAge", int.class);
        setAge.setAccessible(true);
        setAge.invoke(obj, 20);
        obj.show();

    }

}
