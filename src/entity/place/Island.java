package entity.place;

import entity.creatures.abstracts.Creature;
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


}


