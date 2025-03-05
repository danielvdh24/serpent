package com.projectserpent.UtilityClasses;

import javafx.fxml.FXMLLoader;
import java.io.IOException;
import java.net.URL;

public final class ParseAndLoadFXML {
    private ParseAndLoadFXML() {}

    public static Object returnFxmlFile(String filename) throws IOException {
        URL resource = ParseAndLoadFXML.class.getResource("/" + filename);
        if (resource == null) {
            throw new IOException("Cannot find FXML file: " + filename);
        }
        return FXMLLoader.load(resource);
    }
}