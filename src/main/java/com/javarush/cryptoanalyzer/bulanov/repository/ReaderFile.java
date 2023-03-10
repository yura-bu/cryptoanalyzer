package com.javarush.cryptoanalyzer.bulanov.repository;

import java.io.*;
import java.nio.file.Path;

public class ReaderFile{
    private final String pathFile;
    public ReaderFile(String pathFile){
        this.pathFile = pathFile;
    }

    public StringBuilder readFile(){
        StringBuilder text = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(Path.of(pathFile).toFile()))){
           while(bufferedReader.ready()){
               text.append((char)bufferedReader.read());
           }
        }catch (IOException e){
           throw new RuntimeException();
        }
        return text;
    }
}
