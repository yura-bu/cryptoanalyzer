package com.javarush.cryptoanalyzer.bulanov.servise;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  BruteForce extends DecoderText{

private final String str = "^([а-яА-Я-]+(\\s|,\\s|:\\s|;\\s)){2,}";
private final Pattern pattern = Pattern.compile(str);

    public BruteForce(StringBuilder encryptedText){
        super(encryptedText);
    }

    public char[] bruteForceDecoder(){
        StringBuilder decodingText = new StringBuilder();
        for (int i = 1; i < 80; i++) {
            decodingText.delete(0, decodingText.length());
            decodingText = textDecoding(i);
            Matcher matcher = pattern.matcher(decodingText);
            if(matcher.find()) {
                break;
            }
        }
       return decodingText.toString().toCharArray();
    }
}
