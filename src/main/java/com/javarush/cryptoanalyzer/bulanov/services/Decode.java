package com.javarush.cryptoanalyzer.bulanov.services;

import com.javarush.cryptoanalyzer.bulanov.entity.Result;
import com.javarush.cryptoanalyzer.bulanov.repository.ReaderFile;
import com.javarush.cryptoanalyzer.bulanov.repository.ResultCode;
import com.javarush.cryptoanalyzer.bulanov.exeptions.ApplicationException;
import com.javarush.cryptoanalyzer.bulanov.repository.WriterFile;

public class Decode extends DecoderText implements Function {


    public char[] decryptedFile(int offset, StringBuilder encryptedText){

        return textDecoding(offset, encryptedText).toString().toCharArray();
    }

    @Override
    public Result execute(String[] parameters){
        try {
            ReaderFile readerFile = new ReaderFile(parameters[1]);
            WriterFile writerFileDecryption = new WriterFile(parameters[2]);
            writerFileDecryption.writeFile(decryptedFile(Integer.parseInt(parameters[3]), readerFile.readFile()));
        } catch (Exception e){
            return new Result(ResultCode.ERROR, new ApplicationException("Decode operation finish with exception", e));
        }
        return new Result(ResultCode.OK);
    }
}
