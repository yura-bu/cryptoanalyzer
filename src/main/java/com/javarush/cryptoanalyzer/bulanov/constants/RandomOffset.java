package com.javarush.cryptoanalyzer.bulanov.constants;

import java.util.Random;

public class RandomOffset{
    public static final int SECRET_CODE = 2;

    public static int randomOffset(){
        Random offset = new Random();
        return offset.nextInt(10,40);
    }
}
