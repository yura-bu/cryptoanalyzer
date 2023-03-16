package com.javarush.cryptoanalyzer.bulanov.services;

import com.javarush.cryptoanalyzer.bulanov.constants.CryptoAlphabets;
import com.javarush.cryptoanalyzer.bulanov.entity.Result;
import com.javarush.cryptoanalyzer.bulanov.exeptions.ApplicationException;
import com.javarush.cryptoanalyzer.bulanov.repository.ReaderFile;
import com.javarush.cryptoanalyzer.bulanov.repository.ResultCode;
import com.javarush.cryptoanalyzer.bulanov.repository.WriterFile;

import java.util.Arrays;


public class Encode implements Function{
    public char[] fileEncryption(int offset, StringBuilder originalText){

        StringBuilder cryptoText = new StringBuilder();

        for(int i = 0; i < originalText.length(); i++){

            int index = CryptoAlphabets.ALPHABET.indexOf(originalText.charAt(i));

            if(index == -1){
                cryptoText.append(originalText.charAt(i));
            }else if((index + offset) >= CryptoAlphabets.ALPHABET.length()){
                int offsetTemp = offset - (CryptoAlphabets.ALPHABET.length() - 1 - index);
                cryptoText.append(CryptoAlphabets.ALPHABET.charAt(offsetTemp - 1));
            }else{
                cryptoText.append(CryptoAlphabets.ALPHABET.charAt(index + offset));
            }
        }
        return cryptoText.toString().toCharArray();
    }
    @Override
    public Result execute(String[] parameters){
        try {
            System.out.println("encode " + Arrays.toString(parameters));
            ReaderFile readerFile = new ReaderFile(parameters[1]);
            Encode encode = new Encode();
            StringBuilder stringBuilder = readerFile.readFile();
            WriterFile writerFileEncryption = new WriterFile(parameters[2]);
            writerFileEncryption.writeFile(encode.fileEncryption(Integer.parseInt(parameters[3]),stringBuilder));

        }catch (Exception e){
            return new Result(ResultCode.ERROR, new ApplicationException("Decode operation finish with exception", e));
        }
        return new Result(ResultCode.OK);
    }
}
