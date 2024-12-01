import entity.creatures.abstracts.Herbivore;
import entity.creatures.abstracts.Predator;
import entity.place.Island;
import entity.place.Location;

public class Statistic {

    public Statistic() {
    }

    public void getStatistic(Island island) {
        int predatorsSize;
        int herbivoresSize;
        int plantsSize;
        int sumPredatorsSize = 0;
        int sumHerbivoresSize = 0;
        int sumPlantsSize = 0;
        for (Location[] lines : island.getLocations()) {
            for (Location location : lines) {
                predatorsSize = location.getAnimals().stream()
                        .filter(predator -> predator instanceof Predator)
                        .toList().size();
                herbivoresSize = location.getAnimals().stream()
                        .filter(herbivore -> herbivore instanceof Herbivore)
                        .toList().size();
                plantsSize = location.getAllPlants().size();
                sumPredatorsSize += predatorsSize;
                sumHerbivoresSize += herbivoresSize;
                sumPlantsSize += plantsSize;
            }
        }
        System.out.println("На острове: \n\tхищников: " + sumPredatorsSize +
                "\n\tтравоядных: " + sumHerbivoresSize +
                "\n\tрастений: " + sumPlantsSize +
                "\nпоток: " + Thread.currentThread().getName());
    }
}
