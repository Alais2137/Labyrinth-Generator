package labyrinth.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class PrimAlgorythm implements Algorythm {

    private int width;
    private int height;

    private Labyrinth labyrinth;

    // FIXME - setting the width and height has no sense
    public PrimAlgorythm(int width, int height) {
        this.width = width;
        this.height = height;

        labyrinth = new Labyrinth(width, height);
    }

    // https://stackoverflow.com/questions/29739751/implementing-a-randomly-generated-maze-using-prims-algorithm
    @Override
    public Labyrinth generateLabyrinth() {

        // TODO - change to pairs of wall and neighbour
        HashSet<Field> frontierSet = new HashSet<>();
        ArrayList<Field> visitedList = new ArrayList<>();
        
        Random random = new Random();

        // Choose random starting point
        int x = random.nextInt(width);
        int y = random.nextInt(height);

        labyrinth.setAsPassage(x, y);
        frontierSet.addAll(addFrontiers(x, y));

        // While 
        while (!frontierSet.isEmpty()) {
            Field frontier = getRandomFromSet(frontierSet);
            int fx = frontier.getX();
            int fy = frontier.getY();

            if (!frontier.isPassage()) {
                HashSet<Field> neighbours = addNeighbours(fx, fy);

                if (!neighbours.isEmpty()) {
                    Field randomNeighbour = getRandomFromSet(neighbours);
                    int nx = randomNeighbour.getX();
                    int ny = randomNeighbour.getY();

                    labyrinth.setAsPassage((nx + fx)/2, (ny + fy)/2);
                    labyrinth.setAsPassage(fx, fy);

                    frontierSet.addAll(addFrontiers(fx, fy));
                }
            }

            frontierSet.remove(frontier);

            visitedList.add(frontier);
            if (visitedList.size() > 100) {
                System.out.println("BREAK " + x + " " + y); // FIXME - it generates chessboard
                break;
            }
            System.out.println(visitedList.size() + " " + fx + " " + fy);
            System.out.println(labyrinth.toString());
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

    private HashSet<Field> addFrontiers(int x, int y) {
        HashSet<Field> frontiers = new HashSet<>();

        if (x > 1 && !labyrinth.getField(x - 2, y).isPassage()) {
            frontiers.add(labyrinth.getField(x - 2, y));
        }
        if (x < width - 2 && !labyrinth.getField(x + 2, y).isPassage()) {
            frontiers.add(labyrinth.getField(x + 2, y));
        }
        if (y > 1 && !labyrinth.getField(x, y - 2).isPassage()) {
            frontiers.add(labyrinth.getField(x, y - 2));
        }
        if (y < height - 2 && !labyrinth.getField(x, y + 2).isPassage()) {
            frontiers.add(labyrinth.getField(x, y + 2));
        }

        return frontiers;
    }

    private HashSet<Field> addNeighbours(int x, int y) {
        HashSet<Field> neighbours = new HashSet<>();

        if (x > 1 && labyrinth.getField(x - 2, y).isPassage()) {
            neighbours.add(labyrinth.getField(x - 2, y));
        }
        if (x < width - 2 && labyrinth.getField(x + 2, y).isPassage()) {
            neighbours.add(labyrinth.getField(x + 2, y));
        }
        if (y > 1 && labyrinth.getField(x, y - 2).isPassage()) {
            neighbours.add(labyrinth.getField(x, y - 2));
        }
        if (y < height - 2 && labyrinth.getField(x, y + 2).isPassage()) {
            neighbours.add(labyrinth.getField(x, y + 2));
        }

        return neighbours;
    }
}
