package labyrinth.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LabyrinthTest {

    @Test
    public void constructorTest() {
        Labyrinth labyrinth = new Labyrinth(3, 4);
        assertEquals(3, labyrinth.getWidth());
        assertEquals(4, labyrinth.getHeight());
        assertEquals(false, labyrinth.isPassage(1, 1));
    }

    @Test
    public void settersTest() {
        Labyrinth labyrinth = new Labyrinth(3, 4);
        assertEquals(false, labyrinth.isPassage(1, 1));

        labyrinth.setAsPassage(1, 1);
        assertEquals(true, labyrinth.isPassage(1, 1));
        
        labyrinth.setAsWall(1, 1);
        assertEquals(false, labyrinth.isPassage(1, 1));
    }

    @Test
    public void getFieldTest() {
        Labyrinth labyrinth = new Labyrinth(3, 4);

        labyrinth.setAsPassage(1, 1);
        Field field = labyrinth.getField(1, 1);
        assertEquals(true, field.isPassage());

        labyrinth.setAsWall(1, 1);
        assertEquals(false, field.isPassage());
    }

    @Test
    public void toStringTest() {
        Labyrinth labyrinth = new Labyrinth(3, 3);
        labyrinth.setAsPassage(1, 1);

        String expected = "###\n# #\n###\n";

        assertEquals(expected, labyrinth.toString());
    }
}
