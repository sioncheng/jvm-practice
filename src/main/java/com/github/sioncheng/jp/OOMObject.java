package com.github.sioncheng.jp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OOMObject {

    public static void main(String[] args) throws InterruptedException, IOException {
        fillHeap(1000);

        System.out.println("after fill heap");

        int n = System.in.read();

        System.out.println((char)n);

        System.gc();

        System.out.println("gc again");

        System.in.read();
        System.in.read();
    }


    private static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> oomObjectList = new ArrayList<OOMObject>();

        for (int i = 0 ; i < num; i++) {
            Thread.sleep(50);
            oomObjectList.add(new OOMObject());
        }

        System.gc();
    }

    private byte[] placeholder = new byte[64 * 1024];
}
