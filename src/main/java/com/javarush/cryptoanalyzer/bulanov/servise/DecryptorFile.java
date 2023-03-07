package com.javarush.cryptoanalyzer.bulanov.servise;

import com.javarush.cryptoanalyzer.bulanov.constants.RandomOffset;
import com.javarush.cryptoanalyzer.bulanov.repository.ReaderFile;

public class DecryptorFile{
//    private StringBuilder decryptedText = new StringBuilder();

    public char[] decryptedFile(StringBuilder encryptedText){

        int code = encryptedText.length()/2- RandomOffset.SECRET_CODE - 1;
        int offset = Integer.parseInt(encryptedText.substring(code, code+2));
        encryptedText.delete(code, code+2);
        DecoderText decoderText = new DecoderText(offset, encryptedText);
        return decoderText.textDecoding().toString().toCharArray();
    }


//    public StringBuilder fileDecoding(int offset){
//
//        for (int i = 0; i < encryptedText.length(); i++) {
//
//            int index = CryptoAlphabets.ALPHABET.indexOf(encryptedText.charAt(i));
//
//            if(index == -1){
//                decryptedText.append(encryptedText.charAt(i));
//            }else if((index - offset) <= 0){
//                int offsetTemp = offset - (index + 1);
//                decryptedText.append(CryptoAlphabets.ALPHABET.charAt(CryptoAlphabets.ALPHABET.length() - 1 - offsetTemp));
//            }else{
//                decryptedText.append(CryptoAlphabets.ALPHABET.charAt(index - offset));
//            }
//        }
//
//        return decryptedText;
//    }
}
