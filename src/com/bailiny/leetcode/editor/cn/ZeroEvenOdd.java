package com.bailiny.leetcode.editor.cn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author Yang Xu
 * @date 2020/9/25 15:44
 * @description: 1116. 打印零与奇偶数
 */
public class ZeroEvenOdd {

    private int n;

    private volatile int start = 1;

    private volatile int who;
    private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (who != 0) {
                    zero.await();
                }
                printNumber.accept(0);
                if (start % 2 == 0) {
                    who = 2;
                    even.signal();
                } else {
                    who = 1;
                    odd.signal();
                }
                zero.await();
            }
            odd.signal();
            even.signal();
        } finally {
            lock.unlock();
        }
    }

    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (who != 2) {
                    even.await();
                } else {
                    printNumber.accept(start++);
                    who = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    //基数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (who != 1) {
                    odd.await();
                } else {
                    printNumber.accept(start++);
                    who = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

class ZeroEvenOddTest {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);
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
