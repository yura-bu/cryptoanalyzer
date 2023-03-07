package com.javarush.cryptoanalyzer.bulanov.aplication;

import com.javarush.cryptoanalyzer.bulanov.constants.ConstantsIO;
import com.javarush.cryptoanalyzer.bulanov.repository.ReaderFile;
import com.javarush.cryptoanalyzer.bulanov.repository.WriterFile;
import com.javarush.cryptoanalyzer.bulanov.servise.DecryptorFile;
import com.javarush.cryptoanalyzer.bulanov.servise.EncryptorFile;

public class ProgramAction{
    public void encryption(){
        System.out.println(ConstantsIO.ENTER_ORIG_FILE_PATH);

        ReaderFile readerFile = new ReaderFile();
        EncryptorFile encryptorFile = new EncryptorFile();
        StringBuilder stringBuilder = readerFile.readFile();

        System.out.println(ConstantsIO.ENTER_CRYPT_FILE_PATH);

        WriterFile writerFileEncryption = new WriterFile();
        writerFileEncryption.writeFile(encryptorFile.fileEncryption(stringBuilder));

        System.out.println(ConstantsIO.END_ENCRYPTION);
    }

    public void decryption(){
        System.out.println(ConstantsIO.ENTER_ENCRYPTED_FILE_PATH);
        ReaderFile readerFile = new ReaderFile();
        DecryptorFile decryptorFile = new DecryptorFile();
        StringBuilder  text = readerFile.readFile();

        System.out.println(ConstantsIO.ENTER_DECRYPTED_FILE_PATH);
        WriterFile writerFileDecryption = new WriterFile();
        writerFileDecryption.writeFile(decryptorFile.decryptedFile(text));

        System.out.println(ConstantsIO.END_DECRYPTION);
    }
}
