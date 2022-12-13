module com.example.projectserpent {
    requires javafx.controls;
    requires javafx.fxml;
    exports com.projectserpent;
    opens com.projectserpent to javafx.base, javafx.fxml;
    exports com.projectserpent.backend;
    opens com.projectserpent.backend to javafx.base;
    exports com.projectserpent.frontend;
    opens com.projectserpent.frontend to javafx.base, javafx.fxml;
    exports com.projectserpent.frontend.painter;
    opens com.projectserpent.frontend.painter to javafx.base, javafx.fxml;
    exports com.projectserpent.UtilityClasses;
    opens com.projectserpent.UtilityClasses to javafx.base, javafx.fxml;
}