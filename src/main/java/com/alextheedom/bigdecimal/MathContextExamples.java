package com.alextheedom.bigdecimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by atheedom on 09/02/2016.
 */
public class MathContextExamples {


    public static void main(String... args) {


        BigDecimal amount = new BigDecimal(100000000)
                .divide(BigDecimal.valueOf(3), new MathContext(10, RoundingMode.DOWN))
                .setScale(2, BigDecimal.ROUND_DOWN);

        System.out.println(amount.doubleValue());


    }


}
