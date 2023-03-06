package com.javarush.cryptoanalyzer.bulanov.repository;

import com.javarush.cryptoanalyzer.bulanov.controller.ScannerPath;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class WriterFile{
    public  void writeFile(char[] text){
        ScannerPath filePath = new ScannerPath();

        try(FileOutputStream fileOutputStream = new FileOutputStream(filePath.scannerPath().toFile());
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream))){
            bufferedWriter.write(text);
        }catch (IOException e){
            throw new RuntimeException();
        }

    }
}
