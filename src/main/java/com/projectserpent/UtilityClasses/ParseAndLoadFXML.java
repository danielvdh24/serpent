package com.projectserpent.UtilityClasses;

import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;

import static java.util.Objects.requireNonNull;

/***
 * Utility class for loading fxml
 */
public final class ParseAndLoadFXML {
    private ParseAndLoadFXML() {
    }
    // returns loaded fxml
    public static Object returnFxmlFile(String filename) throws IOException {
        return FXMLLoader.load(getFxmlUrl(filename));
    }
    /* method uses classloader to find location of FXML urls
     */
    public static URL getFxmlUrl(String url) {
        ClassLoader fxml = ParseAndLoadFXML.class.getClassLoader();
        return fxml.getResource(url);
    }
}
