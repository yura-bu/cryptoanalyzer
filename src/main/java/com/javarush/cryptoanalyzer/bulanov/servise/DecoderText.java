package com.javarush.cryptoanalyzer.bulanov.servise;

import com.javarush.cryptoanalyzer.bulanov.constants.CryptoAlphabets;

public class DecoderText{
    private final int offset;
    private final StringBuilder encryptedText;

    public DecoderText(int offset, StringBuilder encryptedText){
        this.offset = offset;
        this.encryptedText = encryptedText;
    }
    public StringBuilder textDecoding(){

        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {

            int index = CryptoAlphabets.ALPHABET.indexOf(encryptedText.charAt(i));

            if(index == -1){
                decryptedText.append(encryptedText.charAt(i));
            }else if((index - offset) <= 0){
                int offsetTemp = offset - (index + 1);
                decryptedText.append(CryptoAlphabets.ALPHABET.charAt(CryptoAlphabets.ALPHABET.length() - 1 - offsetTemp));
            }else{
                decryptedText.append(CryptoAlphabets.ALPHABET.charAt(index - offset));
            }
        }

        return decryptedText;
    }
}
