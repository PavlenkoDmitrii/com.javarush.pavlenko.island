package entity.place;

import entity.creatures.abstracts.Animal;
import entity.creatures.abstracts.movement.DirectionOfMovement;
import entity.creatures.plant.Plant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Island {
    private final int numberOfLines;
    private final int numberOfColumns;
    private final Location[][] location;
    private final List<Location> locations;

    public Island(int numberOfLines, int numberOfColumns) {
        this.numberOfLines = numberOfLines;
        this.numberOfColumns = numberOfColumns;
        this.location = new Location[getNumberOfLines()][getNumberOfColumns()];
        this.locations = new ArrayList<>();
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

    private void move(Animal animal, Location location) {
        int numberSteps = ThreadLocalRandom.current().nextInt(0, animal.getMaxSpeed());

        while (numberSteps > 0) {
            DirectionOfMovement direction = DirectionOfMovement.values()[ThreadLocalRandom.current().nextInt(DirectionOfMovement.values().length)];
            switch (direction) {
                case FORWARD -> location = forwardStep(animal, location);
                case BACK -> location = backStep(animal, location);
                case LEFT -> location = leftStep(animal, location);
                case RIGHT -> location = rightStep(animal, location);
            }
            numberSteps--;
        }
    }

    private Location forwardStep(Animal animal, Location thisLocation) {
        int thisColumn = thisLocation.getColumn();
        int thisLine = thisLocation.getLine();
        if (thisLine > 0) {
            Location newLocation = getLocation()[thisLine - 1][thisColumn];
            newLocation.addCreature(animal);
            thisLocation.removeCreaturesOnIsland(animal);
            return newLocation;
        }
        return thisLocation;
    }

    private Location backStep(Animal animal, Location thisLocation) {
        int thisColumn = thisLocation.getColumn();
        int thisLine = thisLocation.getLine();
        if (thisLine < getNumberOfLines() - 1) {
            Location newLocation = getLocation()[thisLine + 1][thisColumn];
            newLocation.addCreature(animal);
            thisLocation.removeCreaturesOnIsland(animal);
            return newLocation;
        }
        return thisLocation;
    }

    private Location leftStep(Animal animal, Location thisLocation) {
        int thisColumn = thisLocation.getColumn();
        int thisLine = thisLocation.getLine();
        if (thisColumn > 0) {
            Location newLocation = getLocation()[thisLine][thisColumn - 1];
            newLocation.addCreature(animal);
            thisLocation.removeCreaturesOnIsland(animal);
            return newLocation;
        }
        return thisLocation;
    }

    private Location rightStep(Animal animal, Location thisLocation) {
        int thisColumn = thisLocation.getColumn();
        int thisLine = thisLocation.getLine();
        if (thisColumn < getNumberOfColumns() - 1) {
            Location newLocation = getLocation()[thisLine][thisColumn + 1];
            newLocation.addCreature(animal);
            thisLocation.removeCreaturesOnIsland(animal);
            return newLocation;
        }
        return thisLocation;
    }


    public void lifeOnIsland() { //сюда передавать локацию, сделать отдельный метод для перебора всех локаций
        for (Location location : createLocations()) {
            Statistic statistic = new Statistic(location);
            location.fillLocation();// сделать, чтобы вызывалось один раз через сеттер?
            statistic.getStatistic();

            location.eatOnLocation();
            statistic.getStatistic();

            location.reproduceOnLocation();
            statistic.getStatistic();

            location.growOfPlants();
            statistic.getStatistic();
        }
    }
}
