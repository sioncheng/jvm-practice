package com.github.sioncheng.jp;

import java.io.InputStream;
import java.net.URLClassLoader;

/**
 * @author : cyq
 * @date : 2019/4/1 10:43 AM
 * Description:
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {
        ClassLoader myClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(filename);
                    if (inputStream != null) {
                        byte[] data = new byte[inputStream.available()];
                        inputStream.read(data);

                        return defineClass(name, data, 0, data.length);
                    }
                } catch (Exception ex) {
                    throw new ClassNotFoundException(ex.getLocalizedMessage());
                }
                return super.loadClass(name);
            }
        };

        Class<?> clazz = myClassLoader.loadClass("com.github.sioncheng.jp.ClassLoaderTest");
        Object classLoaderTest = clazz.newInstance();

        System.out.println(classLoaderTest instanceof ClassLoaderTest);
    }
}
