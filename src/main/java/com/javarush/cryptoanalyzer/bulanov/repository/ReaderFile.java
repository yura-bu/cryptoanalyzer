package com.javarush.cryptoanalyzer.bulanov.repository;

import com.javarush.cryptoanalyzer.bulanov.controller.ScannerPath;

import java.io.*;
import java.util.Scanner;

public class ReaderFile{

    public StringBuilder readFile(){
        StringBuilder text = new StringBuilder();
        ScannerPath filePath = new ScannerPath();

        try(FileInputStream fileInputStream = new FileInputStream(filePath.scannerPath().toFile());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))){
           while(bufferedReader.ready()){
               text.append((char)bufferedReader.read());
           }
        }catch (IOException e){
           throw new RuntimeException();
        }
        return text;
    }
}
