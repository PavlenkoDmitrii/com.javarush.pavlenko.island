import entity.creatures.abstracts.Animal;
import entity.creatures.plant.Plant;
import entity.place.Island;
import entity.place.Location;

import java.util.List;

public class CreaturesWorker implements Runnable {

    private final Island island;
    private final Statistic statistic;

    public CreaturesWorker(Island island) {
        this.island = island;
        this.statistic = new Statistic();
    }

    @Override
    public void run() {
        Location[][] locations = island.getLocations();
        for (Location[] line : locations) {
            for (Location location : line) {
                try {
                    processingOnLocation(location);
                } catch (Exception e) {
                    throw new RuntimeException("Что-то пошло не так");
                }
            }
        }
        statistic.getStatistic(island);
    }

    private void processingOnLocation(Location location) {
        List<Animal> animals = location.getAnimals();
        List<Plant> plants = location.getAllPlants();
        location.getLock().lock();
        try {
            animals.forEach(animal -> animal.eatOnLocation(location));
            animals.forEach(animal -> {
                if (animal.isEat()) {
                    animal.reproduceOnLocation(location);
                }
            });
            animals.forEach(animal -> animal.starvationOnLocation(location));
            plants.forEach(plant -> plant.growOfPlantsOnLocation(location));
        } finally {
            location.getLock().unlock();
        }
    }
}
