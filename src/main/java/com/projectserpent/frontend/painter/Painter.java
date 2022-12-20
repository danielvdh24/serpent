package com.projectserpent.frontend.painter;

import com.projectserpent.backend.*;

import com.projectserpent.backend.Consumable;
import com.projectserpent.backend.Grid;
import com.projectserpent.backend.Snake;
import com.projectserpent.backend.Tile;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;

public class Painter {

    public static void paint(Grid grid, GraphicsContext gc) {
        // Calling the Grid class to set Background to Grid
        grid.paint(gc);

        // Coloring the Consumable
        gc.setFill(Consumable.COLOR);
        paintTile(grid.getFood().getTile(), gc);

        // Coloring the Snake
        Snake snake = grid.getSnake();
        gc.setFill(Snake.COLOR);
        snake.getTiles().forEach(tile -> paintTile(tile, gc));
        if (!snake.isSafe()) {
            gc.setFill(Snake.DEAD);
            paintTile(snake.getHead(), gc);
        }

        // Formatting Current Score Text
        gc.setFill(Color.BEIGE);
        gc.fillText("Score : " + grid.scoreDisplay(), 10, 590);
    }

    private static void paintTile(Tile tile, GraphicsContext gc) {
        gc.fillRect(tile.getX() * Grid.SIZE, tile.getY() * Grid.SIZE, Grid.SIZE, Grid.SIZE);
    }

    // Prompt to restart the game when the Snake dies.
    /** This is where we will need to enter a username which would then get saved into the Leaderboard. */
    public static void paintResetMessage(GraphicsContext gc, Grid grid) {
        int canvasWidth = (int) gc.getCanvas().getWidth();
        int canvasHeight = (int) gc.getCanvas().getHeight();
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFill(Color.ORANGERED);
        gc.fillText("YOU DIED", canvasWidth / 2, canvasHeight / 2 - 80);
        gc.setFill(Color.GREEN);
        gc.fillText("Score: " + grid.scoreDisplay(), canvasWidth / 2, canvasHeight / 2 - 50);
        gc.fillText("PRESS 'ENTER' TO CONTINUE", canvasWidth / 2, canvasHeight / 2 - 20);
    }
}