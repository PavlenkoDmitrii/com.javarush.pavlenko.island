import entity.place.Island;

public class Application {
    public static void main(String[] args) {

        Island island = new Island(4, 4);
        island.createLocations();
        Simulation simulation = new Simulation(island);
        simulation.startSimulation();
    }
}