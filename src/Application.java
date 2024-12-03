import entity.place.Island;

import static config.Settings.*;

public class Application {
    public static void main(String[] args) {
        Island island = new Island(LINES, COLUMNS);
        island.createLocations();
        Simulation simulation = new Simulation(island);
        simulation.startSimulation();
    }
}