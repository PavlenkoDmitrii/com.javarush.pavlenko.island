package entity.creatures.animal.predators;

import entity.creatures.abstracts.Predator;

import static config.Settings.*;

public class Fox extends Predator {

    public Fox() {
        super(WEIGHT_FOX, MAX_COUNT_FOX, FOX_NAME, MAX_SPEED_FOX, MAX_SATIETY_FOX);
    }
}
