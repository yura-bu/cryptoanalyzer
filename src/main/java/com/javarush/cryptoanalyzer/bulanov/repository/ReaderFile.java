package com.javarush.cryptoanalyzer.bulanov.repository;

import java.io.*;
import java.util.Scanner;

public class ReaderFile{

    public StringBuilder readFile(){
        StringBuilder text = new StringBuilder();

        try(FileInputStream fileInputStream = new FileInputStream(new Scanner(System.in).nextLine());
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
