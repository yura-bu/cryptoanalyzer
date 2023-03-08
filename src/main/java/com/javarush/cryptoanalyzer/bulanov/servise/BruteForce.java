package com.javarush.cryptoanalyzer.bulanov.servise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  BruteForce{

private final String str = "^([а-яА-Я-]+(\\s|,\\s|:\\s|;\\s)){2,}";
private final Pattern pattern = Pattern.compile(str);
    public char[] bruteForceDecoder(StringBuilder text){
        DecoderText decoderText = new DecoderText(text);
        StringBuilder decodingText = new StringBuilder();
        for (int i = 1; i < 80; i++) {
            decodingText.delete(0, decodingText.length());
            decodingText = decoderText.textDecoding(i);
            Matcher matcher = pattern.matcher(decodingText);

            if(matcher.find()) {
                break;
            }
        }
        System.out.println(decodingText);
       return decodingText.toString().toCharArray();
    }
}
