package labyrinth.model;

public class App {

    public static void main(String[] args) {
        Labyrinth labyrinth = PrimAlgorythm.generateLabyrinth(10, 10);
        System.out.println(labyrinth);
    }
}
