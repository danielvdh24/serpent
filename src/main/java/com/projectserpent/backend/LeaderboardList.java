package com.projectserpent.backend;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderboardList {
    private ArrayList<UserScore> leaderboard = new ArrayList<UserScore>();

    public void addScore(UserScore userScore){
        leaderboard.add(userScore);
        Collections.sort(leaderboard);
        if(leaderboard.size()>10) {
            leaderboard.remove(10);
        }
    }

    public ArrayList<UserScore> getLeaderboard(){
        return leaderboard;
    }
    public void printLeaderboard() {
        for (UserScore list : getLeaderboard()) {
            System.out.println("Name: " + list.getUsername() + ". Score: " + list.getScore());
        }
    }


}
