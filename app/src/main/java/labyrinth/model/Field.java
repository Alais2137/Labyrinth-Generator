package labyrinth.model;

import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Field {
    private int x;
    private int y;

    private boolean isPassage;

    public Field(int x, int y) {
        this.x = x;
        this.y = y;
        this.isPassage = false;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean isPassage() {
        return this.isPassage;
    }

    protected void setAsWall() {
        this.isPassage = false;
    }

    protected void setAsPassage() {
        this.isPassage = true;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(this.x + "x").
                append(this.y + "y").
                toHashCode();
    }

    @Override
    public String toString() {
        return isPassage ? " " : "▓";
    }
}
