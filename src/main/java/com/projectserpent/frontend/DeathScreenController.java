package com.projectserpent.frontend;

import com.projectserpent.backend.LeaderboardList;
import com.projectserpent.backend.UserScore;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


import java.io.IOException;

public class DeathScreenController extends ParentController{
    @FXML
    public Label yourScore;
    @FXML
    public TextField usernameInputField;
    private UserScore userScore;
    protected static final LeaderboardList leaderboard = new LeaderboardList();
    public ImageView submitPressed, submitButtonNormal, anonymousButton, anonymousPressed;


    @FXML
    public void initialize() {
        submitPressed.setVisible(false);
        anonymousPressed.setVisible(false);
        loadScore();
    }

    public void saveScoreAsKnown(MouseEvent event) throws IOException {
        userScore = new UserScore(usernameInputField.getText(), getScore());
        leaderboard.addScore(userScore);
        leaderboard.printLeaderboard();
        sceneSwitch(event, "death-screen-saved.fxml");
    }
    public void saveScoreAsAnonymous(MouseEvent event) throws IOException {
        userScore = new UserScore("Anonymous", getScore());
        leaderboard.addScore(userScore);
        leaderboard.printLeaderboard();
        sceneSwitch(event, "death-screen-saved.fxml");
    }

    public void hoverSubmitButton(MouseEvent event) {
        submitPressed.setVisible(true);
        submitButtonNormal.setVisible(false);
    }

    public void stopHoverSubmitButton(MouseEvent event) {
        submitPressed.setVisible(false);
        submitButtonNormal.setVisible(true);
    }

    public void hoverAnonymousButton(MouseEvent event) {
        anonymousPressed.setVisible(true);
        anonymousButton.setVisible(false);
    }

    public void stopHoverAnonymousButton(MouseEvent event) {
        anonymousPressed.setVisible(false);
        anonymousButton.setVisible(true);
    }

    public void loadScore() {
        yourScore.setText("YOUR SCORE: " + getScore());
    }
}
