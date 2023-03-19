package com.javarush.cryptoanalyzer.bulanov.view;

import com.javarush.cryptoanalyzer.bulanov.app.Application;
import com.javarush.cryptoanalyzer.bulanov.controllers.MainController;
import com.javarush.cryptoanalyzer.bulanov.entity.Result;


public class Entry{
    public void entry(String[] parameters){
        View view = new GUIView(parameters);
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        Result result = application.run();
        view.printResult(result);
    }

}
