package com.example.springbasic.aspect;

import com.example.springbasic.dto.Comment;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class UserAspect {
    private Logger logger = Logger.getLogger(UserAspect.class.getName());

    @Around("execution(* com.example.springbasic.services.*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        Object [] arguments = joinPoint.getArgs();

        logger.info("메소드 " + methodName +
                " ,파라미터 " + Arrays.asList(arguments) +
                " aspect 성공");


        Comment comment = new Comment();
        comment.setName("김하수");
        comment.setContent("하수입니다.");
        Object [] newArguments = {comment};

        Object returnedByMethod = joinPoint.proceed(newArguments);

        logger.info("메소드 리턴값 " + returnedByMethod);

        return "FAILED";

    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }


}
