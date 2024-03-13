module labyrinth.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    requires transitive labyrinth.model;
    
    opens labyrinth.view to javafx.fxml;
    exports labyrinth.view;
}
