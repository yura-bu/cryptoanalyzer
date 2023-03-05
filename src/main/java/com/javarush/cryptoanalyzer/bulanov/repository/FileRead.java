package com.javarush.cryptoanalyzer.bulanov.repository;

import java.io.*;
import java.util.Scanner;

public class FileRead{

    public StringBuilder fileRead(){
        StringBuilder text = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        String pathFile = scanner.nextLine();
        scanner.close();

        try(FileInputStream fileInputStream = new FileInputStream(pathFile);
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
