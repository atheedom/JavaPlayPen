package com.alextheedom.reflection;

public class NewInstance {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Object obj1 = new String();
        Object obj2 = obj1.getClass().newInstance();
        System.out.print("Object: " + obj2.getClass());

        Class clazz = obj2.getClass();
        Object obj3 = clazz.cast(obj2);


    }
}
