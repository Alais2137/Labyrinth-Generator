package labyrinth;

public class Field {
    private int x;
    private int y;

    private boolean isEmpty;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
        this.isEmpty = false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    protected void setAsWall() {
        this.isEmpty = false;
    }

    protected void setAsEmpty() {
        this.isEmpty = true;
    }
}
