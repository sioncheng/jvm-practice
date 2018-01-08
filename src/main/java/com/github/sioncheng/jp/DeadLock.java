package com.github.sioncheng.jp;

/**
 * @author : cyq
 * @date : 08/01/2018 6:38 PM
 * Description:
 */
public class DeadLock {

    public static void main(String[] args) {
        final Integer a = 1;
        final Integer b = 2;

        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0 ; i < 100; i++) {
                    add(a,b);
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                for(int i = 0 ; i < 100; i++) {
                    add(b,a);
                }
            }
        });


        thread1.start();
        thread2.start();

        System.out.println("finished");
    }

    static int add(Integer a, Integer b) {
        synchronized (a) {
            synchronized (b) {
                return a + b;
            }
        }
    }
}
