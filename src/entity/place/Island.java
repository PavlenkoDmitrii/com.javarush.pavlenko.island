package entity.place;

import entity.creatures.abstracts.Animal;
import entity.creatures.abstracts.Creature;
import entity.place.movement.DirectionOfMovement;
import factory.TypesCreatures;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static factory.TypesCreaturesFactory.createCreature;

public class Island {
    private final int countOfLines;
    private final int countOfColumns;
    private final Location[][] locations;

    public Island(int countOfLines, int countOfColumns) {
        this.countOfLines = countOfLines;
        this.countOfColumns = countOfColumns;
        this.locations = new Location[countOfLines][countOfColumns];
    }

    public int getCountOfLines() {
        return countOfLines;
    }

    public int getCountOfColumns() {
        return countOfColumns;
    }

    public Location[][] getLocations() {
        return locations;
    }

    private void fillLocation(Location location) {
        List<Creature> temp = location.getCreaturesOnLocation();
        for (TypesCreatures type : TypesCreatures.values()) {
            int random = ThreadLocalRandom.current().nextInt(1, createCreature(type).getMaxCountOnLocation());
            for (int i = 0; i < random; i++) {
                Creature creature = createCreature(type);
                temp.add(creature);
            }
        }
        location.setCreaturesOnLocation(temp);
    }

    public void createLocations() {
        for (int line = 0; line < countOfLines; line++) {
            for (int column = 0; column < countOfColumns; column++) {
                locations[line][column] = new Location(line, column);
                fillLocation(locations[line][column]);
            }
        }
    }

    private Location forwardStep(Location thisLocation, Animal animal) {
        int thisLine = thisLocation.getLine();
        int thisColumn = thisLocation.getColumn();
        if (thisLine > 0) {
            Location newLocation = getLocations()[thisLine - 1][thisColumn];
            newLocation.addCreature(animal);
            thisLocation.removeCreature(animal);
            return newLocation;
        }
        return thisLocation;
    }

    private Location backStep(Location thisLocation, Animal animal) {
        int thisLine = thisLocation.getLine();
        int thisColumn = thisLocation.getColumn();
        if (thisLine < getCountOfLines() - 1) {
            Location newLocation = getLocations()[thisLine + 1][thisColumn];
            newLocation.addCreature(animal);
            thisLocation.removeCreature(animal);
            return newLocation;
        }
        return thisLocation;
    }

    private Location leftStep(Location thisLocation, Animal animal) {
        int thisLine = thisLocation.getLine();
        int thisColumn = thisLocation.getColumn();
        if (thisColumn > 0) {
            Location newLocation = getLocations()[thisLine][thisColumn - 1];
            newLocation.addCreature(animal);
            thisLocation.removeCreature(animal);
            return newLocation;
        }
        return thisLocation;
    }

    private Location rightStep(Location thisLocation, Animal animal) {
        int thisLine = thisLocation.getLine();
        int thisColumn = thisLocation.getColumn();
        if (thisColumn < getCountOfColumns() - 1) {
            Location newLocation = getLocations()[thisLine][thisColumn + 1];
            newLocation.addCreature(animal);
            thisLocation.removeCreature(animal);
            return newLocation;
        }
        return thisLocation;
    }

   private void move(Location location, Animal animal) {
        int numberSteps = animal.getMaxSpeed() - 1;
        while (numberSteps > 0) {
            DirectionOfMovement direction = DirectionOfMovement.values()[numberSteps];
            switch (direction) {
                case FORWARD -> location = forwardStep(location, animal);
                case BACK -> location = backStep(location, animal);
                case LEFT -> location = leftStep(location, animal);
                case RIGHT -> location = rightStep(location, animal);
            }
            numberSteps--;
        }
    }

    public void movingAroundLocations() {
        Location[][] locations = getLocations();
        for (Location[] line : locations) {
            for (Location location : line) {
                location.getLock().lock();
                try {
                    List<Animal> animals = location.getAnimals();
                    for (Animal animal : animals) {
                        if (location.getCountAnimalsOnLocation(animal) < animal.getMaxCountOnLocation()) {
                            move(location, animal);
                        }
                    }
                } finally {
                    location.getLock().unlock();
                }
            }
        }
    }
}


