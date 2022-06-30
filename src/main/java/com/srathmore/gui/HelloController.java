package com.srathmore.gui;

import com.srathmore.gui.Database.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        DBConnection connectNow = new DBConnection();
        Connection connectDB = connectNow.getConnection();

        String connectQuery = "select Name from persons";
        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(connectQuery);

            while (queryOutput.next()){
                welcomeText.setText(queryOutput.getString("Name"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
//        welcomeText.setText("Welcome to JavaFX Application!");
    }
}