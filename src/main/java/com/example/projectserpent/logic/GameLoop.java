package com.example.projectserpent.logic;

import com.example.projectserpent.gui.Painter;
import javafx.scene.canvas.GraphicsContext;

public class GameLoop implements Runnable {
    private final Grid grid;
    private final GraphicsContext context;
    private int frameRate;
    private float interval;
    private boolean running;
    private boolean paused;
    private boolean keyIsPressed;

    public GameLoop(final Grid grid, final GraphicsContext context) {
        this.grid = grid;
        this.context = context;
        frameRate = 18;
        interval = 1000.0f / frameRate; // Framerate calculator
        running = true;
        paused = false;
        keyIsPressed = false;
    }

    @Override
    public void run() {
        while (running && !paused) {
            // Time the update and paint calls.
            float time = System.currentTimeMillis();
            keyIsPressed = false;
            grid.update();
            Painter.paint(grid, context);

            if (!grid.getSnake().isSafe()) {
                pause();
                Painter.paintResetMessage(context); //this is where the death message happens
                break;
            }
            time = System.currentTimeMillis() - time;
            // Adjust the timing correctly
            if (time < interval) {
                try {
                    Thread.sleep((long) (interval - time));
                } catch (InterruptedException ignore) {
                }
            }
        }
    }

    public boolean isKeyPressed() {
        return keyIsPressed;
    }

    public void pause() {
        paused = true;
    }

    public boolean isPaused() {return paused;}
}