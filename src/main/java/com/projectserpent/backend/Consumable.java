package com.projectserpent.backend;


import javafx.scene.paint.Color;

// Class that makes Consumables which are one Tile size
public class Consumable {
    public static final Color COLOR = Color.DARKRED;
    private Tile tile;

    // Constructor receives a tile and passes on that location to the consumable object
    Consumable(Tile tile) {
        this.tile = tile;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}