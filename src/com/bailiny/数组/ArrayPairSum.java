package com.bailiny.数组;

import java.util.Arrays;

import org.junit.Test;

/**
 * 561.数组拆分</br>
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n
 * 的 min(ai, bi) 总和最大。</br>
 * 其中：</br>
 * n 是正整数,范围在 [1, 10000].</br>
 * 数组中的元素范围在 [-10000, 10000].</br>
 * 数组中的值不会重复
 *
 * @author yangxu
 * @date 2018年10月6日 下午9:59:50
 * @version V1.0
 */
public class ArrayPairSum {

	/**
	 * 两两分组求min总和最大，则最大和第二大，第三大和第四大这样一次分组得到的总和最大， 因此最直接的方式就是先对数组排序然后再求偶数位之和
	 */
	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		for (int i = 0; i < nums.length; i = i + 2) {
			res += nums[i];
		}
		return res;
	}

	/**
	 * 直接排序开销较大，注意提示，可以考虑创建一个数组把值，和下标对应，相当于排序了.
	 */
	public int arrayPairSum2(int[] nums) {
		int[] sorts = new int[20001];
		for (int i = 0; i < nums.length; i++) {
			sorts[nums[i] + 10000]++;
		}
		int res = 0;
		boolean odd = true;
		for (int i = 0; i < sorts.length; i++) {
			while (sorts[i] > 0) {
				if (odd) {
					res += i - 10000;
				}
				odd = !odd;
				sorts[i]--;
			}
		}
		return res;
	}

	@Test
	public void test() {
		int[] nums = { 1, 3, 2, 4, 4, 7 };
		System.out.println(arrayPairSum2(nums));
	}
}
