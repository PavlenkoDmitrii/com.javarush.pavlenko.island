package entity.place;

import entity.creatures.abstracts.Animal;
import entity.creatures.abstracts.Creature;
import factory.TypesCreatures;
import factory.TypesCreaturesFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static config.Settings.MAX_COUNT_PLANT;
import static factory.TypesCreatures.PLANT;

public class Island {
    private final int numberOfLines;
    private final int numberOfColumns;
    private final Location[][] location;
    private final List<Location> locations;
    private final TypesCreaturesFactory factory;

    public Island(int numberOfLines, int numberOfColumns) {
        this.numberOfLines = numberOfLines;
        this.numberOfColumns = numberOfColumns;
        this.location = new Location[getNumberOfLines()][getNumberOfColumns()];
        this.locations = new ArrayList<>();
        this.factory = new TypesCreaturesFactory();
    }

    public Location[][] getLocation() {
        return location;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    private List<Location> createLocations() {
        for (int line = 0; line < getNumberOfLines(); line++) {
            for (int column = 0; column < getNumberOfColumns(); column++) {
                locations.add(location[line][column] = new Location(line, column));
            }
        }
        return locations;
    }

    public List<Location> fillingLocations() {
        List<Location> locationAfterFillingList = new ArrayList<>();
        for (Location location : createLocations()) {
            fillLocation(location);
            locationAfterFillingList.add(location);
        }
        return locationAfterFillingList;
    }

    private void fillLocation(Location location) {
        List<Creature> locationAfterFilling = location.getCreaturesOnLocation();

        for (TypesCreatures type : TypesCreatures.values()) {
            int random = ThreadLocalRandom.current().nextInt(1, factory.createCreature(type).getMaxCountOnLocation());
            for (int j = 0; j < random; j++) {
                Creature creature = factory.createCreature(type);
                locationAfterFilling.add(creature);
            }
        }
        location.setCreaturesOnLocation(locationAfterFilling);
    }

    public void growOfPlantsOnLocation(Location location) {
        location.getLock().lock();
        try {
            if (location.getAllPlants().size() >= MAX_COUNT_PLANT) {
                return;
            }
            List<Creature> locationAfterFillingPlants = location.getCreaturesOnLocation();
            int random = ThreadLocalRandom.current().nextInt(0, (MAX_COUNT_PLANT - location.getAllPlants().size()) + 1);
            for (int j = 0; j < random; j++) {
                Creature creature = factory.createCreature(PLANT);
                locationAfterFillingPlants.add(creature);
            }
            location.setCreaturesOnLocation(locationAfterFillingPlants);
        } finally {
            location.getLock().unlock();
        }
    }

    public void eatOnLocation(Location location) {
        location.getLock().lock();
        try {
            List<Creature> locationAfterMeal = location.getCreaturesOnLocation();

            for (Animal animal : location.getAnimals()) {
                if (!animal.getIsDead()) {
                    for (Creature creatureOnLocation : location.getCreaturesOnLocation()) {
                        List<Creature> creaturesForEatList = new ArrayList<>();
                        if (animal.getProbabilities().containsKey(creatureOnLocation.getName()) && !creatureOnLocation.getIsDead()) {
                            creaturesForEatList.add(creatureOnLocation);
                            Creature creatureForEat = creaturesForEatList.get((int) (Math.random() * creaturesForEatList.size()));
                            animal.eat(creatureForEat);
                        }
                    }
                }
            }
            List<Creature> eatenCreatures = new ArrayList<>();
            for (Creature creature : location.getCreaturesOnLocation()) {
                if (creature.getIsDead()) {
                    eatenCreatures.add(creature);
                }
            }
            locationAfterMeal.removeAll(eatenCreatures);
            location.setCreaturesOnLocation(locationAfterMeal);
        } finally {
            location.getLock().unlock();
        }
    }

    public void reproduceOnLocation(Location location) {
        location.getLock().lock();
        try {
            List<Creature> locationAfterReproduce = location.getCreaturesOnLocation();
            List<Animal> reproducedList = new ArrayList<>();

            for (Animal animal : location.getAnimals()) {
                long numberAnimalsThisTypeOnLocation = location.getNumberAnimalsOnLocation(animal);
                long limit = animal.getMaxCountOnLocation() - location.getNumberAnimalsOnLocation(animal);
                for (Animal animalForReproduce : location.getAnimals()) {
                    if (numberAnimalsThisTypeOnLocation >= 2 && numberAnimalsThisTypeOnLocation < limit && animal != animalForReproduce) {
                        Animal child = animal.reproduce(animalForReproduce);
                        if (animal != child) {
                            reproducedList.add(child);
                        }
                    }
                }
            }
            locationAfterReproduce.addAll(reproducedList);
            location.setCreaturesOnLocation(locationAfterReproduce);
        } finally {
            location.getLock().unlock();
        }
    }

    public void starvationOnLocation(Location location) {
        location.getLock().lock();
        try {
            List<Creature> locationAfterStarvation = location.getCreaturesOnLocation();
            List<Animal> listForDead = new ArrayList<>();

            for (Animal animal : location.getAnimals()) {
                animal.starvation(animal);
                if (animal.getIsDead()) {
                    listForDead.add(animal);
                }
            }
            locationAfterStarvation.removeAll(listForDead);
            location.setCreaturesOnLocation(locationAfterStarvation);
        } finally {
            location.getLock().unlock();
        }
    }

//    private Location forwardStep(Animal animal, Location thisLocation) {
//        int thisColumn = thisLocation.getColumn();
//        int thisLine = thisLocation.getLine();
//
//        if (thisLine > 0) {
//            Location newLocation = getLocation()[thisLine - 1][thisColumn];
//            newLocation.addCreature(animal);
//            thisLocation.removeCreaturesOnIsland(animal);
//            return newLocation;
//        }
//        return thisLocation;
//    }
//
//    private Location backStep(Animal animal, Location thisLocation) {
//        int thisColumn = thisLocation.getColumn();
//        int thisLine = thisLocation.getLine();
//
//        if (thisLine < getNumberOfLines() - 1) {
//            Location newLocation = getLocation()[thisLine + 1][thisColumn];
//            newLocation.addCreature(animal);
//            thisLocation.removeCreaturesOnIsland(animal);
//            return newLocation;
//        }
//        return thisLocation;
//    }
//
//    private Location leftStep(Animal animal, Location thisLocation) {
//        int thisColumn = thisLocation.getColumn();
//        int thisLine = thisLocation.getLine();
//
//        if (thisColumn > 0) {
//            Location newLocation = getLocation()[thisLine][thisColumn - 1];
//            newLocation.addCreature(animal);
//            thisLocation.removeCreaturesOnIsland(animal);
//            return newLocation;
//        }
//        return thisLocation;
//    }
//
//    private Location rightStep(Animal animal, Location thisLocation) {
//        int thisColumn = thisLocation.getColumn();
//        int thisLine = thisLocation.getLine();
//
//        if (thisColumn < getNumberOfColumns() - 1) {
//            Location newLocation = getLocation()[thisLine][thisColumn + 1];
//            newLocation.addCreature(animal);
//            thisLocation.removeCreaturesOnIsland(animal);
//            return newLocation;
//        }
//        return thisLocation;
//    }
//
//    private void move(Animal animal, Location location) {
//        int numberSteps = ThreadLocalRandom.current().nextInt(0, animal.getMaxSpeed());
//
//        while (numberSteps > 0) {
//            DirectionOfMovement direction = DirectionOfMovement.values()[ThreadLocalRandom.current().nextInt(DirectionOfMovement.values().length)];
//            switch (direction) {
//                case FORWARD -> location = forwardStep(animal, location);
//                case BACK -> location = backStep(animal, location);
//                case LEFT -> location = leftStep(animal, location);
//                case RIGHT -> location = rightStep(animal, location);
//            }
//            numberSteps--;
//        }
//    }

    public void lifeOnIsland() {
        for (Location locationAfterFilling : fillingLocations()) {
            Statistic statistic = new Statistic(locationAfterFilling);
            statistic.getStatistic();

            eatOnLocation(locationAfterFilling);
            growOfPlantsOnLocation(locationAfterFilling);
            statistic.getStatistic();

            reproduceOnLocation(locationAfterFilling);
            statistic.getStatistic();

            starvationOnLocation(locationAfterFilling);
            statistic.getStatistic();
        }
    }
}

