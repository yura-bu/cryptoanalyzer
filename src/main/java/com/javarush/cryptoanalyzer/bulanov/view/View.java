package com.javarush.cryptoanalyzer.bulanov.view;

import com.javarush.cryptoanalyzer.bulanov.entity.Result;

public interface View{
    String[] getParameters();
    void printResult(Result result);
}
