package aclcbukidnon.com.javafxactivity;

import aclcbukidnon.com.javafxactivity.controllers.SplashScreenController;
import aclcbukidnon.com.javafxactivity.controllers.CalculatorController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Show splash screen first
        var splashScreenFxml = new FXMLLoader(Main.class.getResource("splash-screen-view.fxml"));
        var splashScreenScene = new Scene(splashScreenFxml.load(), 800, 600);

        var splashScreenCtrl = (SplashScreenController) splashScreenFxml.getController();
        splashScreenCtrl.setStage(stage);


        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setTitle("Activity");
        stage.setScene(splashScreenScene);
        stage.show();

        stage.setOnHidden(event -> showCalculator(stage));
    }

    private void showCalculator(Stage stage) {
        try {

            var calculatorFxml = new FXMLLoader(Main.class.getResource("calculator-view.fxml"));
            var calculatorScene = new Scene(calculatorFxml.load(), 600, 400);

            var calculatorCtrl = (CalculatorController) calculatorFxml.getController();

            stage.setMinWidth(600);
            stage.setMinHeight(400);
            stage.setTitle("Calculator");
            stage.setScene(calculatorScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
