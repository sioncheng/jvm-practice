package com.github.sioncheng.jp;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectoryMemoryOOM {

    public static void main(String[] args) throws Exception {

        Field unsafe = Unsafe.class.getDeclaredFields()[0];
        unsafe.setAccessible(true);

        Unsafe unsafe1 = (Unsafe)unsafe.get(null);

        while (true) {
            unsafe1.allocateMemory(ONE_MB);
        }
    }

    private static final int ONE_MB = 1024 * 1024;
}
