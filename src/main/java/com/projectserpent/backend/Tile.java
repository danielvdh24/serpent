package com.projectserpent.backend;

public class Tile {
    private final int x;    // The X coordinate
    private final int y;    // The Y coordinate

    // Constructor for the Tile, receives x and y coordinates
    // Has package visibility
    Tile(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Method which moves a Tile to a new location by adding/subtracting the deltaX/Y values from the original
    // coordinates.
    public Tile translate(int deltaX, int deltaY) {
        return new Tile(x + deltaX, y + deltaY);
    }

    // Method which checks if two tiles are equal to each other i.e. if they are the same Tile
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Tile)) return false;
        Tile tile = (Tile) other;
        return x == tile.x & y == tile.y;
    }

    public String toString() {
        return x + ", " + y;
    }
}