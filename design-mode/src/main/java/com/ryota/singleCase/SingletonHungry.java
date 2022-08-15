package com.ryota.singleCase;

/**
 * @Author Ryota
 * @create 2022/8/15 22:44
 * 饿汉式  用静态变量
 */
public class SingletonHungry {
    
    /**
     * 构造私有化 外部不能new
     */
    private SingletonHungry() {

    }

    /**
     * 本类内部创建对象实例
     */
    private final static SingletonHungry instance = new SingletonHungry();

    /**
     * 对外提供一个共有的静态变量,返回实例对象
     *
     * @return
     */
    public static SingletonHungry getInstance() {
        return instance;
    }
}
