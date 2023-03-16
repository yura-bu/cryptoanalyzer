package com.javarush.cryptoanalyzer.bulanov.view;

import com.javarush.cryptoanalyzer.bulanov.entity.Result;

public interface View{
    String[] parameters();
    void printResult(Result result);
}
