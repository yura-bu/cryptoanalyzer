package com.javarush.cryptoanalyzer.bulanov.servise;

import com.javarush.cryptoanalyzer.bulanov.constants.CryptoAlphabets;
import com.javarush.cryptoanalyzer.bulanov.constants.RandomOffset;
import com.javarush.cryptoanalyzer.bulanov.repository.ReaderFile;


public class EncryptorFile{
    private final int OFFSET = RandomOffset.randomOffset();

    public char[] fileEncryption(){

        StringBuilder cryptoText = new StringBuilder();

        StringBuilder originalText = new ReaderFile().readFile();
        System.out.println(OFFSET);
        for(int i = 0; i < originalText.length(); i++){

            int index = CryptoAlphabets.ALPHABET.indexOf(originalText.charAt(i));

            if(index == -1){
                cryptoText.append(originalText.charAt(i));
            }else if((index + OFFSET) >= CryptoAlphabets.ALPHABET.length()){
                int offsetTemp = OFFSET - (CryptoAlphabets.ALPHABET.length() - 1 - index);
                cryptoText.append(CryptoAlphabets.ALPHABET.charAt(offsetTemp - 1));
            }else{
                cryptoText.append(CryptoAlphabets.ALPHABET.charAt(index + OFFSET));
            }
        }
        cryptoText.insert(originalText.length()/2 - RandomOffset.SECRET_CODE, OFFSET);
        return cryptoText.toString().toCharArray();
    }
}
