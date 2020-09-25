package com.bailiny.leetcode.editor.cn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author Yang Xu
 * @date 2020/9/25 15:44
 * @description: 1116. ��ӡ������ż��
 */
public class ZeroEvenOdd {

    private int n;
    /**
     * ��ǰ��ӡ��ֵ
     */
    private int cur;

    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition1 = reentrantLock.newCondition();
    private Condition condition2 = reentrantLock.newCondition();
    private Condition condition3 = reentrantLock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    /**
     * printNumber.accept(x) outputs "x", where x is an integer.
     * @param printNumber
     * @throws InterruptedException
     */
    public void zero(IntConsumer printNumber) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (cur != 0) {
                condition1.await();
            }
            while (true) {
                printNumber.accept(0);
                cur++;
                if (cur % 2 == 1) {
                    condition2.signal();
                } else {
                    condition3.signal();
                }
                // �ж��Ƿ������һ�δ�ӡ,������ǵĻ��ͻ�Ҫ�ȴ�
                if (cur != n) {
                    condition1.await();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (cur != n && cur % 2 != 1) {
                condition2.await();
            }
            while (cur <= n) {
                printNumber.accept(cur);
                condition1.signal();

                // �ж��Ƿ������һ�δ�ӡ,������ǵĻ��ͻ�Ҫ�ȴ�
                if (cur != n) {
                    condition1.await();
                }
                if (cur != n) {
                    condition2.await();
                } else {
                    return;
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (cur != n && (cur == 0 || cur % 2 != 0)) {
                condition3.await();
            }
            while (cur <= n) {
                printNumber.accept(cur);
                condition1.signal();
                if (cur != n) {
                    condition3.await();
                } else {
                    return;
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}

class ZeroEvenOddTest {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(1);
        IntConsumer printNumber = value -> System.out.print(value);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "zeroThread").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "evenThread").start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "oddThread").start();
    }
}
