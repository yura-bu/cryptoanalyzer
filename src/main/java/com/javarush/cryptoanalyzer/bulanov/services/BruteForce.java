package com.javarush.cryptoanalyzer.bulanov.services;

import com.javarush.cryptoanalyzer.bulanov.entity.Result;
import com.javarush.cryptoanalyzer.bulanov.exeptions.ApplicationException;
import com.javarush.cryptoanalyzer.bulanov.repository.ReaderFile;
import com.javarush.cryptoanalyzer.bulanov.repository.ResultCode;
import com.javarush.cryptoanalyzer.bulanov.repository.WriterFile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.javarush.cryptoanalyzer.bulanov.constants.ApplicationCompletionConstants.EXCEPTION_BRUTE_FORCE;
import static com.javarush.cryptoanalyzer.bulanov.constants.PatternConstants.STRING_STRUCTURE;

public class  BruteForce extends DecoderText implements Function{
private final String stringStructure = STRING_STRUCTURE;
private final Pattern pattern = Pattern.compile(stringStructure);
    public char[] bruteForceDecoder(StringBuilder encryptedText){
        StringBuilder decodingText = new StringBuilder();
        for (int i = 1; i < 80; i++) {
            decodingText.delete(0, decodingText.length());
            decodingText = textDecoding(i, encryptedText);
            Matcher matcher = pattern.matcher(decodingText);
            if(matcher.find()) {
                break;
            }
        }
       return decodingText.toString().toCharArray();
    }

    @Override
    public Result execute(String[] parameters){
        try{
            ReaderFile readerFile = new ReaderFile(parameters[1]);
            BruteForce bruteForce = new BruteForce();
            WriterFile writerFileDecryption = new WriterFile(parameters[2]);
            writerFileDecryption.writeFile(bruteForce.bruteForceDecoder(readerFile.readFile()));

        }catch (Exception e){
        return new Result(ResultCode.ERROR, new ApplicationException(EXCEPTION_BRUTE_FORCE, e));
    }
        return new Result(ResultCode.OK);
    }
}
