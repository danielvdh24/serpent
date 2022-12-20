package com.projectserpent.frontend;

import com.projectserpent.backend.GameLoop;
import com.projectserpent.backend.Grid;
import com.projectserpent.backend.Snake;
import com.projectserpent.frontend.painter.Painter;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GameScreenController extends ParentController {
    private GameLoop loop;
    private Grid grid;
    public Canvas gameCanvas;
    private GraphicsContext context;
    private final int SCREEN_WIDTH = 600;
    private final int SCREEN_HEIGHT = 600;
    private InputHandler inputHandler = new InputHandler();


    @FXML
    public void initialize() {
        context = gameCanvas.getGraphicsContext2D();
        gameCanvas.setFocusTraversable(true);
        gameCanvas.setOnKeyPressed(inputHandler);
        newGame();                            // here the game starts after pressing Start Game
        (new Thread(loop)).start();
    }

    private void newGame() {
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
                        setScore(grid.scoreDisplay());
                        try {
                            sceneSwitch(event, "death-screen.fxml");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }

            }
        }
    }
}
