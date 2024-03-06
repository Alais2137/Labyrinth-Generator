package labyrinth.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrimAlgorythmTest {

    @Test
    public void labyrinthSizeTest() {
        PrimAlgorythm primAlgorythm = new PrimAlgorythm(3, 3);
        Labyrinth labyrinth = primAlgorythm.generateLabyrinth();
        assertEquals(3, labyrinth.getWidth());
        assertEquals(3, labyrinth.getHeight());
    }

    @Test
    public void labyrinthPassageTest() {
        PrimAlgorythm primAlgorythm = new PrimAlgorythm(3, 3);
        Labyrinth labyrinth = primAlgorythm.generateLabyrinth();
        int passages = 0;
        for (int i = 0; i < labyrinth.getWidth(); i++) {
            for (int j = 0; j < labyrinth.getHeight(); j++) {
                if (labyrinth.getValue(i, j)) {
                    passages++;
                }
            }
        }
        assertEquals(1, passages);
    }
}
