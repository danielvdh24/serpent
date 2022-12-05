package com.projectserpent.frontend;

import com.projectserpent.backend.Snake;
import com.projectserpent.backend.GameLoop;
import com.projectserpent.backend.Grid;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.canvas.Canvas;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class Game extends MainMenu {

    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private GameLoop loop;
    private Grid grid;
    private GraphicsContext context;
    private InputHandler inputHandler = new InputHandler();


    public void startGame(Stage window) {
        StackPane gameLayout = new StackPane();
        Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
        context = canvas.getGraphicsContext2D();
        gameLayout.getChildren().add(canvas);
        canvas.setFocusTraversable(true);

        canvas.setOnKeyPressed(inputHandler);

        reset();

        Scene scene = new Scene(gameLayout);
        window.setScene(scene);
        window.setOnCloseRequest(e -> System.exit(0));

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
                        reset();
                        (new Thread(loop)).start();
                    }
            }
        }
    }
}