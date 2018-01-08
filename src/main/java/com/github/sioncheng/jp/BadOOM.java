package com.github.sioncheng.jp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cyq
 * @date : 08/01/2018 2:55 PM
 * Description:
 */
public class BadOOM {

    public static void main(String[] args) throws Exception {
        while(true) {
            int c = System.in.read();
            if (c == (int)'c') {
                break;
            }
        }


        fillHeap(1000);
        System.out.print("fill heap 1000");

        System.gc();

        while(true) {
            int c = System.in.read();
            if (c == (int)'q') {
                break;
            }
        }
    }

    static void fillHeap(int count) throws InterruptedException{
        List<OomObject> ooms = new ArrayList<OomObject>(count);

        for (int i = 0 ; i < count; i++) {
            Thread.sleep(50);
            OomObject oomObject = new OomObject();
            oomObject.placeHolder[0] = (byte)i;
            ooms.add(oomObject);
            if (i % 10 == 0) {
                System.out.println(String.format("%d fill heap", i));
            }
        }

        //System.gc();
    }

    static class OomObject {
        public byte[] placeHolder = new byte[64 * 1024];
    }
}
