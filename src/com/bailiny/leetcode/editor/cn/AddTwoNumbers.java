//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4859 👎 0

package com.bailiny.leetcode.editor.cn;

import com.bailiny.ListNode;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode l1Next = l1;
            ListNode l2Next = l2;

            ListNode resNode = new ListNode(0);
            ListNode headNode = new ListNode(0);
            headNode.next = resNode;

            boolean foreachFlag = true;
            while (foreachFlag) {
                int i = carry;
                if (l1Next != null) {
                    i += l1Next.val;
                    l1Next = l1Next.next;
                }
                if (l2Next != null) {
                    i += l2Next.val;
                    l2Next = l2Next.next;
                }
                int j = i - 10;
                if (j >= 0) {
                    carry = 1;
                    resNode.val = j;
                } else {
                    resNode.val = i;
                    carry = 0;
                }
                if (l1Next != null || l2Next != null || carry != 0) {
                    resNode.next = new ListNode(0);
                    resNode = resNode.next;
                } else {
                    foreachFlag = false;
                }
            }
            return headNode.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
