package com.alextheedom.bitset;

import java.util.BitSet;
import java.util.Calendar;
import java.util.stream.Stream;

/**
 * Created by atheedom on 03/09/15.
 */
public class LotteryNumberMatcher {


    public static void main(String... args) {

        String jackpotNumber = "10,20,30,40,50,60,70,80";
        String chosenNumbers = "10,15,20,25,30,35,40,45";

        BitSet jackpotBits = new BitSet(8);
        BitSet chosenBits = new BitSet(8);

        String[] jps = jackpotNumber.split(",");
        Stream.of(jps).mapToInt(Integer::parseInt).forEach(jackpotBits::set);


        Long start = Calendar.getInstance().getTime().getTime();
        for (int x = 0; x < 14_000_000; x++) {
            String[] cns = chosenNumbers.split(",");
            Stream.of(cns).mapToInt(Integer::parseInt).forEach(chosenBits::set);


            // AND bits
            chosenBits.and(jackpotBits);

        }
        Long end = Calendar.getInstance().getTime().getTime();


        System.out.println("time: " + (end - start) / 1000);


        System.out.println("chosenBits: " + chosenBits);
        System.out.println("jackpotBits: " + jackpotBits);


    }


}
