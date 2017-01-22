package com.anton.testSpringFx.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Oceanos on 20.01.2017.
 */
@Aspect
public class SimpleAspect {
    @Pointcut("execution(* *.sayHi(..))")
    private void setPrimaryStageMethod(){

    }
    @Before("setPrimaryStageMethod()")
    public void before(JoinPoint joinPoint){
        System.out.println("before method "+joinPoint.toString());
    }
    public void after(){
        System.out.println("after");
    }
    public void afterReturning(){
        System.out.println("after returning");
    }
    public void afterThrowing(){
        System.out.println("after throwing");
    }
}
