package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;

public class CalculatorController {

    @FXML
    private Label displayLabel; // The label that displays the current input and result

    private String currentInput = ""; // Stores the current input being typed
    private double firstOperand = 0; // First operand for the calculation
    private String operator = ""; // Operator for the calculation

    // Called when the calculator starts
    public void initialize() {
        displayLabel.setText("0"); // Initialize the display to "0"
    }

    // Handle number button clicks
    @FXML
    private void onNumberClick(ActionEvent event) {
        String buttonText = ((javafx.scene.control.Button) event.getSource()).getText();

        if (currentInput.equals("0")) {
            currentInput = buttonText; // Replace 0 with the clicked number
        } else {
            currentInput += buttonText; // Append the clicked number to current input
        }

        displayLabel.setText(currentInput); // Update the display
    }

    // Handle operator button clicks (+, -, *, /)
    @FXML
    private void onOperatorClick(ActionEvent event) {
        String buttonText = ((javafx.scene.control.Button) event.getSource()).getText();

        if (!currentInput.isEmpty()) {
            firstOperand = Double.parseDouble(currentInput); // Store the first operand
            currentInput = ""; // Clear the current input for the next number
            operator = buttonText; // Store the operator
        }
    }

    // Handle the "=" button click to compute the result
    @FXML
    private void onEqualClick() {
        if (!currentInput.isEmpty()) {
            double secondOperand = Double.parseDouble(currentInput); // Get the second operand
            double result = 0;

            // Perform the operation based on the operator
            switch (operator) {
                case "+":
                    result = firstOperand + secondOperand;
                    break;
                case "-":
                    result = firstOperand - secondOperand;
                    break;
                case "*":
                    result = firstOperand * secondOperand;
                    break;
                case "/":
                    if (secondOperand != 0) {
                        result = firstOperand / secondOperand;
                    } else {
                        displayLabel.setText("Error"); // Handle division by zero
                        return;
                    }
                    break;
            }

            // Display the result and reset variables
            displayLabel.setText(String.valueOf(result));
            currentInput = String.valueOf(result); // Allow further calculations with the result
            operator = ""; // Reset operator
        }
    }

    // Handle the "C" (Clear) button click
    @FXML
    private void onClearClick() {
        currentInput = ""; // Clear the current input
        operator = ""; // Reset operator
        displayLabel.setText("0"); // Reset the display to "0"
    }

    // Handle the "BCKSPC" (Backspace) button click
    @FXML
    private void onBackspaceClick() {
        if (currentInput.length() > 0) {
            currentInput = currentInput.substring(0, currentInput.length() - 1); // Remove last character
            if (currentInput.isEmpty()) {
                currentInput = "0"; // If input is empty, set it back to 0
            }
            displayLabel.setText(currentInput); // Update the display
        }
    }
}
