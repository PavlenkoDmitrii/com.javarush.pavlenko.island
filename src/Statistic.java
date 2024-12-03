import entity.creatures.abstracts.Herbivore;
import entity.creatures.abstracts.Predator;
import entity.place.Island;
import entity.place.Location;

public class Statistic {

    public static void getStatistic(Island island) {
        int predators = getCountOfPredators(island);
        int herbivores = getCountOfHerbivores(island);
        int plants = getCountOfPlants(island);

        System.out.println("На острове: \n\tхищников: " + predators +
                "\n\tтравоядных: " + herbivores +
                "\n\tрастений: " + plants +
                "\nпоток: " + Thread.currentThread().getName());
    }

    public static int getCountOfPredators(Island island) {
        int predatorsSize;
        int sumPredatorsSize = 0;
        for (Location[] lines : island.getLocations()) {
            for (Location location : lines) {
                predatorsSize = location.getAnimals().stream()
                        .filter(predator -> predator instanceof Predator)
                        .toList().size();
                sumPredatorsSize += predatorsSize;
            }
        }
        return sumPredatorsSize;
    }

    public static int getCountOfHerbivores(Island island) {
        int herbivoresSize;
        int sumHerbivoresSize = 0;
        for (Location[] lines : island.getLocations()) {
            for (Location location : lines) {
                herbivoresSize = location.getAnimals().stream()
                        .filter(herbivore -> herbivore instanceof Herbivore)
                        .toList().size();
                sumHerbivoresSize += herbivoresSize;
            }
        }
        return sumHerbivoresSize;
    }

    public static int getCountOfPlants(Island island) {
        int plantsSize;
        int sumPlantsSize = 0;
        for (Location[] lines : island.getLocations()) {
            for (Location location : lines) {
                plantsSize = location.getAllPlants().size();
                sumPlantsSize += plantsSize;
            }
        }
        return sumPlantsSize;
    }
}

