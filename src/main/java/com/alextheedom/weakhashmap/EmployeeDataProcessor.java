package com.alextheedom.weakhashmap;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by atheedom on 17/08/15.
 */
public class EmployeeDataProcessor {

    public static void main(String... args) throws InterruptedException {

        Map<Object, Object> objectMap = new WeakHashMap<>();
        for (int i = 0; i < 1000; i++) {
            objectMap.put(new Float(i), "");
            System.gc();
            System.out.println("Map size:" + objectMap.size());
        }

//        while(true){
//            Thread.sleep(1_000);
//
//            System.out.println("Map size:" + objectMap.size());
//
//        }

    }




}
