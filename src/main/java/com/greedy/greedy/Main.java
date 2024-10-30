package com.greedy.greedy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        String path = "Rally-GreedyExercise/src/main/java/com/greedy/greedy/entrada.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            int totalDistance = Integer.parseInt(br.readLine().trim());
            int maxDailyDistance = Integer.parseInt(br.readLine().trim());
            
            List<Integer> distancesList = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    int distance = Integer.parseInt(line);
                    distancesList.add(distance);
                }
            }
            
            br.close();

            int[] distances = distancesList.stream().mapToInt(i -> i).toArray();
            System.out.println(new RallyStop(totalDistance, maxDailyDistance, distances).findStops());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }    
}
