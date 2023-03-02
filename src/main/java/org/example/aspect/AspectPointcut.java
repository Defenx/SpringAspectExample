package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class AspectPointcut {
    @Pointcut("within(org.example.service.impl.*)")
    public void allMethodsPointcut() {}

    @Pointcut("execution(public * org.example.service.HumanService.findHumansByName(..))")
    public void callAtMyServicePublic() { }

    @Before("allMethodsPointcut()")
    public void loggingAdvice() {
        System.out.println("executing before method invoke");
    }

    @Before("callAtMyServicePublic()")
    public void beforeCallAtMethod(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        System.out.println("before " + jp + ", args=[" + args + "]");
    }

    @After("callAtMyServicePublic()")
    public void afterCallAt(JoinPoint jp) {
        System.out.println("after " + jp.getSignature().getName());
    }

    @Around("execution(* org.example.service.HumanService.*(int))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        System.out.println("Before invoking method" + joinPoint.getSignature());


        Object value = null;
        try {
            value = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }


        System.out.println("After invoking method. Return value=" + value);
        return value;
    }

    @Around("@annotation(org.example.annotation.Logger)")
    public Object loggingAnnotationAdvice(ProceedingJoinPoint joinPoint) {
        Object value = null;
        try {
            value = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("finish with: " + value);
        return value;
    }
}
