package com.anton.testSpringFx;

import com.anton.testSpringFx.config.MainConfig;
import com.anton.testSpringFx.controllers.ControllerInt;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * Created by Oceanos on 19.01.2017.
 */
public class Main extends Application {
    private static final Logger logger = LoggerFactory.getLogger("Main");
    private final AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

    public void start(final Stage primaryStage) throws Exception {
        logger.info("start");
        //final ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        ctx.registerShutdownHook();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));

        loader.setControllerFactory(new Callback<Class<?>, Object>() {
            public Object call(Class<?> param) {
                ControllerInt controller = (ControllerInt) ctx.getBean(param);
                controller.setPrimaryStage(primaryStage);
                return controller;
            }
        });

        Parent root = loader.load();
        System.out.println(loader.getController());
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void init(){
        logger.info("init");
    }
    public void stop(){
        ctx.stop();
        logger.info("stop");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
