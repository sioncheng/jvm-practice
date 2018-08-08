package com.github.sioncheng.jp;


import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class MethodHandleTest {

    static class A {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws  Throwable {
        Object o = System.currentTimeMillis() % 2 == 0 ? System.out : new A();

        getPrintln(o).invokeExact("hello");
    }

    private static MethodHandle getPrintln(Object o) throws Throwable {
        MethodType methodType = MethodType.methodType(void.class, String.class);

        return lookup().findVirtual(o.getClass(), "println", methodType).bindTo(o);
    }
}
