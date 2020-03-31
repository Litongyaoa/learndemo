import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 自己不会存储数据
 * Stream 不会改变源对象，相反，他们会返回一个持有新结果的Stream
 * Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行
 */


public class SreamApi {

    //创建Stream的方式一: 通过集合
    @Test
    public  void test(){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Stream<String> stream = list.stream();//返回一个顺序
        Stream<String> stringStream = list.parallelStream();//返回一个并行流
    }

    //创建Stream的方式二: 通过数组
    @Test
    public  void test1(){
        int[] arr = new int[]{1,2,3};
        IntStream stream = Arrays.stream(arr);
    }

    //创建Stream的方式一: 通过stream的of()
    @Test
    public  void test2(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5,5);
        //过滤
        integerStream.filter(t -> t>2).forEach(System.out::println);
        //limit(n) --截断流，使其袁术不超过给定数量
        integerStream.limit(3).forEach(System.out::println);
        //skip 跳过n元素，如果不足n个 返回空流
        integerStream.skip(3).forEach(System.out::println);
        //distitnct ()--筛选，通过流生成元素的hashcode()和equals()去除重复元素
        integerStream.distinct().forEach(System.out::println);
    }

    //创建Stream的方式一: 创建无限流
    @Test
    public  void test3(){
        Stream.iterate(0,t -> t+2).limit(10).forEach(System.out::println);
    }

    //映射
    @Test
    public void test4(){
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Stream<String> stream = list.stream();
        stream.map(str -> str.toUpperCase()).forEach(System.out::println);
    }

}
