package com.hxc.interview.commonservice.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CheckParamAop {

    @Pointcut("target(com.hxc.interview.userservice.controller)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void doBefore() {
        System.out.println("hello");
    }

}
