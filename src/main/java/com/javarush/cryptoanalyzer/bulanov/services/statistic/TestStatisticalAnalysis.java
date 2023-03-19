package com.javarush.cryptoanalyzer.bulanov.services.statistic;

import com.javarush.cryptoanalyzer.bulanov.repository.ReaderFile;
import com.javarush.cryptoanalyzer.bulanov.services.statistic.EncryptedStatistic;
import com.javarush.cryptoanalyzer.bulanov.services.statistic.OriginalStatistic;
import com.sun.source.tree.Tree;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TestStatisticalAnalysis{
    public static void main(String[] args){
        TreeMap<Double, Character> original;
        TreeMap<Double, Character> encrypted;
        StringBuilder encryptedText = new ReaderFile("encoded.txt").readFile();
        OriginalStatistic originalStatistic = new OriginalStatistic(new ReaderFile("original.txt").readFile());
        EncryptedStatistic encryptedStatistic = new EncryptedStatistic(encryptedText);
        original = originalStatistic.analysisOriginalText();
        encrypted = encryptedStatistic.analysisEncryptedText();
        int diff =Integer.MAX_VALUE;
        while (diff != 0){
                diff = original.size() - encrypted.size();
                double KeyFirst = original.firstKey();
                original.remove(KeyFirst);
        }

        char[] chars = encryptedText.toString().toCharArray();
        System.out.println(original);
        System.out.println(encrypted);
        System.out.println();
        System.out.println(chars);
int j = 0;
        while(j <= 11) {
            double keyOriginal = original.lastKey();
            double keyEncrypted = encrypted.lastKey();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == encrypted.get(keyEncrypted)) {
                    chars[i] = original.get(keyOriginal);
                }
            }
            original.remove(keyOriginal);
            encrypted.remove(keyEncrypted);
            j++;
        }
        System.out.println("-----------------------------------------");
        System.out.println(chars);



//        System.out.println();
//        System.out.println(original);
//        System.out.println(encrypted);
//        System.out.println();
    }
}
