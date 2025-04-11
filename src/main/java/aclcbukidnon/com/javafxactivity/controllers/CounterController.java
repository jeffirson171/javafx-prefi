package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CounterController {

    @FXML
    private Button decrementButton;

    @FXML
    private Button incrementButton;

    @FXML
    private Label counterLabel;

    private int counter = 0; // Encapsulation: private counter variable

    @FXML
    private void initialize() {
        updateCounterLabel();

        decrementButton.setOnAction(_ -> decrement());
        incrementButton.setOnAction(_ -> increment());
    }

    private void increment() {
        counter++;
        updateCounterLabel();
    }

    private void decrement() {
        counter--;
        updateCounterLabel();
    }

    private void updateCounterLabel() {
        counterLabel.setText(String.valueOf(counter));
    }
}
