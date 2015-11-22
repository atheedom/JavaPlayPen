package com.alextheedom.websocket.service;

import java.util.Random;

/**
 * Created by Developer on 22/11/2015.
 */
public class UserTestData {
    private static final String[] EXAMPLE_HANDLES = new String[]{"aaa", "bbb",
            "ccc", "ddd", "eee", "fff", "gee", "ggg", "hhh", "iii", "jjj",
            "kkk", "lll", "mmm", "nnn", "ooo", "ppp", "qqq", "rrr", "sss",
            "ttt", "uuu", "vvv", "www", "xxx", "yyy", "zzz"};

    public static void main(String[] args) {
        Random random = new Random();
        new StubService("/users/", 8093,
                () -> EXAMPLE_HANDLES[random.nextInt(27)]).run();
    }
}

