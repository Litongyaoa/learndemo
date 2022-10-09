package leetcode;

/**
 * @author admin
 */
public class Day1_ReversePrefix {


    private String reversePrefix(String word, char ch) {
        String returnStr = word;
        int i = word.indexOf(ch);
        if (i != -1) {
            String substring = word.substring(0, i);
            char[] chars = substring.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i1 = chars.length - 1; i1 >= 0; i1--) {
                sb.append(chars[i1]);
            }
            returnStr = sb + word.substring(i);
        }
        return returnStr;
    }


    private static String reverseParentheses(String s) {
        int start = s.indexOf("(");
        int end = s.indexOf(")");
        if(end<start){
            start = s.indexOf("(");
        }
        if (start != -1 && end != -1 && start!=end+1) {
            String substring = s.substring(start+1, end );
            char[] chars = substring.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i1 = chars.length - 1; i1 >= 0; i1--) {
                sb.append(chars[i1]);
            }
            s = s.replace("(" + substring + ")", sb);
        }
        if (!s.contains("(")) {
            return s;
        }
        return reverseParentheses(s);
    }

    static int[] TwoSum(int[] arr, int target)
    {
        int m = 0;
        int n = arr.length - 1;
        int[] nums = new int[2];
        while(m < n)
        {
            if (arr[m] + arr[n] == target)
            {
                nums[0] = m + 1;
                nums[1] = n + 1;
                return nums;
            }
            else if (arr[m] + arr[n] < target)
            {
                m++;
            }
            else if (arr[m] + arr[n] > target)
            {
                n--;
            }
        }
        return null;}


    public static void main(String[] args) {
        //"fluaonbqytsj"
        System.out.println(reverseParentheses("f(ul)ao(t(y)qbn)()sj")); ;
    }

}
