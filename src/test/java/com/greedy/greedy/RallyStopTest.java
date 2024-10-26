package com.greedy.greedy;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class RallyStopTest {

    @Test
    public void testScenario1() {
        int totalDistance = 1000;
        int maxDailyDistance = 200;
        int[] stopPoints = { 150, 300, 450, 600, 750, 900 };
        List<Integer> expectedStops = List.of(150, 300, 450, 600, 750, 900);

        RallyStop rallyStop = new RallyStop(totalDistance, maxDailyDistance, stopPoints);
        List<Integer> selectedStops = rallyStop.findStops();

        assertEquals(expectedStops, selectedStops);
    }

    @Test
    public void testScenario2() {
        int totalDistance = 800;
        int maxDailyDistance = 250;
        int[] stopPoints = { 100, 200, 400, 600, 750 };
        List<Integer> expectedStops = List.of(200, 400, 600);

        RallyStop rallyStop = new RallyStop(totalDistance, maxDailyDistance, stopPoints);
        List<Integer> selectedStops = rallyStop.findStops();

        assertEquals(expectedStops, selectedStops);
    }

    @Test
    public void testScenario3() {
        int totalDistance = 1500;
        int maxDailyDistance = 300;
        int[] stopPoints = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200, 1300 };
        List<Integer> expectedStops = List.of(300, 600, 900, 1200);

        RallyStop rallyStop = new RallyStop(totalDistance, maxDailyDistance, stopPoints);
        List<Integer> selectedStops = rallyStop.findStops();

        assertEquals(expectedStops, selectedStops);
    }

    @Test
    public void testInvalidFirstStop() {
        int totalDistance = 1000;
        int maxDailyDistance = 250;
        int[] stopPoints = { 350, 500, 700 };

        RallyStop rallyStop = new RallyStop(totalDistance, maxDailyDistance, stopPoints);

        // Verifica se a IllegalArgumentException é lançada sem precisar da mensagem
        assertThrows(IllegalArgumentException.class, () -> {
            rallyStop.findStops();
        });
    }

    @Test
    public void testInvalidLastStop() {
        int totalDistance = 1000;
        int maxDailyDistance = 200;
        int[] stopPoints = { 150, 350, 550, 600 };

        RallyStop rallyStop = new RallyStop(totalDistance, maxDailyDistance, stopPoints);

        // Verifica se a IllegalArgumentException é lançada sem precisar da mensagem
        assertThrows(IllegalArgumentException.class, () -> {
            rallyStop.findStops();
        });
    }
}
