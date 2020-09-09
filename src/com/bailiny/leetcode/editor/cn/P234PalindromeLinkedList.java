//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
// 👍 622 👎 0

package com.bailiny.leetcode.editor.cn;

import com.bailiny.ListNode;

import java.util.Stack;

//java:回文链表
public class P234PalindromeLinkedList{
    public static void main(String[] args){
        Solution solution = new P234PalindromeLinkedList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(solution.isPalindrome(head));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * 可以优化，使用双指针找到中点，只需要翻转一半，剩下的再比较。
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.val);
            temp =  temp.next;
        }
        temp = head;
        while (temp != null) {
            if (temp.val != stack.pop()) {
                return false;
            }
            temp =  temp.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
