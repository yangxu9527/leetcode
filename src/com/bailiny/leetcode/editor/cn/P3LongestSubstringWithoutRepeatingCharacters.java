//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4184 👎 0

package com.bailiny.leetcode.editor.cn;

import com.sun.org.apache.regexp.internal.RE;

//java:无重复字符的最长子串
public class P3LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args){
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        int abcabcbb = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(abcabcbb);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        char[] c = s.toCharArray();
        int startIndex = 0;
        int currentMaxLength = 0;
        int maxLength = 0;
        for (int i = 0; i < c.length; i++) {
            for (int j = startIndex; j < i; j++) {
                if (c[i] == c[j]) {
                    if (currentMaxLength > maxLength) {
                        maxLength = currentMaxLength;
                    }
                    // 有重复
                    startIndex = j + 1;
                    currentMaxLength = i - startIndex;
                    break;
                }
            }
            currentMaxLength++;
        }
        return currentMaxLength > maxLength ? currentMaxLength : maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
