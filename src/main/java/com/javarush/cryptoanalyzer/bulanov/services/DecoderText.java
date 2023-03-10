package com.javarush.cryptoanalyzer.bulanov.services;


import static com.javarush.cryptoanalyzer.bulanov.constants.CryptoAlphabets.ALPHABET;

public class DecoderText{

    public StringBuilder textDecoding(int offset, StringBuilder encryptedText){

        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {

            int index = ALPHABET.indexOf(encryptedText.charAt(i));

            if(index == -1){
                decryptedText.append(encryptedText.charAt(i));
            }else if((index - offset) < 0){
                int offsetTemp = offset - (index + 1);
                decryptedText.append(ALPHABET.charAt(ALPHABET.length() - 1 - offsetTemp));
            }else{
                decryptedText.append(ALPHABET.charAt(index - offset));
            }
        }

        return decryptedText;
    }
}
