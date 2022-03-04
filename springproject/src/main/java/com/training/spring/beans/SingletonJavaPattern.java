package com.training.spring.beans;


public class SingletonJavaPattern {

    private volatile static SingletonJavaPattern instance;

    private SingletonJavaPattern() {
    }

    public static SingletonJavaPattern getInstance() {
        if (SingletonJavaPattern.instance == null) {
            synchronized (SingletonJavaPattern.class) {
                if (SingletonJavaPattern.instance == null) {
                    SingletonJavaPattern.instance = new SingletonJavaPattern();
                }
            }
        }
        return SingletonJavaPattern.instance;
    }


}
