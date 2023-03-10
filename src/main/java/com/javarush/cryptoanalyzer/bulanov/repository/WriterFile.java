package com.javarush.cryptoanalyzer.bulanov.repository;

import java.io.*;
import java.nio.file.Path;


public class WriterFile{
    private final String pathFileOutput;

    public WriterFile(String pathFileOutput){
       this.pathFileOutput = pathFileOutput;
    }

    public  void writeFile(char[] text){

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Path.of(pathFileOutput).toFile()))){
            bufferedWriter.write(text);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}

