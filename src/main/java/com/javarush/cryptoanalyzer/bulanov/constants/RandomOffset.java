package com.javarush.cryptoanalyzer.bulanov.constants;

import java.util.Random;

public class RandomOffset{
    public static int randomOffset(){
        Random offset = new Random();
        return offset.nextInt(1,30);
    }
}
