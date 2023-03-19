package com.javarush.cryptoanalyzer.bulanov.view;

import com.javarush.cryptoanalyzer.bulanov.services.UnsupportedFunction;
import com.javarush.cryptoanalyzer.bulanov.utility.RandomOffset;
import com.javarush.cryptoanalyzer.bulanov.entity.Result;

import java.util.Scanner;

import static com.javarush.cryptoanalyzer.bulanov.constants.ApplicationCompletionConstants.*;
import static com.javarush.cryptoanalyzer.bulanov.constants.ConstantsIO.*;
import static com.javarush.cryptoanalyzer.bulanov.constants.FilePathConstants.*;
import static com.javarush.cryptoanalyzer.bulanov.constants.FrameConstants.*;
import static com.javarush.cryptoanalyzer.bulanov.constants.FunctionConstants.*;

public class ConsolView implements View{
    private final String[] parameters = new String[4];
    Scanner scanner = new Scanner(System.in);
    @Override
    public String[] parameters(){
        System.out.println(ENTER_FUNCTION_COD);
        parameters[0] = scanner.nextLine();
        parameters[3] = RandomOffset.randomOffset();
        switch (parameters[0]){
            case ENCODE_NUMBER -> {getEncode();
                System.out.println(LABEL_KEY + COLON + parameters[3]);
            }
            case DECODE_NUMBER -> getDecode();
            case BRUTE_FORCE_NUMBER -> getBruteForce();
            default -> new UnsupportedFunction().execute(parameters);
        }
        scanner.close();
        return parameters;
    }

    @Override
    public void printResult(Result result){
        switch (result.getResultCode()){
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }
    }

    private void getBruteForce(){
        System.out.println(ENTER_ENCRYPTED_FILE_PATH);
        String line = scanner.nextLine();
        if(!line.isEmpty()){
            parameters[1] = line;
        }else {
            parameters[1] = ENCODED_FILE;
        }
        System.out.println(ENTER_DECRYPTED_FILE_PATH);
        line = scanner.nextLine();
        if(!line.isEmpty()){
            parameters[2] = line;
        }else {
            parameters[2] = DECODED_FILE;
        }
    }

    private void getDecode(){
        System.out.println(ENTER_ENCRYPTED_FILE_PATH);
        String line = scanner.nextLine();
        if(!line.isEmpty()){
            parameters[1] = line;
        }else {
            parameters[1] = ENCODED_FILE;
        }
        System.out.println(ENTER_KEY);
        parameters[3] = scanner.nextLine();
        System.out.println(ENTER_DECRYPTED_FILE_PATH);
        line = scanner.nextLine();
        if(!line.isEmpty()){
            parameters[2] = line;
        }else {
            parameters[2] = DECODED_FILE;
        }
    }
    private void getEncode(){
        System.out.println(ENTER_ORIG_FILE_PATH);
        String line = scanner.nextLine();
        if(!line.isEmpty()){
            parameters[1] = line;
        }else {
            parameters[1] = ORIGINAL_FILE;
        }
        System.out.println(ENTER_CRYPT_FILE_PATH);
        line = scanner.nextLine();
        if(!line.isEmpty()){
            parameters[2] = line;
        }else {
            parameters[2] = ENCODED_FILE;
        }
    }
}
