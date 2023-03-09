package com.javarush.cryptoanalyzer.bulanov.servise;

import com.javarush.cryptoanalyzer.bulanov.constants.RandomOffset;


public class DecryptFile extends DecoderText{


    public DecryptFile(StringBuilder encryptedText){
        super(encryptedText);
    }

    public char[] decryptedFile(){

        int code = getEncryptedText().length()/2- RandomOffset.SECRET_CODE - 1;
        int offset = Integer.parseInt(getEncryptedText().substring(code, code+2));
        getEncryptedText().delete(code, code+2);
        DecoderText decoderText = new DecoderText(getEncryptedText());
        return decoderText.textDecoding(offset).toString().toCharArray();
    }

}
