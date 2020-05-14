import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestHashMap {
    @Test
    public void testHash() {
        int[] A = {3, 2, 2, 1};
        int len = A.length;
        int num = 1;
        int num1 = 1;
        for (int i = 0; i < len; i++) {
            if (i != len - 1 && A[i] >= A[i + 1]) {
                num = num + 1;
            }
            if (i != len - 1 && A[i] <= A[i + 1]) {
                num1 = num1 + 1;
            }
        }
    }

    @Test
    public void test2() {
        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 1};
        int len = A.length;
        int[] B = new int[len];
        int num = 1;
        int num0 = 1;
        int k = 0;
        for (int i = 0; i < len - 1; i++) {
            if (A[i] == 1 && A[i] == A[i + 1]) {
                num = num + 1;
            }
            if ((A[i] == 1 && A[i + 1] == 0) || num > 1 && i == len - 2) {
                B[k] = 1;
                B[k + 1] = num;
                num = 1;
                k = k + 2;
            }
            if (A[i] == 0 && A[i] == A[i + 1]) {
                num0 = num0 + 1;
            }
            if ((A[i] == 0 && A[i + 1] == 1) || num0 > 1 && i == len - 2) {
                B[k] = 0;
                B[k + 1] = num0;
                num0 = 1;
                k = k + 2;
            }
        }
        int c = 2;
        for (int a = 0; a < B.length; a++) {
            if (B[a] == 0) {
                //0的个数
                int zeroNum = B[a + 1];
                //0周围1的个数
                int oneNum = B[a - 1] + B[a + 2];
                //可变参数大于0的个数且连续起来的小于最多个1周围相连
                if (c > zeroNum) {
                    System.out.println(oneNum + c);
                }
            }
        }

    }

    @Test
    public void hhh() {
        int[] nums = new int[]{3,2,4,5};
        int target = 6;
        int index1 = 0, index2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int diffBNum = target - nums[i];
            int index3 = Arrays.binarySearch(nums,diffBNum);
            if (index3 != -1 && index3 != i) {
                index1 = i;
                index2 = index3;
                break;
            }
        }
        List list = new ArrayList();

    }

}
