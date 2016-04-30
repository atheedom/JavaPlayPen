package com.alextheedom.jerseycoders.textbasedadventure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atheedom on 13/04/2016.
 */
public class Items {

    private static List<String> basket = new ArrayList();

    public static boolean hasItem(String item){
       return basket.contains(item);
    }

    public static void addItem(String item){
        basket.add(item);
    }


}
