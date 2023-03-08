package com.javarush.cryptoanalyzer.bulanov;


import com.javarush.cryptoanalyzer.bulanov.aplication.ProgramAction;

public class Main{
    public static void main(String[] args){
        ProgramAction programAction = new ProgramAction();
        programAction.encryption();
        programAction.decryption();
        programAction.bruteForceDecryption();

    }
}