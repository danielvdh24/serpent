package com.projectserpent.backend;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserScore implements Comparable<UserScore> {
    private final SimpleStringProperty username;
    private final SimpleIntegerProperty score;

    public UserScore(SimpleStringProperty username, SimpleIntegerProperty score) {
        this.username = username;
        this.score = score;
    }

    public String getUsername() {
        return username.get();
    }

    public SimpleStringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public SimpleIntegerProperty scoreProperty() {
        return score;
    }

    public int getScore() {
        return score.get();
    }

    public void setScore(int score) {
        this.score.set(score);
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
