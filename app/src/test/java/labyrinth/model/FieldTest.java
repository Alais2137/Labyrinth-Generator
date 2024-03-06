package labyrinth.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FieldTest {

    @Test
    public void constructorTest() {
        Field field = new Field(1, 2);
        assertEquals(1, field.getX());
        assertEquals(2, field.getY());
        assertFalse(field.isPassage());
    }

    @Test
    public void settersTest() {
        Field field = new Field(1, 2);
        assertEquals(false, field.isPassage());
        field.setAsPassage();
        assertEquals(true, field.isPassage());
    }

    @Test
    public void hashCodeTest() {
        Field field1 = new Field(1, 2);
        Field field2 = new Field(1, 2);
        assertEquals(field1.hashCode(), field2.hashCode());

        Field field3 = new Field(2, 1);
        assertNotEquals(field1.hashCode(), field3.hashCode());
    }

    @Test
    public void toStringTest() {
        Field field = new Field(1, 2);
        assertEquals("▓", field.toString());
        field.setAsPassage();
        assertEquals(" ", field.toString());
    }
}
