package com.projectserpent.frontend;

import com.projectserpent.backend.LeaderboardList;
import com.projectserpent.backend.UserScore;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LeaderboardController extends DeathScreenController {
    @FXML
    public TableView<UserScore> leaderboardTable;
    @FXML
    public TableColumn<String, Integer> scoreColumn;
    @FXML
    public TableColumn<String, String> nameColumn;
    private final LeaderboardList leaderboard = DeathScreenController.leaderboard;


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
}
