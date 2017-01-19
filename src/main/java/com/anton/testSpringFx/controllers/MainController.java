package com.anton.testSpringFx.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Oceanos on 19.01.2017.
 */
public class MainController implements Initializable{
    @FXML
    private Label lab;

    private String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public MainController(String msg){

    }


    public void initialize(URL location, ResourceBundle resources) {
        lab.setText(msg);
    }
}
