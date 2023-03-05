package com.javarush.cryptoanalyzer.bulanov.servise;

import com.javarush.cryptoanalyzer.bulanov.constants.CryptoAlphabets;
import com.javarush.cryptoanalyzer.bulanov.constants.RandomOffset;
import com.javarush.cryptoanalyzer.bulanov.repository.FileRead;


public class FileCrypto{
    public char[] fileEncryption(){

        StringBuilder cryptoText = new StringBuilder();
        FileRead originalText = new FileRead();
        for(int i = 0; i < originalText.fileRead().length(); i++){

            int offset = RandomOffset.randomOffset();
            int index = CryptoAlphabets.ALPHABET.indexOf(originalText.fileRead().charAt(i));

            if(index == -1){
                cryptoText.append(originalText.fileRead().charAt(i));

            }else if((index + offset) >= CryptoAlphabets.ALPHABET.length()){
                offset = offset - (CryptoAlphabets.ALPHABET.length() - 1 - index);
                cryptoText.append(CryptoAlphabets.ALPHABET.charAt(offset -1));
            }else{
                cryptoText.append(CryptoAlphabets.ALPHABET.charAt(index + offset));
            }

        }

        return cryptoText.toString().toCharArray();
    }
}
