package com.anton.testSpringFx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Oceanos on 19.01.2017.
 */
@Component
public class MainController implements Initializable, ControllerInt{
    private static final Logger logger = LoggerFactory.getLogger("MainController");

    Stage primaryStage;

    @FXML
    private Label lab;

    private String msg;
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public MainController( String msg){
        this.msg = msg;
        logger.info("MainContoller constructor");
    }


    public void initialize(URL location, ResourceBundle resources) {
        logger.info("MainController initialize");
        lab.setText(msg);
    }

    public void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }
    @PostConstruct
    public void springInit(){
        logger.info("MainController springInit");
    }
    @PreDestroy
    public void closeSpring(){
        logger.info("MainController springClose");
    }
}
