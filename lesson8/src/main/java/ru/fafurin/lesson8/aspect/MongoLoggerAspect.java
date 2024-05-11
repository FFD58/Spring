package ru.fafurin.lesson8.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fafurin.lesson8.service.LogService;

@Aspect
@Component
public class MongoLoggerAspect {

    @Autowired
    private LogService logService;

    @Around("@annotation(ru.fafurin.lesson8.aspect.Logged)")
    public Object logMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object proceed = joinPoint.proceed();
        logService.createLog(methodName, proceed.toString());
        return proceed;
    }
}
