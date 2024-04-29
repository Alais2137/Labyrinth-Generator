package labyrinth.model;

import java.util.HashSet;
import java.util.Random;

public class PrimAlgorythm implements Algorythm {

    private int width;
    private int height;

    private Labyrinth labyrinth;

    public PrimAlgorythm(int width, int height) {
        this.width = width * 2 + 1;
        this.height = height * 2 + 1;
    }

    // Algorythm based on https://stackoverflow.com/questions/29739751/implementing-a-randomly-generated-maze-using-prims-algorithm
    @Override
    public Labyrinth generateLabyrinth() {
        labyrinth = new Labyrinth(width, height);

        // Frontier set is a set of fields that are walls and are 2 fields away from a passage
        HashSet<Field> frontierSet = new HashSet<>();
        
        Random random = new Random();

        // Choose random starting point, that is odd and not on the edge
        int x = 0;
        int y = 0;

        while (x % 2 == 0) {
            x = random.nextInt(width - 2) + 1;
        }
        while (y % 2 == 0) {
            y = random.nextInt(height - 2) + 1;
        }

        // Set the starting point as passage and add its frontiers to the set
        labyrinth.setAsPassage(x, y);
        frontierSet.addAll(findFrontiers(x, y));

        // While there are frontiers to process
        while (!frontierSet.isEmpty()) {

            // Choose random frontier from the set
            Field frontier = getRandomFromSet(frontierSet);
            int fx = frontier.getX();
            int fy = frontier.getY();

            // If the frontier is a wall
            if (!frontier.isPassage()) {
                HashSet<Field> neighbours = findNeighbours(fx, fy);

                // If the frontier has a neighbour that is a wall
                if (!neighbours.isEmpty()) {
                    // Choose random neighbour from the set
                    Field randomNeighbour = getRandomFromSet(neighbours);
                    int nx = randomNeighbour.getX();
                    int ny = randomNeighbour.getY();

                    // Set the frontier and the cell between the frontier and the neighbour as passage
                    labyrinth.setAsPassage((nx + fx)/2, (ny + fy)/2);
                    labyrinth.setAsPassage(fx, fy);

                    // Add the frontiers of the old frontier to the set
                    frontierSet.addAll(findFrontiers(fx, fy));
                }
            }

            // Remove the processed frontier from the set
            frontierSet.remove(frontier);
        }

        // Return the generated labyrinth
        return labyrinth;
    }

    private Field getRandomFromSet(HashSet<Field> set) {
        Random random = new Random();
        int index = random.nextInt(set.size());
        int i = 0;
        for (Field field : set) {
            if (i == index) {
                return field;
            }
            i++;
        }
        return null;
    }

    private HashSet<Field> findFrontiers(int x, int y) {
        HashSet<Field> frontiers = new HashSet<>();

        // If the field is not on the edge and is a wall, add it to the set
        if (x > 2 && !labyrinth.isPassage(x - 2, y)) {
            frontiers.add(labyrinth.getField(x - 2, y));
        }
        if (x < width - 3 && !labyrinth.isPassage(x + 2, y)) {
            frontiers.add(labyrinth.getField(x + 2, y));
        }
        if (y > 2 && !labyrinth.isPassage(x, y - 2)) {
            frontiers.add(labyrinth.getField(x, y - 2));
        }
        if (y < height - 3 && !labyrinth.isPassage(x, y + 2)) {
            frontiers.add(labyrinth.getField(x, y + 2));
        }

        return frontiers;
    }

    private HashSet<Field> findNeighbours(int x, int y) {
        HashSet<Field> neighbours = new HashSet<>();

        // If the field is not on the edge and is a passage, add it to the set
        if (x > 2 && labyrinth.isPassage(x - 2, y)) {
            neighbours.add(labyrinth.getField(x - 2, y));
        }
        if (x < width - 3 && labyrinth.isPassage(x + 2, y)) {
            neighbours.add(labyrinth.getField(x + 2, y));
        }
        if (y > 2 && labyrinth.isPassage(x, y - 2)) {
            neighbours.add(labyrinth.getField(x, y - 2));
        }
        if (y < height - 3 && labyrinth.isPassage(x, y + 2)) {
            neighbours.add(labyrinth.getField(x, y + 2));
        }

        return neighbours;
    }
}
