package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 */
public class TwoNumberAdd {

       class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Integer l1Value = getTurnOverListNodeValue(l1);
            Integer l2Value = getTurnOverListNodeValue(l2);
            Integer sumValue = l1Value+l2Value;
            System.out.println();
            return null;
        }

        public Integer getTurnOverListNodeValue(ListNode l1){
            List<Integer> list = new ArrayList<>();
            while (l1.next!=null){
                int val = l1.next.val;
                list.add(val);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = list.size()-1; i > 0; i--) {
                sb.append(list.get(i));
            }
            return Integer.valueOf(sb.toString());
        }

    }

    public static void main(String[] args) {

    }
}
