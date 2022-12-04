package com.example.projectserpent.logic;

import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    public static final Color COLOR = Color.CORNSILK;
    public static final Color DEAD = Color.RED;
    private Grid grid;
    private int length;
    private boolean safe;
    private List<Tile> tiles;
    private Tile head;
    private int xVelocity;
    private int yVelocity;

    // Constructor for the snake, it receives the Grid it will exist in, and a Tile to start with.
    public Snake(Grid grid, Tile initialTile) {
        this.length = 1;
        this.tiles = new LinkedList<>();
        tiles.add(initialTile);
        this.head = initialTile;
        this.safe = true;
        this.grid = grid;
        this.xVelocity = 0;
        this.yVelocity = 0;
    }

    // Method to increase the length of the snake by 1, used when Consumables are eaten.
    private void growTo(Tile tile) {
        length++;
        checkAndAdd(tile);
    }

    // Method which actually shows the "movement" of the snake.
    // It adds a Tile to the front of the snake (in the direction it's moving) thereby replacing the "head" of the snake,
    // then it deletes the last Tile in the snake, which makes it look like the snake is moving through the grid.
    // The method is called in every update of the game, so it constantly updates.
    private void shiftTo(Tile tile) {
        // The head of the snake becomes the new Tile
        checkAndAdd(tile);
        // The last Tile is removed
        tiles.remove(0);
    }

    // Method that adds a Tile (extends the Snake) if it is "safe" i.e. it hasn't run into itself yet.
    // "!tiles.contains(tile)" - checks if the LinkedList of tiles i.e. the snake body contains the Tile
    // that the Snake has come into contact with, if it does that means it has collided with itself
    // and the "safe" marker changes to false.
    private void checkAndAdd(Tile tile) {
        tile = grid.wrap(tile);
        safe = safe && !tiles.contains(tile);
        tiles.add(tile);
        head = tile;
    }

    // Method which returns the list of Tiles in the Snake body.
    public List<Tile> getTiles() {
        return tiles;
    }

    // Method which returns the safe property of the snake, note the OR between safe and length.
    // This exists because when the game starts the snake only has 1 Tile, so it is unsafe by default.
    // The OR makes it so that IF the length is 1 it will return true thereby sidestepping this issue.
    public boolean isSafe() {
        return safe || length == 1;
    }

    public Tile getHead() {
        return head;
    }

    // Method which checks whether the Snake is moving and returns a boolean value.
    private boolean isStill() {
        return xVelocity == 0 & yVelocity == 0;
    }

    // Make the snake move one square in its current direction.
    public void move() {
        if (!isStill()) {
            shiftTo(head.translate(xVelocity, yVelocity));
        }
    }

    // Make the snake extend/grow to the square where it's headed.
    public void extend() {
        if (!isStill()) {
            growTo(head.translate(xVelocity, yVelocity));
        }
    }

    // Methods to change the direction of the snake movement.
    // Each has an insurance that a snake cannot move so that it runs into itself on the same axis. In other
    // words, while the snake moves up it cannot suddenly go down and hit itself, this is why the goUp method
    // has an if statement which checks the yVelocity and won't allow the snake to move into itself.
    public void goUp() {
        if (yVelocity == 1 && length > 1) return;
        xVelocity = 0;
        yVelocity = -1;
    }
    public void goDown() {
        if (yVelocity == -1 && length > 1) return;
        xVelocity = 0;
        yVelocity = 1;
    }
    public void goLeft() {
        if (xVelocity == 1 && length > 1) return;
        xVelocity = -1;
        yVelocity = 0;
    }
    public void goRight() {
        if (xVelocity == -1 && length > 1) return;
        xVelocity = 1;
        yVelocity = 0;
    }
}