package com.example.projectserpent.logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class Grid {

    // Here we set the desired Tile size, the number indicates width AND height in pixels (it's a square).
    public static final int SIZE = 30;
    private final int columns;
    private final int rows;

    private Snake snake;            // instantiating a Snake object.
    private Consumable consumable;  // instantiating a Consumable object.

    // Constructor which created a grid made up of Tiles, the BlackBlueGrid.png was created in Adobe Photoshop
    // so that it would match the one created by this logic.
    public Grid(final double width, final double height) {
        rows = (int) width / SIZE;
        columns = (int) height / SIZE;

        // Initializing the snake in the middle of the screen.
        snake = new Snake(this, new Tile(rows / 2, columns / 2));

        // Creates a new Consumable in a random Tile.
        consumable = new Consumable(getRandomTile());
    }

    // This is the logic behind the snake "wrapping" around the screen.
    // Example: The snake turns left and comes out of the right side of the window.
    public Tile wrap(Tile tile) {
        int x = tile.getX();
        int y = tile.getY();
        if (x >= rows) x = 0;
        if (y >= columns) y = 0;
        if (x < 0) x = rows - 1;
        if (y < 0) y = columns - 1;
        return new Tile(x, y);
    }

    // Simple method to get a random x and y coordinate for a Tile.
    private Tile getRandomTile() {
        Random random = new Random();
        Tile tile;
        do {
            tile = new Tile(random.nextInt(rows), random.nextInt(columns));
        } while (tile.equals(snake.getHead()));
        return tile;
    }

    public void update() {
        if (consumable.getTile().equals(snake.getHead())) {
            snake.extend();
            consumable.setTile(getRandomTile());
        } else {
            snake.move();
        }
    }

    // This is the "painter" that sets the background to our custom blue grid.
    public void paint(GraphicsContext gc) {
        Image blueGrid;
        try {
            blueGrid = new Image(new FileInputStream("src/main/resources/BlackBlueGrid.png"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        gc.setFill(new ImagePattern(blueGrid));
        gc.fillRect(0, 0, rows * SIZE, columns * SIZE);
    }

    //Simple getters and setters
    public Snake getSnake() {
        return snake;
    }
    public Consumable getFood() {
        return consumable;
    }
}