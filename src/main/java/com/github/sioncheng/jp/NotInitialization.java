package com.github.sioncheng.jp;

public class NotInitialization {

    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }


    public static class SuperClass {
        static {
            System.out.println("super class init");
        }

        public static final int value = 100;
    }

    public static class SubClass extends SuperClass {
        static {
            System.out.println("sub class init");
        }
    }
}
