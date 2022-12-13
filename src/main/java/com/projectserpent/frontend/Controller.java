package com.projectserpent.frontend;

import com.projectserpent.backend.*;
// import com.example.snakeerik1.backend.Leaderboard;
import com.projectserpent.frontend.painter.Painter;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller extends ParentController {

    private static SimpleIntegerProperty finalScore;

    @FXML
    public TableView<UserScore> leaderboardTable;
    @FXML
    public TableColumn<String, Integer> scoreColumn;
    @FXML
    public TableColumn<String, String> nameColumn;

    private SimpleStringProperty finalName;
    @FXML
    private Stage stage;
    @FXML
    public TextField usernameInputField;
    @FXML
    private FXMLLoader root;
    @FXML
    private Scene scene;
    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private GameLoop loop;
    private Grid grid;

    private UserScore userScore;
    private GraphicsContext context;
    private InputHandler inputHandler = new InputHandler();
    private static final LeaderboardList leaderboard = new LeaderboardList();
    // private static final Leaderboard leaderboard = new Leaderboard();
    @FXML
    public void switchToLeaderboard(ActionEvent event) throws IOException {
        root = new FXMLLoader(Controller.class.getResource("leaderboard.fxml"));
        root.setController(this);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load(), SCREEN_WIDTH, SCREEN_HEIGHT);
        ObservableList<UserScore> items = FXCollections.observableArrayList();
        convertToObservable(items);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
        leaderboardTable.setItems(items);
        stage.setScene(scene);
        stage.show();
        closeOnRequest(stage);
    }
    public void convertToObservable(ObservableList<UserScore> list) {
        list.addAll(leaderboard.getLeaderboard());
    }
    @FXML
    public void deathScreen(int parsedScore) throws IOException {
        root =  new FXMLLoader(StartApplication.class.getResource("death-screen.fxml"));
        root.setController(this);
        scene = new Scene(root.load(), SCREEN_WIDTH, SCREEN_HEIGHT);
        finalScore = new SimpleIntegerProperty(parsedScore);
        stage.setScene(scene);
        stage.show();
        closeOnRequest(stage);
    }
    
    
    public void saveScoreAsKnown(ActionEvent event) throws IOException {
        finalName = new SimpleStringProperty(usernameInputField.getText());
        userScore = new UserScore(finalName, finalScore);
        leaderboard.addScore(userScore);
        leaderboard.printLeaderboard();
        scoreSavedScreen(event);
    }
    public void saveScoreAsAnonymous(ActionEvent event) throws IOException {
        finalName = new SimpleStringProperty("Anonymous");
        userScore = new UserScore(finalName, finalScore);
        leaderboard.addScore(userScore);
        leaderboard.printLeaderboard();
        scoreSavedScreen(event);
    }
    
    @FXML
    public void scoreSavedScreen(ActionEvent event) throws IOException {
        root = new FXMLLoader(StartApplication.class.getResource("death-screen-saved.fxml"));
        root.setController(this);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load(), SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.setScene(scene);
        stage.show();
        closeOnRequest(stage);
    }
    @FXML
    public void switchToMainMenu(ActionEvent event) throws IOException {
        root = new FXMLLoader(Controller.class.getResource("main-menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root.load(), SCREEN_WIDTH, SCREEN_HEIGHT);
        stage.setScene(scene);
        stage.show();
        closeOnRequest(stage);
    }

    public void startGame(ActionEvent event) throws IOException {


        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        StackPane gameLayout = new StackPane();
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        context = canvas.getGraphicsContext2D();
        gameLayout.getChildren().add(canvas);

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(inputHandler);

        reset();                            // here the game starts after pressing Start Game

        scene = new Scene(gameLayout);
        stage.setScene(scene);
        stage.show();
        closeOnRequest(stage);
        (new Thread(loop)).start();




    }
    private void reset() {
        grid = new Grid(SCREEN_WIDTH, SCREEN_HEIGHT);
        loop = new GameLoop(grid, context);
        Painter.paint(grid, context);
    }

    public class InputHandler implements EventHandler<KeyEvent> {
        public void handle(KeyEvent event) {
            Snake snake = grid.getSnake();
            if (loop.isKeyPressed()) {
                return;
            }
            switch (event.getCode()) {
                case LEFT:
                    snake.goLeft();
                    break;
                case RIGHT:
                    snake.goRight();
                    break;
                case UP:
                    snake.goUp();
                    break;
                case DOWN:
                    snake.goDown();
                    break;
                case ENTER:
                    if (loop.isPaused()) {
                        loop.unPause();
                        try {
                            deathScreen(grid.scoreDisplay());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
            }

        }
    }
    public void closeOnRequest(Stage stage) {
        stage.setOnCloseRequest(e -> System.exit(0));
    }
}