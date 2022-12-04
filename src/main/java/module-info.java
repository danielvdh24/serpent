module com.example.projectserpent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projectserpent.gui to javafx.fxml;
    exports com.example.projectserpent.gui;
}