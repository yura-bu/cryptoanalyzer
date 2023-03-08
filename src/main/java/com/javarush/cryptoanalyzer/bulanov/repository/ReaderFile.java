package com.javarush.cryptoanalyzer.bulanov.repository;

import com.javarush.cryptoanalyzer.bulanov.controller.ScannerPath;

import java.io.*;

public class ReaderFile{

    public StringBuilder readFile(){
        StringBuilder text = new StringBuilder();
        ScannerPath filePath = new ScannerPath();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.scannerPath().toFile()))){
           while(bufferedReader.ready()){
               text.append((char)bufferedReader.read());
           }
        }catch (IOException e){
           throw new RuntimeException();
        }
        return text;
    }
}
