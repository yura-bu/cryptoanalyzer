package com.javarush.cryptoanalyzer.bulanov.servise;


import static com.javarush.cryptoanalyzer.bulanov.constants.CryptoAlphabets.ALPHABET;

public class DecoderText{

    private final StringBuilder encryptedText;
    public StringBuilder getEncryptedText(){
        return encryptedText;
    }

    public DecoderText(StringBuilder encryptedText){
        this.encryptedText = encryptedText;
    }
    public StringBuilder textDecoding(int offset){

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
