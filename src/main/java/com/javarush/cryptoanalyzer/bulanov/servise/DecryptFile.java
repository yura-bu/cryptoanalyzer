package com.javarush.cryptoanalyzer.bulanov.servise;

import com.javarush.cryptoanalyzer.bulanov.constants.RandomOffset;


public class DecryptFile{


    public char[] decryptedFile(StringBuilder encryptedText){

        int code = encryptedText.length()/2- RandomOffset.SECRET_CODE - 1;
        int offset = Integer.parseInt(encryptedText.substring(code, code+2));
        encryptedText.delete(code, code+2);
        DecoderText decoderText = new DecoderText(encryptedText);
        return decoderText.textDecoding(offset).toString().toCharArray();
    }

}
