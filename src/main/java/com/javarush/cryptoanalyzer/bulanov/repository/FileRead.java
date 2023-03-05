package com.javarush.cryptoanalyzer.bulanov.repository;

import java.io.*;

public class FileRead{

    public StringBuilder fileRead(){
        StringBuilder text = new StringBuilder();

        try(FileInputStream fileInputStream = new FileInputStream("ExampleText.txt");
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
