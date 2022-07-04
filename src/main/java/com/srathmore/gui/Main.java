package com.srathmore.gui;

import com.srathmore.gui.Database.DBImplementation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Insertion GUI");

        //Registration form page
        GridPane gridPane = createRegistrationForm();
        //Add ui controls
        addUIControls(gridPane);
        //Create a new scene with the gridPane as the root node.
        Scene scene = new Scene(gridPane, 800, 500);
        //Set the scene to the stage.
        primaryStage.setScene(scene);
        //Display the stage.
        primaryStage.show();
    }

    private GridPane createRegistrationForm() {
        //Instantiate new GridPane
        GridPane gridPane = new GridPane();

        //Set the GridPane's properties
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        //Add column constraints
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
        // header
        Label header = new Label("Registration Form");
        header.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(header, 0, 0, 2, 1);
        GridPane.setHalignment(header, HPos.CENTER);
        GridPane.setMargin(header, new Insets(20, 0, 20, 0));

        // Add Name Label
        Label nameLabel = new Label("Name:");
        gridPane.add(nameLabel, 0, 1);

        // Add Name Text Field
        TextField nameTextField = new TextField();
        nameTextField.setPrefHeight(40);
        gridPane.add(nameTextField, 1, 1);

        // Add Identity Number Label
        Label identityNumberLabel = new Label("Identity Number:");
        gridPane.add(identityNumberLabel, 0, 2);

        // Add Identity Number Text Field showing only numbers
        TextField identityNumberTextField = new TextField();
        identityNumberTextField.setPrefHeight(40);
        identityNumberTextField.setPromptText("Only numbers");
        identityNumberTextField.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().matches("[0-9]*")) {
                return change;
            } else {
                return null;
            }
        }));
        gridPane.add(identityNumberTextField, 1, 2);

        //Add Gender Label
        Label genderLabel = new Label("Gender:");
        gridPane.add(genderLabel, 0, 3);

        //Add Gender Choice Box
        ChoiceBox<String> genderChoiceBox = new ChoiceBox<>();
        genderChoiceBox.setValue("Male");
        genderChoiceBox.getItems().add("Male");
        genderChoiceBox.getItems().add("Female");
        gridPane.add(genderChoiceBox, 1, 3);

        //Add Date of Birth label
        Label dobLabel = new Label("Date of Birth:");
        gridPane.add(dobLabel, 0, 4);

        //Add Date of Birth Date Picker
        DatePicker dobDatePicker = new DatePicker();
        dobDatePicker.setPrefHeight(40);
        gridPane.add(dobDatePicker, 1, 4);

        //Add Place of Work/School
        Label placeOfWorkLabel = new Label("Place of Work/School:");
        gridPane.add(placeOfWorkLabel, 0, 5);

        //Add Place of Work/School Text Field
        TextField placeOfWorkTextField = new TextField();
        placeOfWorkTextField.setPrefHeight(40);
        gridPane.add(placeOfWorkTextField, 1, 5);

        //Add Residence Label
        Label residenceLabel = new Label("Residence:");
        gridPane.add(residenceLabel, 0, 6);

        //Add Residence Text Field
        TextField residenceTextField = new TextField();
        residenceTextField.setPrefHeight(40);
        gridPane.add(residenceTextField, 1, 6);

        //Add Period Label
        Label periodLabel = new Label("Period:");
        gridPane.add(periodLabel, 0, 7);

        //Add Period radio buttons that provides an option for either a 1 month, 3 months and 6 months in a HBox
        HBox periodHBox = new HBox(10);
        ToggleGroup periodToggleGroup = new ToggleGroup();
        RadioButton oneMonthRadioButton = new RadioButton("1 Month");
        oneMonthRadioButton.setToggleGroup(periodToggleGroup);
        oneMonthRadioButton.setSelected(true);
        RadioButton threeMonthsRadioButton = new RadioButton("3 Months");
        threeMonthsRadioButton.setToggleGroup(periodToggleGroup);
        RadioButton sixMonthsRadioButton = new RadioButton("6 Months");
        sixMonthsRadioButton.setToggleGroup(periodToggleGroup);
        periodHBox.getChildren().addAll(oneMonthRadioButton, threeMonthsRadioButton, sixMonthsRadioButton);
        gridPane.add(periodHBox, 1, 7);

        //Add Password Label
        Label passwordLabel = new Label("Password:");
        gridPane.add(passwordLabel, 0, 8);

        //Add Password Field with Password Mask
        PasswordField passwordField = new PasswordField();
        passwordField.setPrefHeight(40);
        gridPane.add(passwordField, 1, 8);

        //Add Confirm Password Label
        Label confirmPasswordLabel = new Label("Confirm Password:");
        gridPane.add(confirmPasswordLabel, 0, 9);

        //Add Confirm Password Field with Password Mask
        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPrefHeight(40);
        gridPane.add(confirmPasswordField, 1, 9);

        //Add Submit Button and cancel button
        HBox buttonHBox = new HBox();
        buttonHBox.setSpacing(10);
        buttonHBox.setAlignment(Pos.CENTER_RIGHT);
        Button submitButton = new Button("Submit");
        submitButton.setPrefHeight(40);
        submitButton.setPrefWidth(100);
        submitButton.setDefaultButton(true);
        Button cancelButton = new Button("Cancel");
        cancelButton.setPrefHeight(40);
        cancelButton.setPrefWidth(100);
        buttonHBox.getChildren().addAll(submitButton, cancelButton);
        gridPane.add(buttonHBox, 1, 10);

        //Add new event handler to the cancel button
        cancelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Close the stage
                ((Stage) gridPane.getScene().getWindow()).close();
            }
        });


        //Add a new event handler to the submit button
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Get the user input from the text fields
                String name = nameTextField.getText();
                String identityNumber = identityNumberTextField.getText();
                String password = passwordField.getText();
                String confirmPassword = confirmPasswordField.getText();
                String placeOfWork = placeOfWorkTextField.getText();
                String residence = residenceTextField.getText();
                String gender = genderChoiceBox.getValue();
                String period = "";
                String dob = null;
                //check if dob is null
                if (dobDatePicker.getValue() == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Date of Birth is required");
                    alert.setContentText("Please enter a date of birth");
                    alert.showAndWait();
                } else {
                    dob = dobDatePicker.getValue().toString();
                }
                //check selected period
                if (oneMonthRadioButton.isSelected()) {
                    period = "1 month";
                } else if (threeMonthsRadioButton.isSelected()) {
                    period = "3 months";
                } else if (sixMonthsRadioButton.isSelected()) {
                    period = "6 months";
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Period is required");
                    alert.setContentText("Please select a period");
                    alert.showAndWait();
                }

                //Log the user input to the console
                System.out.println("Name: " + name);
                System.out.println("Identity Number: " + identityNumber);
                System.out.println("Password: " + password);
                System.out.println("Confirm Password: " + confirmPassword);
                System.out.println("Place of Work: " + placeOfWork);
                System.out.println("Residence: " + residence);
                System.out.println("Gender: " + gender);
                System.out.println("Period: " + period);
                System.out.println("DoB" + dob);


                //Check if the user input is valid
                if (name.isEmpty() || identityNumber.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || placeOfWork.isEmpty() || residence.isEmpty() || period.isEmpty()) {
                    //Display error message
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error");
                    alert.setContentText("Please fill in all the fields");
                    alert.showAndWait();
                } else if (!password.equals(confirmPassword)) {
                    //Display error message
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Error");
                    alert.setContentText("Passwords do not match");
                    alert.showAndWait();
                } else {
                    //Add the user to the database
                    try {

                        DBImplementation db = new DBImplementation();
                        db.insert("persons", new String[]{"IdentityNumber", "Name", "Gender", "DateOfBirth", "PlaceOfWorkOrSchool", "Residence", "Password"}, new String[]{identityNumber, name, gender, dob, placeOfWork, residence, password});
                        //Display success message
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success");
                        alert.setHeaderText("Success");
                        alert.setContentText("Dear " + name + ", your account has been registered successfully for " + period + ".");
                        alert.showAndWait();

                    } catch (Exception e) {

                        e.printStackTrace();
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error");
                        alert.setHeaderText("Error");
                        alert.setContentText("An Error occurred while adding the user to the database");
                        alert.showAndWait();

                    }


                }
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch();
    }
}