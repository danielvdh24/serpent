package com.projectserpent.frontend;

import com.projectserpent.UtilityClasses.ParseAndLoadFXML;
import com.projectserpent.backend.LeaderboardList;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.InputStream;

public final class StartApplication extends Application {
    @Override
    public void init(){
        LeaderboardList leaderboard = new LeaderboardList();
        leaderboard.loadJson();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent mainMenu = (Parent) ParseAndLoadFXML.returnFxmlFile("main-menu.fxml");
        Scene scene = new Scene(mainMenu);
        primaryStage.setResizable(false);

        // Load icon safely
        InputStream iconStream = getClass().getResourceAsStream("/Icon.png");
        if (iconStream != null) {
            primaryStage.getIcons().add(new Image(iconStream));
        }

        primaryStage.setTitle("Serpent Game");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}