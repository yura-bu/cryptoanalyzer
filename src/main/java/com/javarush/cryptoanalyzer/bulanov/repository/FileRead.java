package com.javarush.cryptoanalyzer.bulanov.repository;

import java.io.*;
import java.util.ArrayList;

public class FileRead{

    public ArrayList<Character> fileRead(){
        ArrayList<Character> text = new ArrayList<>();

        try(FileInputStream fileInputStream = new FileInputStream("ExampleText.txt");
           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))){
           while(bufferedReader.ready()){
               text.add((char)bufferedReader.read());
           }
           System.out.println();
        }catch (IOException e){
           throw new RuntimeException();
        }
        return text;
    }
}
