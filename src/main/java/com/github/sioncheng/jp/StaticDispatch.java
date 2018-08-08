package com.github.sioncheng.jp;

public class StaticDispatch {

    static abstract class Human{}

    static class Man extends Human {}

    static class Woman extends Human {}

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }

    private void sayHello(Human human)  {
        System.out.println("hi human");
    }

    private void sayHello(Man man) {
        System.out.println("hi man");
    }

    private void sayHello(Woman woman) {
        System.out.println("hi woman");
    }
}
