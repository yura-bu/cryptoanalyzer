package com.javarush.cryptoanalyzer.bulanov.entity;

import com.javarush.cryptoanalyzer.bulanov.exeptions.ApplicationException;
import com.javarush.cryptoanalyzer.bulanov.repository.ResultCode;

public class Result{
    private final ResultCode resultCode;
    private ApplicationException applicationException;


    public Result(ResultCode resultCode){
        this.resultCode = resultCode;
    }

    public Result(ResultCode resultCode, ApplicationException applicationException){
        this.resultCode = resultCode;
        this.applicationException = applicationException;
    }

    public ApplicationException getApplicationException(){
        return applicationException;
    }

    public ResultCode getResultCode(){
        return resultCode;
    }
}
