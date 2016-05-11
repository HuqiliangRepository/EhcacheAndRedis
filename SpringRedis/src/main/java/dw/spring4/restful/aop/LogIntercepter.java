package dw.spring4.restful.aop;

/**
 * Created by Administrator on 2015/8/4.
 */

import org.aspectj.lang.ProceedingJoinPoint;


import java.util.Arrays;


//@Component
//@Aspect
public class LogIntercepter {



/*     @Pointcut("execution(public * dw.spring3.rest.dao.impl..*.*(..))")
    public void mywearve() {
    }*/

    /* @Before("mywearve()")*/
    public void beforelog() {
        System.out.println("method is befor call*************************************************");
    }

    /*    @After("mywearve()")*/
    public void afterlog() {
        System.out.println("method is end call****************************************************");
    }

   /* *//*@AfterThrowing("mywearve()")*//*
    public void afterthrowinglog() {
        System.out.println("method is throwing Exception call****************************************************");
    }*/

    /*   @Around("mywearve()")*/
    public Object aroundlog(ProceedingJoinPoint pjp) throws Throwable {
        Object result = null;
        String methodName = pjp.getSignature().getName();
        try {
            System.out.println("调用方法" + methodName + " 之前打印日志 " + Arrays.asList(pjp.getArgs()));
            result = pjp.proceed();
            System.out.println("调用方法 " + methodName + " 之后打印日志 " + Arrays.asList(pjp.getArgs()));
        } catch (Exception e) {
            System.out.println("调用方法 " + methodName + " 出现异常打印 : " + e);
            throw new RuntimeException(e);
        }
        // System.out.println("The method " + methodName + " ends");

        return result;
    }


}
