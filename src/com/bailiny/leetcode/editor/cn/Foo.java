package com.bailiny.leetcode.editor.cn;

/**
 * @author Yang Xu
 * @date 2020/9/18 11:07
 * @description: 1114. °´Ðò´òÓ¡
 */
class Foo {

    private boolean firstFinished = false;
    private boolean secondFinished = false;
    private Object lock = new Object();

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!firstFinished) {
                lock.wait();
            }

            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!secondFinished) {
                lock.wait();
            }
            printThird.run();
        }
    }
}

class FooTest {
    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Runnable a = () -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable b = () -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable c = () -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);
        Thread t3 = new Thread(c);
        t3.start();
        t1.start();
        t2.start();
    }
}
