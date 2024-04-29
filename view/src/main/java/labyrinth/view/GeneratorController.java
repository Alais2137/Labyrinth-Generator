package labyrinth.view;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
// if shows error, it lies
import labyrinth.model.Labyrinth;
import labyrinth.model.PrimAlgorythm;

public class GeneratorController {

    @FXML
    private AnchorPane labirynthPane;

    @FXML
    private Spinner<Integer> widthSpinner;

    @FXML
    private Spinner<Integer> heightSpinner;

    public void initialize() {
        widthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 100, 10));
        heightSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 100, 10));
    }

    public void generate() {
        int width = widthSpinner.getValue();
        int height = heightSpinner.getValue();
        
        resizeLabirynthPane(width, height);

        PrimAlgorythm algorythm = new PrimAlgorythm(width, height);

        Labyrinth labyrinth = algorythm.generateLabyrinth();

        drawLabyrinth(labyrinth);
    }

    private void resizeLabirynthPane(int width, int height) {
        int maxHeight = (int) Math.round(labirynthPane.getMaxHeight());
        int maxWidth = (int) Math.round(labirynthPane.getMaxWidth());

        int cellSize = Math.min(maxHeight / height, maxWidth / width);

        int paneHeight = cellSize * height;
        int paneWidth = cellSize * width;

        labirynthPane.setPrefSize(paneWidth, paneHeight);

        int translateX = (maxWidth - paneWidth) / 2;
        int translateY = (maxHeight - paneHeight) / 2;

        labirynthPane.setTranslateX(translateX);
        labirynthPane.setTranslateY(translateY);
    }

    private void drawLabyrinth(Labyrinth labyrinth) {
        labirynthPane.getChildren().clear();

        int cellSize = (int) Math.round(labirynthPane.getPrefWidth()) / labyrinth.getWidth();

        for (int y = 0; y < labyrinth.getHeight(); y++) {
            for (int x = 0; x < labyrinth.getWidth(); x++) {
                if (labyrinth.isPassage(x, y)) {
                    Rectangle wall = new Rectangle(x * cellSize, y * cellSize, cellSize, cellSize);
                    wall.setFill(Color.WHITE);
                    labirynthPane.getChildren().add(wall);
                } else {
                    Rectangle cell = new Rectangle(x * cellSize, y * cellSize, cellSize, cellSize);
                    cell.setFill(Color.BLACK);
                    labirynthPane.getChildren().add(cell);
                }
            }
        }
    }
}
