//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
// Related Topics 堆 排序 分治算法 
// 👍 26 👎 0

package com.bailiny.leetcode.editor.cn;

import com.sun.org.apache.regexp.internal.REUtil;

public class SmallestKLcci {
    public static void main(String[] args) {
        Solution solution = new SmallestKLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] smallestK(int[] arr, int k) {
            // 使用插入排序
            // 创建一个长度为k的数组arrK，arrK用于记录最小的K个数。
            // 遍历arr，并与arrK中的最大的数进行比较，如果小于最大的数。则将该数插入到arrK中对应的位置
            //   从后向前遍历arrK，当发现比较的数cur小于当前位置大于前一个位置则找到该位置，否则依次后移
            int[] arrK = new int[k];
            int maxNumIndex = 0;
            for (int i = 1; i < arr.length; i++) {
                int cur = arr[i];
                for (int j = maxNumIndex; j >= 0; j--) {
                    if (j == 0) {
                        arrK[j] = cur;
                        break;
                    }
                    if (arrK[j] > cur && arrK[j - 1] <= cur) {
                        // 找到位置
                        arrK[j] = cur;
                        break;
                    } else if (cur >= arrK[j]) {
                        break;
                    } else {
                        arrK[j] = arrK[j - 1];
                    }
                }

            }
            return arrK;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
