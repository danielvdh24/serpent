package com.projectserpent.frontend;

import com.projectserpent.backend.Consumable;
import com.projectserpent.backend.Grid;
import com.projectserpent.backend.Tile;
import com.projectserpent.backend.Snake;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import static com.projectserpent.backend.Grid.SIZE;

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
        gc.fillText("Score : " + snake.getTiles().size(), 10, 590);
    }

    private static void paintTile(Tile tile, GraphicsContext gc) {
        gc.fillRect(tile.getX() * SIZE, tile.getY() * SIZE, SIZE, SIZE);
    }

    // Prompt to restart the game when the Snake dies.
    /** This is where we will need to enter a username which would then get saved into the Leaderboard. */
    public static void paintResetMessage(GraphicsContext gc) {
        gc.setFill(Color.ORANGERED);
        gc.fillText("Hit ENTER to Restart", 300, 300);
    }
}