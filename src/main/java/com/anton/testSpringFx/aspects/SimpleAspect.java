package com.anton.testSpringFx.aspects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Oceanos on 20.01.2017.
 */
public class SimpleAspect {

    public void before(){
        System.out.println("before method");
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
