package com.javarush.cryptoanalyzer.bulanov.servise;

import com.javarush.cryptoanalyzer.bulanov.constants.CryptoAlphabets;
import com.javarush.cryptoanalyzer.bulanov.constants.RandomOffset;
import com.javarush.cryptoanalyzer.bulanov.repository.FileRead;

public class FileDecode{
    public StringBuilder fileDecoding(){
        StringBuilder decodingText = new StringBuilder();
        FileRead codingFile = new FileRead();
        StringBuilder codingText = codingFile.fileRead();
        int code = codingText.length()/2- RandomOffset.SECRET_CODE - 1;
        int offset = Integer.parseInt(codingText.substring(code, code+2));
        codingText.delete(code, code+2);

        for (int i = 0; i < codingText.length(); i++) {

            int index = CryptoAlphabets.ALPHABET.indexOf(codingText.charAt(i));

            if(index == -1){
                decodingText.append(codingText.charAt(i));
            }else if((index - offset) <= 0){
                int offsetTemp = offset - (index + 1);
                decodingText.append(CryptoAlphabets.ALPHABET.charAt(CryptoAlphabets.ALPHABET.length() - 1 - offsetTemp));
            }else{
                decodingText.append(CryptoAlphabets.ALPHABET.charAt(index - offset));
            }
        }

        return decodingText;
    }
}
