package com.javarush.cryptoanalyzer.bulanov.services.statistic;

import java.util.Map;
import java.util.TreeMap;

public class EncryptedStatistic{
    StringBuilder encryptedText;
    EncryptedStatistic(StringBuilder encryptedText){
        this.encryptedText = encryptedText;
    }
    TreeMap<Double, Character> statisticEncryptedText = new TreeMap<>();
    public TreeMap<Double, Character> analysisEncryptedText(){
        char[] symbol = encryptedText.toString().toCharArray();
        char[] chars = encryptedText.toString().toCharArray();
        int count = 0;
        double percent = 0;
        for (char c : symbol) {
            for (int j = 0; j < chars.length; j++) {
                if (c == chars[j] && c != '\n') {
                    count++;
                    chars[j] = '§';
                }
                percent = (((double)count)/symbol.length)*100;
            }
            if (percent >= 1) {
                statisticEncryptedText.put(percent, c);
            }
            count = 0;
        }
        return statisticEncryptedText;
    }
}
