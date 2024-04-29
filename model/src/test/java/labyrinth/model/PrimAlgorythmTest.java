package labyrinth.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimAlgorythmTest {

    @Test
    public void labyrinthSizeTest() {
        PrimAlgorythm primAlgorythm = new PrimAlgorythm(3, 3);
        Labyrinth labyrinth = primAlgorythm.generateLabyrinth();
        assertEquals(3 * 2 + 1, labyrinth.getWidth());
        assertEquals(3 * 2 + 1, labyrinth.getHeight());
    }

    @Test
    public void labyrinthPassageTest() {
        PrimAlgorythm primAlgorythm = new PrimAlgorythm(1, 1);
        Labyrinth labyrinth = primAlgorythm.generateLabyrinth();
        int passages = 0;
        for (int i = 0; i < labyrinth.getWidth(); i++) {
            for (int j = 0; j < labyrinth.getHeight(); j++) {
                if (labyrinth.isPassage(i, j)) {
                    passages++;
                }
            }
        }
        assertEquals(1, passages);

        primAlgorythm = new PrimAlgorythm(3, 3);
        labyrinth = primAlgorythm.generateLabyrinth();
        passages = 0;
        for (int i = 0; i < labyrinth.getWidth(); i++) {
            for (int j = 0; j < labyrinth.getHeight(); j++) {
                if (labyrinth.isPassage(i, j)) {
                    passages++;
                }
            }
        }
        assertTrue(passages > 1 && passages < 25);

        primAlgorythm = new PrimAlgorythm(10, 10);
        labyrinth = primAlgorythm.generateLabyrinth();
        passages = 0;
        for (int i = 0; i < labyrinth.getWidth(); i++) {
            for (int j = 0; j < labyrinth.getHeight(); j++) {
                if (labyrinth.isPassage(i, j)) {
                    passages++;
                }
            }
        }
        assertTrue(passages > 1 && passages < 361);
    }
}
