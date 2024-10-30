package com.greedy.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RallyStop {
    private final int totalDistance;
    private final int maxDailyDistance;
    private final int[] stopPoints;

    public RallyStop(int totalDistance, int maxDailyDistance, int[] stopPoints) {
        this.totalDistance = totalDistance;
        this.maxDailyDistance = maxDailyDistance;
        this.stopPoints = stopPoints;
    }

    public List<Integer> findStops() {
        Arrays.sort(stopPoints);
        List<Integer> selectedStops = new ArrayList<>();
        int currentLocation = 0;

        if (stopPoints.length == 0 || stopPoints[0] > maxDailyDistance) {
            throw new IllegalArgumentException("Erro: O primeiro ponto de parada está muito distante do início.");
        }

        if (stopPoints[stopPoints.length - 1] > totalDistance) {
            throw new IllegalArgumentException(
                    "Erro: O último ponto de parada está muito distante da linha de chegada.");
        }

        if (stopPoints[stopPoints.length - 1] + maxDailyDistance < totalDistance) {
            throw new IllegalArgumentException(
                    "Erro: O último ponto de parada está muito distante da linha de chegada.");
        }

        for (int i = 0; i < stopPoints.length; i++) {
            if (i > 0 && stopPoints[i] - stopPoints[i - 1] > maxDailyDistance) {
                throw new IllegalArgumentException("Erro: A distância entre as paradas " + stopPoints[i - 1] + " e "
                        + stopPoints[i] + " excede o limite de " + maxDailyDistance + " km.");
            }

            // se o proximo ponto de parada estiver muito longe, para no anterior
            if (stopPoints[i] - currentLocation > maxDailyDistance) {
                selectedStops.add(stopPoints[i - 1]);
                currentLocation = stopPoints[i - 1];
            }

            // se o proximo ponto de parada for a chegada, encerra
            // ps: a linha de chegada não é considerada um ponto de parada
            if (currentLocation + maxDailyDistance >= totalDistance) {
                break;
            }
        }

        if (totalDistance - currentLocation > maxDailyDistance) {
            selectedStops.add(stopPoints[stopPoints.length - 1]);
        }

        return selectedStops;
    }
}
