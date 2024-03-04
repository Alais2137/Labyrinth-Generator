package labyrinth;

import java.util.Random;

public class PrimAlgorythm {

    public static Labyrinth generateLabyrinth(int width, int height) {
        Labyrinth labyrinth = new Labyrinth(width, height);
        
        Random random = new Random();

        // Random starting point
        int x = random.nextInt(width);
        int y = random.nextInt(height);

        labyrinth.setAsEmpty(x, y);

        // TODO Implement the Prim algorithm

        // Return the generated labyrinth
        return labyrinth;
    }
}
