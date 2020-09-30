//给定一个Excel表格中的列名称，返回其相应的列序号。
//
// 例如，
//
//     A -> 1
//    B -> 2
//    C -> 3
//    ...
//    Z -> 26
//    AA -> 27
//    AB -> 28
//    ...
//
//
// 示例 1:
//
// 输入: "A"
//输出: 1
//
//
// 示例 2:
//
// 输入: "AB"
//输出: 28
//
//
// 示例 3:
//
// 输入: "ZY"
//输出: 701
//
// 致谢：
//特别感谢 @ts 添加此问题并创建所有测试用例。
// Related Topics 数学
// 👍 174 👎 0

package com.bailiny.leetcode.editor.cn;

//java:Excel表列序号
public class P171ExcelSheetColumnNumber {
    public static void main(String[] args) {
        Solution solution = new P171ExcelSheetColumnNumber().new Solution();
        System.out.println(solution.titleToNumber("ZY"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int titleToNumber(String s) {
            char[] chars = s.toCharArray();
            int num = 0;
            int n = chars.length - 1;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                int val = c - 64;
                num += val * Math.pow(26, n);
                n--;
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
