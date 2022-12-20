package com.projectserpent.frontend;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DeathScreenSavedController extends ParentController {

    public ImageView newGameNormal, newGamePressed, leaderboardNormal, leaderboardPressed, mainMenuNormal, mainMenuPressed;
    public void initialize() {
        newGamePressed.setVisible(false);
        leaderboardPressed.setVisible(false);
        mainMenuPressed.setVisible(false);
    }

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

    public void hoverNewGameButton(MouseEvent event) {
        newGameNormal.setVisible(false);
        newGamePressed.setVisible(true);
    }

    public void stopHoverNewGameButton(MouseEvent event) {
        newGameNormal.setVisible(true);
        newGamePressed.setVisible(false);
    }

    public void hoverLeaderboardButton(MouseEvent event) {
        leaderboardNormal.setVisible(false);
        leaderboardPressed.setVisible(true);
    }

    public void stopHoverLeaderboardButton(MouseEvent event) {
        leaderboardNormal.setVisible(true);
        leaderboardPressed.setVisible(false);
    }

    public void hoverMainMenuButton(MouseEvent event) {
        mainMenuNormal.setVisible(false);
        mainMenuPressed.setVisible(true);
    }

    public void stopHoverMainMenuButton(MouseEvent event) {
        mainMenuNormal.setVisible(true);
        mainMenuPressed.setVisible(false);
    }
}
