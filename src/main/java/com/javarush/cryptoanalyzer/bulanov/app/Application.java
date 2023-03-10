package com.javarush.cryptoanalyzer.bulanov.app;

import com.javarush.cryptoanalyzer.bulanov.controllers.MainController;
import com.javarush.cryptoanalyzer.bulanov.entity.Result;
import com.javarush.cryptoanalyzer.bulanov.repository.FunctionCode;
import com.javarush.cryptoanalyzer.bulanov.services.Function;

public class Application{
    MainController mainController;
    public Application(MainController mainController){
        this.mainController = mainController;
    }

    public Result run(){
        String[] parameters = mainController.view().getParameters();
        String mode = parameters[0];
        Function function = getFunction(mode);
        return function.execute(parameters);
    }

    private Function getFunction(String mode){
        return switch (mode){
         case "1" -> FunctionCode.ENCODE.getFunction();
         case "2" -> FunctionCode.DECODE.getFunction();
         case "3" -> FunctionCode.BRUTE_FORCE.getFunction();
         default -> FunctionCode.UNSUPPORTED_FUNCTION.getFunction();
        };
    }
    public void printResult(Result result){
        mainController.view().printResult(result);
    }
}
