package com.projectserpent.frontend;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

/***
 * Controller for main menu
 */
public class MainMenuController extends ParentController {

    @FXML
    public ImageView startButtonHovered, startButtonNormal, leaderboardHovered, leaderboardNormal;

    //Initializes pre-requisites for interactive hover animation.
    @FXML
    public void initialize() {
        startButtonHovered.setVisible(false);
        leaderboardHovered.setVisible(false);
    }
    //Method is called when "Leaderboard" button is pressed.
    @FXML
    public void switchToLeaderboard(MouseEvent event) throws IOException {
        sceneSwitch(event, "leaderboard.fxml");
    }
    //Method is called when "Start Game" button is pressed
    @FXML
    public void startGame(MouseEvent event) throws IOException {
        sceneSwitch(event, "game-screen.fxml");
    }
    /*
    Hover animation methods
     */
    @FXML
    public void hoverStartButton(MouseEvent event) {
        startButtonHovered.setVisible(true);
        startButtonNormal.setVisible(false);
    }
    @FXML
    public void stopHoverStartButton(MouseEvent event) {
        startButtonHovered.setVisible(false);
        startButtonNormal.setVisible(true);
    }
    @FXML
    public void hoverLeaderboardButton(MouseEvent event) {
        leaderboardHovered.setVisible(true);
        leaderboardNormal.setVisible(false);
    }
    @FXML
    public void stopHoverLeaderboardButton(MouseEvent event) {
        leaderboardHovered.setVisible(false);
        leaderboardNormal.setVisible(true);
    }

}