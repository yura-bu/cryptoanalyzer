package com.javarush.cryptoanalyzer.bulanov.controller;

import java.nio.file.Path;
import java.util.Scanner;

public class ScannerPath{
    public Path scannerPath(){
        Scanner scanner = new Scanner(System.in);
        return Path.of(scanner.nextLine());
    }
}
