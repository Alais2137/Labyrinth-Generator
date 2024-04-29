package labyrinth.model;

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

    public boolean isPassage(int x, int y) {
        return this.cells.get(x * this.height + y).isPassage();
    }

    protected Field getField(int x, int y) {
        return this.cells.get(x * this.height + y);
    }

    protected void setAsWall(int x, int y) {
        this.cells.get(x * this.height + y).setAsWall();
    }

    protected void setAsPassage(int x, int y) {
        this.cells.get(x * this.height + y).setAsPassage();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                sb.append(this.cells.get(i * this.height + j).toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
