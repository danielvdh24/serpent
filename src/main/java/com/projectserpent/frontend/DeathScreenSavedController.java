package com.projectserpent.frontend;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DeathScreenSavedController extends ParentController {



    @FXML
    public void switchToMainMenu(MouseEvent event) throws IOException {
        sceneSwitch(event, "main-menu.fxml");
    }
    @FXML
    public void startGame(MouseEvent event) throws IOException {
        sceneSwitch(event, "game-screen.fxml");
    }

    @FXML
    public void switchToLeaderboard(MouseEvent event) throws IOException {
        sceneSwitch(event, "leaderboard.fxml");
    }
}
