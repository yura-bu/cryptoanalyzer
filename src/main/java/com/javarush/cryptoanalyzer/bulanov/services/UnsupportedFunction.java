package com.javarush.cryptoanalyzer.bulanov.services;

import com.javarush.cryptoanalyzer.bulanov.entity.Result;
import com.javarush.cryptoanalyzer.bulanov.exeptions.ApplicationException;
import com.javarush.cryptoanalyzer.bulanov.repository.ResultCode;

import static com.javarush.cryptoanalyzer.bulanov.constants.ApplicationCompletionConstants.EXCEPTION_UNSUPPORTED_FUNCTION;

public class UnsupportedFunction implements Function{
    @Override
    public Result execute(String[] parameters){

        return new Result(ResultCode.ERROR, new ApplicationException(EXCEPTION_UNSUPPORTED_FUNCTION));
    }
}
