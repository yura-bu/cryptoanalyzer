package com.javarush.cryptoanalyzer.bulanov;


import com.javarush.cryptoanalyzer.bulanov.repository.ReaderFile;
import com.javarush.cryptoanalyzer.bulanov.repository.WriterFile;
import com.javarush.cryptoanalyzer.bulanov.servise.DecryptorFile;
import com.javarush.cryptoanalyzer.bulanov.servise.EncryptorFile;

public class Main{
    public static void main(String[] args){
        System.out.println("введите путь к файлу, который хотите зашифровать");
        ReaderFile readerFile = new ReaderFile();
        EncryptorFile encryptorFile = new EncryptorFile();
        StringBuilder stringBuilder = readerFile.readFile();
        char[] text = encryptorFile.fileEncryption(stringBuilder);
        System.out.println(text);
        System.out.println("введите путь к файлу в который нужно записать зашифрованный файл");
        WriterFile writerFileEncryption = new WriterFile();
        writerFileEncryption.writeFile(text);

//        DecryptorFile decryptorFile = new DecryptorFile();
//        WriterFile writerFile = new WriterFile();
//        writerFile.writeFile(decryptorFile.decryptedFile());

    }
}