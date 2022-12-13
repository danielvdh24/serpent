package com.projectserpent.frontend;

import com.projectserpent.UtilityClasses.ParseAndLoadFXML;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public final class StartApplication extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Object mainMenu = ParseAndLoadFXML.returnFxmlFile("main-menu.fxml");
        Scene scene = new Scene((Parent) mainMenu);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Serpent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}