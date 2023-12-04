package com.hxc.interView.controller;

import com.hxc.interView.exception.BaseException;
import com.hxc.interView.result.ServiceResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BaseException.class)
    @ResponseBody
    public ServiceResult handleException(HttpServletRequest request, BaseException exception) {
        return ServiceResult.error(exception.getErrorCode(), exception.getMessage(), exception.getData());
    }

}
