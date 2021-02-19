package com.example.fwk.filter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class ServiceAdvice {

    @Around("PointCutList.allService()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("6around start");
        Object result = null;

        String signatureName = pjp.getSignature().getDeclaringType().getSimpleName() + "." + pjp.getSignature().getName();
        String args = "";
        for(Object arg : pjp.getArgs()) {
            args += arg.toString() + ".";
        }

        System.out.println("7Controller Start : " + signatureName + "() with" + args);
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("8Controller End : " + signatureName + "() with" + args);
        return result;
    }
}
