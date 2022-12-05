module com.projectserpent {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.projectserpent.frontend to javafx.fxml;
    exports com.projectserpent.frontend;
}