package labyrinth.model;

import java.util.ArrayList;
import java.util.Random;

public class PrimAlgorythm {

    public static Labyrinth generateLabyrinth(int width, int height) {
        Labyrinth labyrinth = new Labyrinth(width, height);

        // FIXME - Walllist is wrong, it should be a list of walls, not a list of fields
        ArrayList<Field> wallList = new ArrayList<>();
        ArrayList<Field> visitedList = new ArrayList<>();
        
        Random random = new Random();

        // Choose random starting point
        int x = random.nextInt(width);
        int y = random.nextInt(height);

        labyrinth.setAsPassage(x, y);
        visitedList.add(labyrinth.getField(x, y));
        
        if (x > 0) {
            wallList.add(labyrinth.getField(x - 1, y));
        }
        if (x < width - 1) {
            wallList.add(labyrinth.getField(x + 1, y));
        }
        if (y > 0) {
            wallList.add(labyrinth.getField(x, y - 1));
        }
        if (y < height - 1) {
            wallList.add(labyrinth.getField(x, y + 1));
        }

            // Start with a grid full of walls.
            // Pick a cell, mark it as part of the maze. Add the walls of the cell to the wall list.
            // While there are walls in the list:
            // Pick a random wall from the list. If only one of the cells that the wall divides is visited, then:
            // Make the wall a passage and mark the unvisited cell as part of the maze.
            // Add the neighboring walls of the cell to the wall list.
            // Remove the wall from the list.

        // FIXME - You idiot, If only one of the cells that the W A L L divides is visited

        // While there are walls in the list
        while (!wallList.isEmpty()) {
            Field wall = wallList.get(random.nextInt(wallList.size()));

            // Count the number of visited neighbours
            int visitedNeighbours = 0;
            if (wall.getX() > 0 && visitedList.contains(labyrinth.getField(wall.getX() - 1, wall.getY()))) {
                visitedNeighbours++;
            }
            if (wall.getX() < width - 1 && visitedList.contains(labyrinth.getField(wall.getX() + 1, wall.getY()))) {
                visitedNeighbours++;
            }
            if (wall.getY() > 0 && visitedList.contains(labyrinth.getField(wall.getX(), wall.getY() - 1))) {
                visitedNeighbours++;
            }
            if (wall.getY() < height - 1 && visitedList.contains(labyrinth.getField(wall.getX(), wall.getY() + 1))) {
                visitedNeighbours++;
            }

            // If the wall has only one visited neighbour, set it as passage
            // and add its neighbours to the wall list
            if (visitedNeighbours == 1) {
                labyrinth.setAsPassage(wall.getX(), wall.getY());

                if (wall.getX() > 0 && !visitedList.contains(labyrinth.getField(wall.getX() - 1, wall.getY()))) {
                    wallList.add(labyrinth.getField(wall.getX() - 1, wall.getY()));
                }
                if (wall.getX() < width - 1 && !visitedList.contains(labyrinth.getField(wall.getX() + 1, wall.getY()))) {
                    wallList.add(labyrinth.getField(wall.getX() + 1, wall.getY()));
                }
                if (wall.getY() > 0 && !visitedList.contains(labyrinth.getField(wall.getX(), wall.getY() - 1))) {
                    wallList.add(labyrinth.getField(wall.getX(), wall.getY() - 1));
                }
                if (wall.getY() < height - 1 && !visitedList.contains(labyrinth.getField(wall.getX(), wall.getY() + 1))) {
                    wallList.add(labyrinth.getField(wall.getX(), wall.getY() + 1));
                }
            }
            
            // Remove the wall from the list and add it to the visited list
            visitedList.add(labyrinth.getField(wall.getX(), wall.getY()));
            wallList.remove(wall);
        }

        // Return the generated labyrinth
        return labyrinth;
    }
}
