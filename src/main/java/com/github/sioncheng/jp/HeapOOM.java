package com.github.sioncheng.jp;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

    static class OOMObject {}

    public static void main(String[] args) {

        List<OOMObject>  oomObjects = new ArrayList<OOMObject>();
        for(;;) {
            oomObjects.add(new OOMObject());
        }
    }

}
