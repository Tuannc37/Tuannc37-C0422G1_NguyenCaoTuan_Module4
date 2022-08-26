package com.example.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.time.LocalDate;

public class BootAspect {
    private int count = 1;

    @AfterReturning(pointcut = "execution(* com.example.controller.AppBookController.*(..))")
    public void infoProcessing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        int c = count++;
        System.err.println(" Method " + methodName + " đã chạy xong " + c + " lần");
    }

    @Before("allMethodPointCut()")
    public void beforeCallMethod (){
        System.out.println(LocalDate.now());
    }
}
