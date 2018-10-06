package com.bailiny.数组;

import org.junit.Test;

/**
 * 905.按奇偶校验排序数组。</br>
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
   * 可以返回满足此条件的任何数组作为答案。
 * @author yangxu
 * @date 2018年10月6日 下午8:40:14
 * @version V1.0
 */
public class SortArrayByParity {


	/**
	   *    采用双指针，遍历遇到偶数则放到数组尾部，遇到奇数则放到数组头部
	 * @param: @param A
	 * @param: @return      
	 * @return: int[]      
	 * @throws
	 */
	public int[] sortArrayByParity(int[] A) {
		int len = A.length;
        int[] result = new int[len];
        // 头部和尾部指针
        int headPointer = 0;
        int tailPointer = len - 1; 
        for (int i = 0; i < len; i++) {
			if(A[i] % 2 == 0) {
				result[headPointer] = A[i];
				headPointer++;
			}else {
				result[tailPointer] = A[i];
				tailPointer--;
			}
		}
        return result;
    }
	
	@Test
	public void test() {
		int[] A = {3, 1, 2, 4};
		int[] res = sortArrayByParity(A);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}
	}
}
