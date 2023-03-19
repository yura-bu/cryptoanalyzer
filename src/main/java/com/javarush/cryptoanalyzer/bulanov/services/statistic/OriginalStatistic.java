package com.javarush.cryptoanalyzer.bulanov.services.statistic;


import java.util.*;

import static com.javarush.cryptoanalyzer.bulanov.constants.CryptoAlphabets.ALPHABET;

public class OriginalStatistic{
    private final StringBuilder originalText;


    OriginalStatistic(StringBuilder originalText){
        this.originalText = originalText;
    }
    TreeMap<Double, Character> statisticOriginalText = new TreeMap<>();
    public StringBuilder statisticAnalysisDecoded(){

        return null;
    }
    public TreeMap<Double, Character> analysisOriginalText(){

        char[] symbols = originalText.toString().toLowerCase().toCharArray();
        char[] alphabet = ALPHABET.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char value : symbols) {
            list.add(value);
        }
        for (char c : alphabet) {
            double b = Collections.frequency(list, c);
            double db = (b/list.size()) * 100;
            if(db >= 1.) {
                statisticOriginalText.put(db, c);
            }
        }

        return statisticOriginalText;
    }

}
