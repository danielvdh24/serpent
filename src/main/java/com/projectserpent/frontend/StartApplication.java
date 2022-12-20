package com.projectserpent.frontend;

import com.projectserpent.UtilityClasses.ParseAndLoadFXML;
import com.projectserpent.backend.LeaderboardList;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public final class StartApplication extends Application {
    @Override
    public void init(){
        LeaderboardList leaderboard = new LeaderboardList();
        leaderboard.loadJson();
        Font.loadFont(getClass().getResource("/INVASION2000.TTF").toExternalForm(), 34);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Object mainMenu = ParseAndLoadFXML.returnFxmlFile("main-menu.fxml");
        Scene scene = new Scene((Parent) mainMenu);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image((new FileInputStream("src/main/resources/Icon.png"))));
        primaryStage.setTitle("Serpent");
        primaryStage.setScene(scene);
        // We need to implement a way to force the game to close when the exit button is clicked, as it sometimes
        // continues to run in the IDE even after the button is pressed.
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}