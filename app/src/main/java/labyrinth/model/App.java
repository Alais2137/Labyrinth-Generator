package labyrinth.model;

public class App {

    public static void main(String[] args) {
        Algorythm generathor = new PrimAlgorythm();
        Labyrinth labyrinth = generathor.generateLabyrinth(10, 10);
        System.out.println(labyrinth);
    }
}
