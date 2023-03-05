package com.javarush.cryptoanalyzer.bulanov;


import com.javarush.cryptoanalyzer.bulanov.repository.FileWrite;
import com.javarush.cryptoanalyzer.bulanov.servise.FileCrypto;
import com.javarush.cryptoanalyzer.bulanov.servise.FileDecode;


public class Main{
    public static void main(String[] args){

        FileCrypto cryptoText = new FileCrypto();
        FileWrite fileWriter = new FileWrite();
        fileWriter.fileWrite(cryptoText.fileEncryption());
        FileDecode fileDecode = new FileDecode();
        System.out.println(fileDecode.fileDecoding());


    }
}