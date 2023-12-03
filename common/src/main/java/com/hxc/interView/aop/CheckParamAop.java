package com.hxc.interView.aop;

import com.hxc.interView.anno.CheckParam;
import com.hxc.interView.entity.User;
import com.hxc.interView.util.EntityParamCheck;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class CheckParamAop {



    /**
     * 参数校验
     */
    @Pointcut("execution(public * com.hxc.interview.userservice.controller.UserController.addUser(com.hxc.interView.entity.User))")
    public void ParamCheck(){

    }

    @Around("ParamCheck()")
    public void doBefore(ProceedingJoinPoint joinPoint) throws IllegalAccessException {
        Object[] args = joinPoint.getArgs();
        if (null == args || args.length == 0)
            return;
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Object obj = args[i];
            Annotation[] tmpAnno = parameterAnnotations[i];
            if (null == tmpAnno || tmpAnno.length == 0)
                continue;
            for (Annotation annotation : tmpAnno) {
                if (annotation.annotationType().equals(CheckParam.class)) {
                    checkParamCheck(obj, annotation);
                } else {
                    continue;
                }
            }
        }
    }

    public boolean checkParamCheck(Object param, Annotation anno) throws IllegalAccessException {
        CheckParam tmp = (CheckParam) anno;
        if (param instanceof User) {
            //user的校验
            return EntityParamCheck.checkUser((User) param, tmp.rule());
        }
        return true;
    }

}
