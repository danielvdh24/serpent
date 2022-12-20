package com.projectserpent.frontend;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class MainMenuController extends ParentController {

    public ImageView startButtonHovered, startButtonNormal, leaderboardHoveredImage, leaderboardNormal;
    public void initialize() {
        startButtonHovered.setVisible(false);
        leaderboardHoveredImage.setVisible(false);
    }

    @FXML
    public void switchToLeaderboard(MouseEvent event) throws IOException {
        sceneSwitch(event, "leaderboard.fxml");
    }

    @FXML
    public void startGame(MouseEvent event) throws IOException {
        sceneSwitch(event, "game-screen.fxml");
    }

    public void hoverStartButton(MouseEvent event) {
        startButtonHovered.setVisible(true);
        startButtonNormal.setVisible(false);
    }

    public void stopHoverStartButton(MouseEvent event) {
        startButtonHovered.setVisible(false);
        startButtonNormal.setVisible(true);
    }

    public void hoverLeaderboardButton(MouseEvent event) {
        leaderboardHoveredImage.setVisible(true);
        leaderboardNormal.setVisible(false);
    }

    public void stopHoverLeaderboardButton(MouseEvent event) {
        leaderboardHoveredImage.setVisible(false);
        leaderboardNormal.setVisible(true);
    }

}