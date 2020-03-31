import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda操作符 或箭头操作符
 *
 * 格式:
 *
 * -> 左边：lambda形参列表(其实就是接口中的抽象方法的参数列表)
 * -> 右边:lambda体(其实就是重写抽象方法的的方法体)
 * lambda表达式的使用:
 *
 *
 * 总结:
 * -> 左边 lambda形参列表的参数类型可以省略(类型推断)，如果参数列表只有一个参数，可以省略括号
 * -> 右边 lambda体应该使用{}包裹,如果lambda体只有一条执行语句(可能是return语句)，return和{}都可以省略
 *
 * 4.lambda表达式的本质:作为函数式接口的实例
 * 5.如果一个接口中只声明了一个抽象方法(@FunctionalInterface)，此接口就称为函数式接口
 *
 *
 */
public class Lambda {

    //语法格式一:无参,无返回值

    //语法格式二:需要一个参数但是没返回值
    @Test
    public void test(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("1");

        Consumer<String> con1 = (String s)->{
            System.out.println(s);
        };
        con1.accept("2");

        //语法格式三:数据类型可以省略，因为可以由编译器推断得出，称为类型推断
        Consumer<String> con2 = (s)->{
            System.out.println(s);
        };

        //语法格式四:lambda若只需要一个参数时，参数的小括号可以省略
        Consumer<String> con4 = s ->{
            System.out.println(s);
        };

        //语法格式五:lambda若需要两或以上个参数时，多条执行语句,并且有返回值

        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> com1 = (o1, o2) ->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

        //语法格式六:当lambda体只有一条语句时，return与大括号若有，都可以省略
        Comparator<Integer> com2 = (o1,o2) -> o1.compareTo(o2);

    }


}
