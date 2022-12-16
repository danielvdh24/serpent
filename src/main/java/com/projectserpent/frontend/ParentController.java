package com.projectserpent.frontend;

import com.projectserpent.UtilityClasses.ParseAndLoadFXML;
import javafx.event.Event;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public  class ParentController {

    private static int score;
    /*
    This method is called to redirect to a different scene
     */
    protected void sceneSwitch(Event event, String fxmlName) throws IOException {
        Parent fxmlFile = ParseAndLoadFXML.returnFxmlFile(fxmlName);
        Scene scene = new Scene(fxmlFile);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void setScore(int score) {
        ParentController.score = score;
    }

    public int getScore() {
        return score;
    }


}