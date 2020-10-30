package com.bailiny.

����;

import org.junit.Test;

/**
 * 867.ת�þ��� </br>
 * ����һ������ A�� ���� A ��ת�þ���
 * �����ת����ָ����������Խ��߷�ת���������������������������
 *
 * @author yangxu
 * @version V1.0
 * @date 2018��10��6�� ����9:37:28
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
        int[][] A = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] res = transpose(A);
        for (int i = 0; i < res.length; i++) {
            System.out.println("------------");
            for (int j = 0; j < res[i].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }
}
