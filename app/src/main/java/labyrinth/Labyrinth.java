package labyrinth;

import java.util.ArrayList;

public class Labyrinth {
    private int width;
    private int height;

    private ArrayList<Boolean> cells;

    public Labyrinth(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new ArrayList<>(width * height);
        for (int i = 0; i < width * height; i++) {
            this.cells.add(false);
        }
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public String getType(int x, int y) {
        return this.getValue(x, y) ? "empty" : "wall";
    }

    public boolean getValue(int x, int y) {
        return this.cells.get(y * this.width + x);
    }

    protected void setAsWall(int x, int y) {
        this.cells.set(y * this.width + x, false);
    }

    protected void setAsEmpty(int x, int y) {
        this.cells.set(y * this.width + x, true);
    }
}
