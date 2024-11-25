package entity.creatures.animal.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Horse extends Herbivore {

    public Horse() {
        super(WEIGHT_HORSE, MAX_COUNT_HORSE, HORSE_NAME, MAX_SPEED_HORSE, MAX_SATIETY_HORSE);
    }
}
