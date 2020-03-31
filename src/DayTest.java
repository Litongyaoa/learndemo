import org.junit.Test;

import java.util.Random;


public class DayTest {
    @Test
    public void test(){
        String str = "name=zhangsan age=15 intesting=sing";
        System.out.println(str.indexOf("="));
        int start = str.indexOf("");
        System.out.println(str.indexOf("=",5));
    }
}
