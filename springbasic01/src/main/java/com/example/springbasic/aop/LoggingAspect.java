package com.example.springbasic.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // 포인트컷 정의
    @Pointcut("execution(* com.example.springbasic.service.*.*(..))")
    public void allServiceMethods() {}

    // Before
    @Before("allServiceMethods()")
    public void beforeMethod(JoinPoint joinPoint) {
        System.out.println("LoggingAspect Before: " + joinPoint.getSignature().getName());
    }

    // AfterReturning
    @AfterReturning(pointcut = "allServiceMethods()", returning = "result")
    public void afterReturning(Object result) {
        System.out.println("LoggingAspect After Returning: " + result);
    }

    // AfterThrowing
    @AfterThrowing(pointcut = "allServiceMethods()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("LoggingAspect After Throwing: " + ex.getMessage());
    }

    // After (finally)
    @After("allServiceMethods()")
    public void afterMethod() {
        System.out.println("LoggingAspect After (finally)");
    }

    // Around
    @Around("allServiceMethods()")
    public Object aroundMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("LoggingAspect Around - Before");
        Object result = pjp.proceed(); // 실제 메서드 실행
        System.out.println("LoggingAspect Around - After");
        return result;
    }
}