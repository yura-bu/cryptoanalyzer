package com.javarush.cryptoanalyzer.bulanov;


import com.javarush.cryptoanalyzer.bulanov.repository.WriterFile;
import com.javarush.cryptoanalyzer.bulanov.servise.EncryptorFile;
import com.javarush.cryptoanalyzer.bulanov.servise.DecryptorFile;


public class Main{
    public static void main(String[] args){

        EncryptorFile cryptoText = new EncryptorFile();
        WriterFile writerFile = new WriterFile();
        writerFile.writeFile(cryptoText.fileEncryption());
        DecryptorFile fileDecode = new DecryptorFile();
        System.out.println(fileDecode.fileDecoding());


    }
}