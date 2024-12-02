import entity.place.Island;

public class Application {
    public static void main(String[] args) {

        Island island = new Island(3, 3);
        island.createLocations();
        Simulation simulation = new Simulation(island);
        simulation.startSimulation();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        simulation.stopSimulation();
    }
}