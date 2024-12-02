package entity.place;

public class Island {
    private final int countOfLines;
    private final int countOfColumns;
    private final Location[][] locations;

    public Island(int countOfLines, int countOfColumns) {
        this.countOfLines = countOfLines;
        this.countOfColumns = countOfColumns;
        this.locations = new Location[countOfLines][countOfColumns];
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void createLocations() {
        for (int line = 0; line < countOfLines; line++) {
            for (int column = 0; column < countOfColumns; column++) {
                locations[line][column] = new Location(line, column);
                locations[line][column].fillLocation();
            }
        }
    }
}

