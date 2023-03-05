package com.javarush.cryptoanalyzer.bulanov;


import com.javarush.cryptoanalyzer.bulanov.constants.RandomOffset;
import com.javarush.cryptoanalyzer.bulanov.repository.FileWrite;
import com.javarush.cryptoanalyzer.bulanov.servise.FileCrypto;


public class Main{
    public static void main(String[] args){

        FileCrypto cryptoText = new FileCrypto();
        FileWrite fileWriter = new FileWrite();
        fileWriter.fileWrite(cryptoText.fileEncryption());
        System.out.println(RandomOffset.randomOffset());




    }
}