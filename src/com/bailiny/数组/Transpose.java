package com.bailiny.数组;

import org.junit.Test;

/**
 * 867.转置矩阵 </br>
   *  给定一个矩阵 A， 返回 A 的转置矩阵。
   *  矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * @author yangxu
 * @date 2018年10月6日 下午9:37:28
 * @version V1.0
 */
public class Transpose {

	public int[][] transpose(int[][] A) {
		int[][] result = new int[A[0].length][A.length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				result[j][i] = A[i][j];
			}
		}
		return result;
    }
	
	@Test
	public void test() {
		int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] res = transpose(A);
		for (int i = 0; i < res.length; i++) {
			System.out.println("------------");
			for (int j = 0; j < res[i].length; j++) {
				System.out.println(res[i][j]);
			}
		}
	}
}
