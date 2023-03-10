package com.javarush.cryptoanalyzer.bulanov.services;

import com.javarush.cryptoanalyzer.bulanov.entity.Result;

public interface Function{
    Result execute(String[] parameters);
}
