package com.github.sioncheng.jp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Threads {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();

        createBusyThread();

        reader.readLine();

        createLockThread(new Object());

    }

    private static void createBusyThread() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {

                }
            }
        }, "busyThread");

        t.start();
    }

    private static void createLockThread(final Object object) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                synchronized (object) {
                    try {
                        object.wait();
                    } catch (InterruptedException ie) {

                    }
                }
            }
        }, "lockThread");

        t.start();
    }
}
