package com.projectserpent.frontend;

import com.projectserpent.backend.LeaderboardList;
import com.projectserpent.backend.UserScore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import java.io.IOException;

public class LeaderboardController extends DeathScreenController {
    @FXML
    public TableView<UserScore> leaderboardTable;
    @FXML
    public TableColumn<String, Integer> scoreColumn;
    @FXML
    public TableColumn<String, String> nameColumn;
    private final LeaderboardList leaderboard = DeathScreenController.leaderboard;
    public ImageView backButtonNormal;
    public ImageView backButtonPressed;
    public Label titleLabel;

    @FXML
    public void switchToMainMenu(MouseEvent event) throws IOException {
        sceneSwitch(event, "main-menu.fxml");
    }
    @FXML
    public void startGame(MouseEvent event) throws IOException {
        sceneSwitch(event, "game-screen.fxml");
    }

    @FXML
    public void initialize() {
        loadLeaderboard();
        backButtonPressed.setVisible(false);
        Font.loadFont(getClass().getResource("/INVASION2000.TTF").toExternalForm(), 34);
    }

    public void loadLeaderboard() {
        ObservableList<UserScore> items = FXCollections.observableArrayList();
        convertToObservable(items);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        leaderboardTable.setItems(items);
    }
    @FXML
    public void convertToObservable(ObservableList<UserScore> list)  {
        list.addAll(leaderboard.getLeaderboard());
    }

    public void hoverBackButton(MouseEvent event) {
        backButtonPressed.setVisible(true);
        backButtonNormal.setVisible(false);
    }

    public void stopHoverBackButton(MouseEvent event) {
        backButtonPressed.setVisible(false);
        backButtonNormal.setVisible(true);
    }
}
