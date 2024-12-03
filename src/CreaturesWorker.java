import entity.creatures.abstracts.Animal;
import entity.creatures.plant.Plant;
import entity.place.Island;
import entity.place.Location;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CreaturesWorker implements Runnable {

    private final Island island;
    private static final AtomicInteger daysCounter = new AtomicInteger(1);

    public CreaturesWorker(Island island) {
        this.island = island;
    }


    @Override
    public void run() {
        Location[][] locations = island.getLocations();
        for (Location[] line : locations) {
            for (Location location : line) {
                CountDownLatch latch = new CountDownLatch(1); //1 - одна локация
                try {
                    processingOnLocation(location); //выполнить все действия на локации
                    island.movingAroundLocations(); // переместиться
                } catch (Exception e) {
                    throw new RuntimeException("Что-то пошло не так");
                } finally {
                    latch.countDown();
                }
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("INTERRUPTED");
                }
            }
        }
        System.out.println("День: " + daysCounter.getAndIncrement());
        Statistic.getStatistic(island);
        System.out.println();
    }

    private void processingOnLocation(Location location) {
        List<Animal> animals = location.getAnimals();
        List<Plant> plants = location.getAllPlants();
        location.getLock().lock(); //блокировка локации
        try {
            animals.forEach(animal -> animal.eatOnLocation(location)); //поесть на локации
            animals.forEach(animal -> {
                if (animal.isEat()) { //если поел
                    animal.reproduceOnLocation(location); //размножиться
                }
            });
            animals.forEach(animal -> animal.starvationOnLocation(location)); //проголодаться
            plants.forEach(plant -> plant.growOfPlantsOnLocation(location)); // рост травы на локации
        } finally {
            location.getLock().unlock(); //разблокировка локации
        }
    }
}
