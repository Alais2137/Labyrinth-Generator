package labyrinth.model;

public class App {

    public static void main(String[] args) {
        Algorythm generathor10x10 = new PrimAlgorythm(10, 10);
        Labyrinth labyrinth = generathor10x10.generateLabyrinth();
        System.out.println(labyrinth);
    }
}
