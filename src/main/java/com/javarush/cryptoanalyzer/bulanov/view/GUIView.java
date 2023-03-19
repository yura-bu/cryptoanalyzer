package com.javarush.cryptoanalyzer.bulanov.view;

import com.javarush.cryptoanalyzer.bulanov.entity.Result;
import com.javarush.cryptoanalyzer.bulanov.view.myframe.CryptoAnalyzerFrame;

import static com.javarush.cryptoanalyzer.bulanov.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptoanalyzer.bulanov.constants.ApplicationCompletionConstants.SUCCESS;

public class GUIView implements View{
    private final String[] parameters;
    public GUIView(String[] parameters){
        this.parameters = parameters;
    }
    @Override
    public String[] parameters(){
        return parameters;
    }
    @Override
    public void printResult(Result result){
        switch (result.getResultCode()){
            case OK -> CryptoAnalyzerFrame.jLabelResult.setText(SUCCESS);
            case ERROR -> CryptoAnalyzerFrame.jLabelResult.setText("<html>" + EXCEPTION + result.getApplicationException().getMessage() + "<html>");
        }
    }
}
