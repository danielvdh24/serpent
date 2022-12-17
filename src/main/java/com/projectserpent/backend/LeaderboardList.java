package com.projectserpent.backend;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LeaderboardList implements Serializable {
    private ArrayList<UserScore> leaderboard = new ArrayList<UserScore>();
    private ObjectMapper objectMapper = new ObjectMapper();

    private static String filePath = "src/main/resources/leaderboard.json";
    File file = new File(filePath);


    public void addScore(UserScore userScore){
        leaderboard.add(userScore);
        Collections.sort(leaderboard);
        if(leaderboard.size()>10) {
            leaderboard.remove(10);
        }
        saveToJson();
    }

    public void saveToJson(){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, leaderboard);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void openJson(){
        try{
            leaderboard = objectMapper.readValue(file, ArrayList.class);
            //parse File
            //load the leaderboards with data
            //parser
            //leaderboard.add(oldUserScore);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public File openFile(){
        try {
            File file = new File(String.valueOf(new FileReader("src/main/resources/leaderboard.json")));
            return file;
        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
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
