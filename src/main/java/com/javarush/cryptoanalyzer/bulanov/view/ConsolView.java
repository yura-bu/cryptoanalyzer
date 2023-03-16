package com.javarush.cryptoanalyzer.bulanov.view;

import com.javarush.cryptoanalyzer.bulanov.constants.RandomOffset;
import com.javarush.cryptoanalyzer.bulanov.entity.Result;

import java.util.Scanner;

import static com.javarush.cryptoanalyzer.bulanov.constants.ApplicationCompletionConstants.*;
import static com.javarush.cryptoanalyzer.bulanov.constants.ConstantsIO.*;
public class ConsolView implements View{
    private final String[] parameters = new String[4];
    Scanner scanner = new Scanner(System.in);
    @Override
    public String[] parameters(){
        System.out.println(ENTER_FUNCTION_COD);
        parameters[0] = scanner.nextLine();
        parameters[3] = RandomOffset.randomOffset();
        switch (parameters[0]){
            case "1" -> {getEncode();
                System.out.println("Key: " + parameters[3]);
            }
            case "2" -> getDecode();
            case "3" -> getBruteForce();
            default -> {System.out.println("Ошибка ввода");
            System.exit(1);}
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
        if(!line.equals("")){
            parameters[1] = line;
        }else {
            parameters[1] = "encoded.txt";
        }
        System.out.println(ENTER_DECRYPTED_FILE_PATH);
        line = scanner.nextLine();
        if(!line.equals("")){
            parameters[2] = line;
        }else {
            parameters[2] = "output.txt";
        }
    }

    private void getDecode(){
        System.out.println(ENTER_ENCRYPTED_FILE_PATH);
        String line = scanner.nextLine();
        if(!line.equals("")){
            parameters[1] = line;
        }else {
            parameters[1] = "encoded.txt";
        }
        System.out.println(ENTER_KEY);
        parameters[3] = scanner.nextLine();
        System.out.println(ENTER_DECRYPTED_FILE_PATH);
        line = scanner.nextLine();
        if(!line.equals("")){
            parameters[2] = line;
        }else {
            parameters[2] = "output.txt";
        }
    }
    private void getEncode(){
        System.out.println(ENTER_ORIG_FILE_PATH);
        String line = scanner.nextLine();
        if(!line.equals("")){
            parameters[1] = line;
        }else {
            parameters[1] = "input.txt";
        }
        System.out.println(ENTER_CRYPT_FILE_PATH);
        line = scanner.nextLine();
        if(!line.equals("")){
            parameters[2] = line;
        }else {
            parameters[2] = "encoded.txt";
        }
    }
}
