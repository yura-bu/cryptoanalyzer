package com.javarush.cryptoanalyzer.bulanov.utility;

import java.util.Random;

public class RandomOffset{
    public static String randomOffset(){
        Random offset = new Random();
        return String.valueOf(offset.nextInt(10,80));
    }
}
