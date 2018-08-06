package com.github.sioncheng.jp;

public class TestAllocation {

    //java -verbose:gc -Xms20M -Xmx20M -Xmn10M
    // -XX:+PrintGCDetails -XX:SurvivorRatio=8 com/github/sioncheng/jp/TestAllocation
    //
    public static void main(String[] args) {
        System.out.println("test allocation");
        testAllocation();

    }

    private static void testAllocation() {
        byte[] allocation1;
        byte[] allocation2;
        byte[] allocation3;
        byte[] allocation4;

        allocation1 = new byte[2 * _1MB];
        System.out.println("allocation 1");
        allocation2 = new byte[2 * _1MB];
        System.out.println("allocation 2");
        allocation3 = new byte[2 * _1MB];
        System.out.println("allocation 3");
        allocation4 = new byte[4 * _1MB];
        System.out.println("allocation 4");
    }

    private static final int _1MB = 1024 * 1024;
}
