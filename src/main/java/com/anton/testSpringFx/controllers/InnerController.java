package com.anton.testSpringFx.controllers;

import com.anton.testSpringFx.SimpleBean;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by Oceanos on 20.01.2017.
 */
@Component
public class InnerController implements ControllerInt {
    @Autowired
    public void setSimpleBean(SimpleBean simpleBean) {
        this.simple = simpleBean;
    }

    private SimpleBean simple;
    @FXML
    private void openNewWindow(ActionEvent e){
        clickHandle();
        Stage stage = new Stage();
        Pane pane = new Pane();
        Label label = new Label("New window");
        Button btn = new Button("Close");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        pane.getChildren().addAll(label, btn);
        stage.setScene(new Scene(pane, 100, 100));
        stage.initOwner(primaryStage);
        stage.show();
    }

    private Stage primaryStage;
    public void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }
    private void clickHandle(){
        simple.sayHi();
    }

}
