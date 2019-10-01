package com.modest.dp.sigleton;

/**
 * 单例模式
 *
 * 懒汉 非线程安全，只能保证肯定有返回值
 * 在多线程中存在有当instance为空时，有两个线程同时调用getInstance()方法
 *
 *
 * @author modest
 * @date 2019/09/27
 */
public class Singleton {
    private static Singleton instance;
    private Singleton() {
    }

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


