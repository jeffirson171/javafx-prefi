package aclcbukidnon.com.javafxactivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TrafficLightController {

    private enum TrafficLightColor {
        STOP,
        HOLD,
        GO,
    }

    private TrafficLightColor currentColor = TrafficLightColor.STOP;
    private Timeline timeline;

    @FXML
    private Circle redLight;

    @FXML
    private Circle yellowLight;

    @FXML
    private Circle greenLight;

    @FXML
    public void initialize() {
        updateLights(); // Set the initial light

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), e -> onTimerChange())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void onTimerChange() {
        switch (currentColor) {
            case STOP -> currentColor = TrafficLightColor.HOLD;
            case HOLD -> currentColor = TrafficLightColor.GO;
            case GO -> currentColor = TrafficLightColor.STOP;
        }
        updateLights();
    }

    private void updateLights() {
        // Set all lights to OFF color
        redLight.setFill(Color.web("#575757"));
        yellowLight.setFill(Color.web("#575757"));
        greenLight.setFill(Color.web("#575757"));

        // Turn ON the current light
        switch (currentColor) {
            case STOP -> redLight.setFill(Color.RED);
            case HOLD -> yellowLight.setFill(Color.YELLOW);
            case GO -> greenLight.setFill(Color.GREEN);
        }
    }
}
