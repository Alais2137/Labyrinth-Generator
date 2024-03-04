package labyrinth;

import java.util.ArrayList;

public class Labyrinth {
    private int width;
    private int height;

    private ArrayList<Field> cells;

    protected Labyrinth(int width, int height) {
        this.width = width;
        this.height = height;
        this.cells = new ArrayList<>(width * height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.cells.add(new Field(i, j));
            }
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
        return this.cells.get(y * this.width + x).isEmpty();
    }

    protected void setAsWall(int x, int y) {
        this.cells.get(x * this.width + y).setAsWall();
    }

    protected void setAsEmpty(int x, int y) {
        this.cells.get(x * this.width + y).setAsEmpty();
    }
}
