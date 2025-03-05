module com.projectserpent {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;
    requires java.desktop;

    exports com.projectserpent;
    opens com.projectserpent to javafx.fxml;

    exports com.projectserpent.backend;
    opens com.projectserpent.backend to javafx.base, com.fasterxml.jackson.databind;

    exports com.projectserpent.frontend;
    opens com.projectserpent.frontend to javafx.fxml;

    exports com.projectserpent.frontend.painter;
    opens com.projectserpent.frontend.painter to javafx.fxml;

    exports com.projectserpent.UtilityClasses;
    opens com.projectserpent.UtilityClasses to javafx.fxml;
}
