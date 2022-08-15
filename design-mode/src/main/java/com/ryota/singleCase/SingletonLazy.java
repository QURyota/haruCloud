package com.ryota.singleCase;

/**
 * @Author Ryota
 * @create 2022/8/15 22:40
 * 懒汉式
 */
public class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {

    }

    /**
     * 提供一个静态方法,当使用到该方法时,才去创建
     *
     * @return
     */
    public static SingletonLazy instance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
