package com.javarush.cryptoanalyzer.bulanov.controllers;

import com.javarush.cryptoanalyzer.bulanov.view.View;
public  class MainController{
    private final View view;
    public MainController(View view){
        this.view = view;
    }
    public View view(){
        return view;
    }
}


