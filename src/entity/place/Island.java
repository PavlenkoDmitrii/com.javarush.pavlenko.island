package entity.place;

import java.util.ArrayList;
import java.util.List;

public class Island {
    private int numberOfLines;
    private int numberOfColumns;
    private Location[][] location;
    private List<Location> locations;

    public Island(int numberOfLines, int numberOfColumns) {
        this.numberOfLines = numberOfLines;
        this.numberOfColumns = numberOfColumns;
        this.location = new Location[getNumberOfLines()][getNumberOfColumns()];
        this.locations = new ArrayList<>();
    }

    public Location[][] getLocation() {
        return location;
    }

    public List<Location> getLocations() {
        return locations;
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

    public void lifeOnIsland() {
        for (Location location : createLocations()) {
            Statistic statistic = new Statistic(location);
            location.fillLocation();

            statistic.getStatistic();

            location.eatOnLocation();

            statistic.getStatistic();
        }
    }
}
