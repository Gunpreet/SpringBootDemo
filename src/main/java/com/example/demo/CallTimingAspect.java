package com.example.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
class CallTimingAspect {


    @Pointcut("within(com.example.demo.services.*)")
    private void getServiceMethods() {
    }


    @Around(value = "getServiceMethods()")
    public void fetchCallTimings(ProceedingJoinPoint joinPoint) {
        System.out.println("Entering Aspect");
        long start = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
    }
}
