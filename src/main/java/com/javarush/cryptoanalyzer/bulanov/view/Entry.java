package com.javarush.cryptoanalyzer.bulanov.view;

import com.javarush.cryptoanalyzer.bulanov.app.Application;
import com.javarush.cryptoanalyzer.bulanov.controllers.MainController;
import com.javarush.cryptoanalyzer.bulanov.entity.Result;
import com.javarush.cryptoanalyzer.bulanov.view.myframe.CryptoAnalyzerFrame;

import static com.javarush.cryptoanalyzer.bulanov.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.cryptoanalyzer.bulanov.constants.ApplicationCompletionConstants.SUCCESS;

public class Entry{
    public void entry(String[] parameters){
        View view = new GUIView(parameters);
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        Result result = application.run();
        switch (result.getResultCode()){
            case OK -> CryptoAnalyzerFrame.jLabelResult.setText(SUCCESS);
            case ERROR -> CryptoAnalyzerFrame.jLabelResult.setText("<html>" + EXCEPTION + result.getApplicationException().getMessage() + "<html>");
        }
    }

}
