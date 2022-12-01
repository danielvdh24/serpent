module com.example.serpentmain {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.serpentmain to javafx.fxml;
    exports com.example.serpentmain;
}