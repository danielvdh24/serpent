package com.projectserpent.backend;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LeaderboardList implements Serializable {
    private static ArrayList<UserScore> leaderboard = new ArrayList<>();
    private static ObjectMapper objectMapper = new ObjectMapper();

    // Store JSON file in the project's root directory (not inside `target`)
    private static final String filePath = "leaderboard.json";
    static File file = new File(filePath);

    public LeaderboardList() {
        if (!file.exists()) {
            try {
                file.createNewFile();
                objectMapper.writeValue(file, new ArrayList<UserScore>()); // Initialize empty JSON if missing
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addScore(UserScore userScore){
        leaderboard.add(userScore);
        Collections.sort(leaderboard);
        if(leaderboard.size() > 10) {
            leaderboard.remove(10);
        }
        saveToJson();
    }

    public void saveToJson() {
        try {
            objectMapper.writeValue(file, leaderboard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadJson() {
        try {
            if (file.exists() && file.length() > 0) {
                leaderboard = objectMapper.readValue(file, new TypeReference<ArrayList<UserScore>>() {});
            } else {
                leaderboard = new ArrayList<>();
            }
        } catch (Exception e) {
            e.printStackTrace();
            leaderboard = new ArrayList<>();
        }
    }

    public ArrayList<UserScore> getLeaderboard() {
        return leaderboard;
    }

    public void printLeaderboard() {
        for (UserScore list : getLeaderboard()) {
            System.out.println("Name: " + list.getUsername() + ". Score: " + list.getScore());
        }
    }
}
