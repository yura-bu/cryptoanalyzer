package com.javarush.cryptoanalyzer.bulanov.aplication;


import com.javarush.cryptoanalyzer.bulanov.repository.ReaderFile;
import com.javarush.cryptoanalyzer.bulanov.repository.WriterFile;
import com.javarush.cryptoanalyzer.bulanov.servise.BruteForce;
import com.javarush.cryptoanalyzer.bulanov.servise.DecryptFile;
import com.javarush.cryptoanalyzer.bulanov.servise.EncryptorFile;

import static com.javarush.cryptoanalyzer.bulanov.constants.ConstantsIO.*;

public class ProgramAction{
    public void encryption(){
        System.out.println(ENTER_ORIG_FILE_PATH);

        ReaderFile readerFile = new ReaderFile();
        EncryptorFile encryptorFile = new EncryptorFile();
        StringBuilder stringBuilder = readerFile.readFile();

        System.out.println(ENTER_CRYPT_FILE_PATH);

        WriterFile writerFileEncryption = new WriterFile();
        writerFileEncryption.writeFile(encryptorFile.fileEncryption(stringBuilder));

        System.out.println(END_ENCRYPTION);
    }

    public void decryption(){
        System.out.println(ENTER_ENCRYPTED_FILE_PATH);
        ReaderFile readerFile = new ReaderFile();
        DecryptFile decryptFile = new DecryptFile(readerFile.readFile());

        System.out.println(ENTER_DECRYPTED_FILE_PATH);
        WriterFile writerFileDecryption = new WriterFile();
        writerFileDecryption.writeFile(decryptFile.decryptedFile());

        System.out.println(END_DECRYPTION);
    }

    public void bruteForceDecryption(){

        System.out.println(ENTER_ENCRYPTED_FILE_PATH);
        ReaderFile readerFile = new ReaderFile();
        BruteForce bruteForce = new BruteForce(readerFile.readFile());


        System.out.println(ENTER_DECRYPTED_FILE_PATH);
        WriterFile writerFileDecryption = new WriterFile();
        writerFileDecryption.writeFile(bruteForce.bruteForceDecoder());

        System.out.println(END_DECRYPTION);
    }
}
