package com.hxc.interView.common.controller;

import com.hxc.interView.common.result.ServiceResult;
import com.hxc.interView.common.exception.BaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
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
