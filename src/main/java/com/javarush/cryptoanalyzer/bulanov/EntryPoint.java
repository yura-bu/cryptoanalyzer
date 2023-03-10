package com.javarush.cryptoanalyzer.bulanov;


import com.javarush.cryptoanalyzer.bulanov.app.Application;
import com.javarush.cryptoanalyzer.bulanov.controllers.MainController;
import com.javarush.cryptoanalyzer.bulanov.entity.Result;
import com.javarush.cryptoanalyzer.bulanov.view.ConsolView;
import com.javarush.cryptoanalyzer.bulanov.view.View;

public class EntryPoint{
    public static void main(String[] args){
        View view = new ConsolView();
        MainController mainController = new MainController(view);
        Application application = new Application(mainController);
        Result result = application.run();
        switch (result.getResultCode()){
            case OK -> System.out.println("The application completed successfully!!! ");
            case ERROR -> System.out.println("The application has exited with an error: " + result.getApplicationException().getMessage());
        }
    }
}
