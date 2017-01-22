package com.anton.testSpringFx;

import org.springframework.stereotype.Component;

/**
 * Created by Anton on 21.01.2017.
 */
@Component
public class SimpleBean {
    public void sayHi(){
        System.out.println("Say hi!");
    }
}
