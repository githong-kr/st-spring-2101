package com.example.fwk.filter;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class ControllerAdvice {

    @Before("PointCutList.allController()")
    public void before() {
        System.out.println("1before");
    }

    @After("PointCutList.allController()")
    public void after() {
        System.out.println("2after");
    }

    @Around("PointCutList.allController()")
    public Object around(ProceedingJoinPoint pjp) {
        System.out.println("3around start");
        Object result = null;

        HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String signatureName = pjp.getSignature().getDeclaringType().getSimpleName() + "." + pjp.getSignature().getName();

        System.out.println("4Controller Start : " + signatureName + " by " + req.getRemoteAddr());
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        System.out.println("5Controller End : " + signatureName);
        return result;
    }
}
