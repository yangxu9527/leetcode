package com.bailiny.

����;

import java.util.Arrays;

import org.junit.Test;

/**
 * 561.������</br>
 * ��������Ϊ 2n ������, ��������ǽ���Щ���ֳ� n ��, ���� (a1, b1), (a2, b2), ..., (an, bn) ��ʹ�ô�1 �� n
 * �� min(ai, bi) �ܺ����</br>
 * ���У�</br>
 * n ��������,��Χ�� [1, 10000].</br>
 * �����е�Ԫ�ط�Χ�� [-10000, 10000].</br>
 * �����е�ֵ�����ظ�
 *
 * @author yangxu
 * @version V1.0
 * @date 2018��10��6�� ����9:59:50
 */
public class ArrayPairSum {

    /**
     * ����������min�ܺ���������͵ڶ��󣬵�����͵��Ĵ�����һ�η���õ����ܺ���� �����ֱ�ӵķ�ʽ�����ȶ���������Ȼ������ż��λ֮��
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
     * ֱ���������ϴ�ע����ʾ�����Կ��Ǵ���һ�������ֵ�����±��Ӧ���൱��������.
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
        int[] nums = {1, 3, 2, 4, 4, 7};
        System.out.println(arrayPairSum2(nums));
    }
}
