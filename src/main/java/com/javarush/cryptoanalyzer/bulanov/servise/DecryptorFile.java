package com.javarush.cryptoanalyzer.bulanov.servise;

import com.javarush.cryptoanalyzer.bulanov.constants.CryptoAlphabets;
import com.javarush.cryptoanalyzer.bulanov.constants.RandomOffset;
import com.javarush.cryptoanalyzer.bulanov.repository.ReaderFile;

public class DecryptorFile{
    public StringBuilder fileDecoding(){
        StringBuilder decryptedText = new StringBuilder();
        ReaderFile encryptedFile = new ReaderFile();
        StringBuilder encryptedText = encryptedFile.readFile();
        int code = encryptedText.length()/2- RandomOffset.SECRET_CODE - 1;
        int offset = Integer.parseInt(encryptedText.substring(code, code+2));
        encryptedText.delete(code, code+2);

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
