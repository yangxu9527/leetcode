package com.bailiny.����;

import org.junit.Test;

/**
 * 905.����żУ���������顣</br>
 * ����һ���Ǹ��������� A������һ���� A ������ż��Ԫ����ɵ����飬����� A ����������Ԫ�ء�
   * ���Է���������������κ�������Ϊ�𰸡�
 * @author yangxu
 * @date 2018��10��6�� ����8:40:14
 * @version V1.0
 */
public class SortArrayByParity {


	/**
	   *    ����˫ָ�룬��������ż����ŵ�����β��������������ŵ�����ͷ��
	 * @param: @param A
	 * @param: @return      
	 * @return: int[]      
	 * @throws
	 */
	public int[] sortArrayByParity(int[] A) {
		int len = A.length;
        int[] result = new int[len];
        // ͷ����β��ָ��
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
