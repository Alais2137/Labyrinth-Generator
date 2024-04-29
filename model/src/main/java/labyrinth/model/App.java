package labyrinth.model;

public class App {

    public static void main(String[] args) {
        Algorythm generathor21x21 = new PrimAlgorythm(15, 10);
        System.out.println(generathor21x21.generateLabyrinth().toString());
    }
}
