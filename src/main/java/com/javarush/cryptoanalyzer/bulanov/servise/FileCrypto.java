package com.javarush.cryptoanalyzer.bulanov.servise;

import com.javarush.cryptoanalyzer.bulanov.constants.CryptoAlphabets;
import com.javarush.cryptoanalyzer.bulanov.constants.RandomOffset;
import com.javarush.cryptoanalyzer.bulanov.repository.FileRead;


public class FileCrypto{
    public char[] fileEncryption(){

        StringBuilder cryptoText = new StringBuilder();

        StringBuilder originalText = new FileRead().fileRead();
        int offset = RandomOffset.randomOffset();
        for(int i = 0; i < originalText.length(); i++){

            int index = CryptoAlphabets.ALPHABET.indexOf(originalText.charAt(i));

            if(index == -1){
                cryptoText.append(originalText.charAt(i));

            }else if((index + offset) >= CryptoAlphabets.ALPHABET.length()){
                int offsetTemp = offset - (CryptoAlphabets.ALPHABET.length() - 1 - index);
                cryptoText.append(CryptoAlphabets.ALPHABET.charAt(offsetTemp -1));
            }else{
                cryptoText.append(CryptoAlphabets.ALPHABET.charAt(index + offset));
            }

        }

        return cryptoText.toString().toCharArray();
    }
}
