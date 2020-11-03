package com.bailiny.leetcode.editor.cn;

public class FooBar {

    public static void main(String[] args) {
        Integer a = 128;
        change(a);
        System.out.println(a);
    }

    public static void change(Integer a) {
        a+=2;
    }

    private int n;
    // ��˭��ӡ��0 foo, 1 bar
    private int whoPrint;


    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (whoPrint == 1) {
                    this.wait();
                }
                printFoo.run();
                whoPrint = 1;
                this.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (this) {
                while (whoPrint == 0) {
                    this.wait();
                    ;
                }
                printBar.run();
                whoPrint = 0;
                this.notifyAll();
            }
        }
    }
}
