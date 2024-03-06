package labyrinth.model;

import java.util.HashSet;
import java.util.Random;

public class PrimAlgorythm implements Algorythm {

    private int width;
    private int height;

    private Labyrinth labyrinth;

    {        
        labyrinth = new Labyrinth(width, height);
    }

    public PrimAlgorythm(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // https://stackoverflow.com/questions/29739751/implementing-a-randomly-generated-maze-using-prims-algorithm
    @Override
    public Labyrinth generateLabyrinth(int width, int height) {

        HashSet<Field> frontierSet = new HashSet<>();
        HashSet<Field> visitedSet = new HashSet<>();
        
        Random random = new Random();

        // Choose random starting point
        int x = random.nextInt(width);
        int y = random.nextInt(height);

        labyrinth.setAsPassage(x, y);

        // Add the starting point's frontiers to the frontier list
        frontierSet.addAll(addFirstFrontiers(x, y));

        // While 
        while (!frontierSet.isEmpty()) {
            Field frontier = getRandomFromSet(frontierSet);
            int fx = frontier.getX();
            int fy = frontier.getY();

            HashSet<Field> neighbours = addNeighbours(fx, fy, visitedSet);

            if (!neighbours.isEmpty()) {
                Field randomNeighbour = getRandomFromSet(neighbours);
                int nx = randomNeighbour.getX();
                int ny = randomNeighbour.getY();

                labyrinth.setAsPassage((nx + fx)/2, (ny + fy)/2);

                frontierSet.addAll(addFrontiers(nx, ny));
            }
            
            visitedSet.add(frontier);
            frontierSet.remove(frontier);
        }

            // TODO - Finish Prim's algorithm

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

    private HashSet<Field> addFirstFrontiers(int x, int y) {
        HashSet<Field> frontiers = new HashSet<>();

        if (x > 1) {
            frontiers.add(labyrinth.getField(x - 2, y));
        }
        if (x < width - 2) {
            frontiers.add(labyrinth.getField(x + 2, y));
        }
        if (y > 1) {
            frontiers.add(labyrinth.getField(x, y - 2));
        }
        if (y < height - 2) {
            frontiers.add(labyrinth.getField(x, y + 2));
        }

        return frontiers;
    }

    private HashSet<Field> addFrontiers(int x, int y) {
        HashSet<Field> frontiers = new HashSet<>();

        if (x > 1) {
            if (!labyrinth.getField(x - 2, y).isPassage()) {
                frontiers.add(labyrinth.getField(x - 2, y));
            }
        }
        if (x < width - 2) {
            if (!labyrinth.getField(x + 2, y).isPassage()) {
                frontiers.add(labyrinth.getField(x + 2, y));
            }
        }
        if (y > 1) {
            if (!labyrinth.getField(x, y - 2).isPassage()) {
                frontiers.add(labyrinth.getField(x, y - 2));
            }
        }
        if (y < height - 2) {
            if (!labyrinth.getField(x, y + 2).isPassage()) {
                frontiers.add(labyrinth.getField(x, y + 2));
            }
        }

        return frontiers;
    }

    private HashSet<Field> addNeighbours(int x, int y, HashSet<Field> visitedSet) {
        HashSet<Field> neighbours = new HashSet<>();

        if (x > 1) {
            if (labyrinth.getField(x - 2, y).isPassage() && !visitedSet.contains(labyrinth.getField(x - 2, y))) {
                neighbours.add(labyrinth.getField(x - 2, y));
            }
        }
        if (x < width - 2) {
            if (labyrinth.getField(x + 2, y).isPassage() && !visitedSet.contains(labyrinth.getField(x + 2, y))) {
                neighbours.add(labyrinth.getField(x + 2, y));
            }
        }
        if (y > 1) {
            if (labyrinth.getField(x, y - 2).isPassage() && !visitedSet.contains(labyrinth.getField(x, y - 2))) {
                neighbours.add(labyrinth.getField(x, y - 2));
            }
        }
        if (y < height - 2) {
            if (labyrinth.getField(x, y + 2).isPassage() && !visitedSet.contains(labyrinth.getField(x, y + 2))) {
                neighbours.add(labyrinth.getField(x, y + 2));
            }
        }

        return neighbours;
    }
}
