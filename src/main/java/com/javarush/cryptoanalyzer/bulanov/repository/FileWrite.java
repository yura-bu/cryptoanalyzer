package com.javarush.cryptoanalyzer.bulanov.repository;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileWrite{
    public  void fileWrite(char[] cryptoText){
        try(FileOutputStream fileOutputStream = new FileOutputStream("CryptoExampleText.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream))){
            bufferedWriter.write(cryptoText);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
