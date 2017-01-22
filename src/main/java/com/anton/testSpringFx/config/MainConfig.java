package com.anton.testSpringFx.config;

import com.anton.testSpringFx.SimpleBean;
import com.anton.testSpringFx.controllers.InnerController;
import com.anton.testSpringFx.controllers.MainController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by Anton on 22.01.2017.
 */
@Configuration
@PropertySource("classpath:some.properties")
@ImportResource("classpath:spring-config.xml")
public class MainConfig {
    @Value("${id}")
    private String msg;


    @Bean
    public InnerController innerController(){
        return new InnerController();
    }
    @Bean
    public MainController mainController(){
        return new MainController(msg);
    }

}
