import entity.place.Island;

import static config.Settings.*;

public class Application {
    public static void main(String[] args) throws InterruptedException {

        Island island = new Island(LINES, COLUMNS);
        island.createLocations();
        Simulation simulation = new Simulation(island);
        simulation.startSimulation();
        Thread.sleep(DAYS_BEFORE_STOPPING);
        simulation.stopSimulation();
    }
}
