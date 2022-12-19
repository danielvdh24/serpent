package com.projectserpent.backend;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserScore implements Comparable<UserScore> {
    private final String username;
    private int score;

    public UserScore(@JsonProperty("username") String username, @JsonProperty("score")int score) {
        this.username = username;
        this.score = score;
    }


    public String getUsername() {
        return username;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(UserScore otherScore) {
        int firstValue = this.getScore();
        int otherValue = otherScore.getScore();
        if(firstValue>otherValue) {
            return -1;
        } else if(firstValue<otherValue) {
            return 1;
        }
        return 0;
    }
}
