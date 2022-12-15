package com.projectserpent.frontend;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class MainMenuController extends ParentController {

    @FXML
    public void switchToLeaderboard(MouseEvent event) throws IOException {
        sceneSwitch(event, "leaderboard.fxml");
    }

    public void startGame(MouseEvent event) throws IOException {
        sceneSwitch(event, "game-screen.fxml");
    }
}
