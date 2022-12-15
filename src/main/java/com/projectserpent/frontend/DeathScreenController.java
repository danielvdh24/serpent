package com.projectserpent.frontend;

import com.projectserpent.backend.LeaderboardList;
import com.projectserpent.backend.UserScore;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import java.io.IOException;

public class DeathScreenController extends ParentController{
    public Label ýourScore;
    private SimpleStringProperty finalName;
    private static SimpleIntegerProperty finalScore;
    @FXML
    public TextField usernameInputField;
    private UserScore userScore;
    protected static final LeaderboardList leaderboard = new LeaderboardList();


    @FXML
    public void initialize() {
        loadScore();
    }
    public void saveScoreAsKnown(MouseEvent event) throws IOException {
        finalName = new SimpleStringProperty(usernameInputField.getText());
        userScore = new UserScore(finalName, finalScore);
        leaderboard.addScore(userScore);
        leaderboard.printLeaderboard();
        sceneSwitch(event, "death-screen-saved.fxml");
    }
    public void saveScoreAsAnonymous(MouseEvent event) throws IOException {
        finalName = new SimpleStringProperty("Anonymous");
        userScore = new UserScore(finalName, finalScore);
        leaderboard.addScore(userScore);
        leaderboard.printLeaderboard();
        sceneSwitch(event, "death-screen-saved.fxml");
    }

    public void loadScore() {
        finalScore = new SimpleIntegerProperty(getScore());
        ýourScore.setText("Your score: " + getScore());
    }
}
