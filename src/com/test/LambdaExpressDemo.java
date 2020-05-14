package com.test;

@FunctionalInterface
//函数式接口可以写多个default方法,可以写多个静态方法
interface Foo {
    public int add(int x, int y);

    default int mul(int x, int y) {
        return x*y;
    }
    public static int div(int x,int y){
        return x/y;
    }
}

/**
 * 1.函数式编程
 * int age =23;
 * 拷贝方法小括号 ，写死右箭头 落地大括号
 */
public class LambdaExpressDemo {
    public static void main(String[] args) {
        Foo foo = (int x, int y) -> {
            System.out.println();
            return x+y;
        };
        foo.add(3,5);
        foo.mul(3,5);
        Foo.div(15,3);
    }
}
