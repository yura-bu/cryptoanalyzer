package com.javarush.cryptoanalyzer.bulanov.repository;

import com.javarush.cryptoanalyzer.bulanov.controller.ScannerPath;

import java.io.*;


public class WriterFile{
    public  void writeFile(char[] text){
        ScannerPath filePath = new ScannerPath();
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath.scannerPath().toFile()))){
            bufferedWriter.write(text);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}

