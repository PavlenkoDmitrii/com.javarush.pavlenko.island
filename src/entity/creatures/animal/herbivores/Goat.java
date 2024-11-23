package entity.creatures.animal.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Goat extends Herbivore {
    public Goat() {
        super(WEIGHT_GOAT, MAX_COUNT_GOAT, MAX_SPEED_GOAT, MAX_SATIETY_GOAT);
    }
}
