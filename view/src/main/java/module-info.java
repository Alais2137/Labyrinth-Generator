module labyrinth.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    // INFO - if imports show "not accessible" error, it most probably lies
    requires transitive labyrinth.model;
    
    opens labyrinth.view to javafx.fxml;
    exports labyrinth.view;
}
