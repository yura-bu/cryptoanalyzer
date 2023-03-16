package com.javarush.cryptoanalyzer.bulanov.view;

import com.javarush.cryptoanalyzer.bulanov.entity.Result;
import static com.javarush.cryptoanalyzer.bulanov.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptoanalyzer.bulanov.constants.ApplicationCompletionConstants.SUCCESS;

public record GUIView(String[] parameters) implements View{
    @Override
    public String[] parameters(){
        return parameters;
    }
    @Override
    public void printResult(Result result){
        switch (result.getResultCode()) {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION + result.getApplicationException().getMessage());
        }
    }
}
