package labyrinth.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        primAlgorythm = new PrimAlgorythm(5, 5);
        labyrinth = primAlgorythm.generateLabyrinth();
        passages = 0;
        for (int i = 0; i < labyrinth.getWidth(); i++) {
            for (int j = 0; j < labyrinth.getHeight(); j++) {
                if (labyrinth.getValue(i, j)) {
                    passages++;
                }
            }
        }
        assertTrue(passages > 1 && passages < 16);

        primAlgorythm = new PrimAlgorythm(11, 11);
        labyrinth = primAlgorythm.generateLabyrinth();
        passages = 0;
        for (int i = 0; i < labyrinth.getWidth(); i++) {
            for (int j = 0; j < labyrinth.getHeight(); j++) {
                if (labyrinth.getValue(i, j)) {
                    passages++;
                }
            }
        }
        assertTrue(passages > 1 && passages < 100);
    }
}
