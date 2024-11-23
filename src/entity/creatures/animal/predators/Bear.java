package entity.creatures.animal.predators;


import entity.creatures.abstracts.Predator;

import static config.Settings.*;

public class Bear extends Predator {

    public Bear() {
        super(WEIGHT_BEAR, MAX_COUNT_BEAR, MAX_SPEED_BEAR, MAX_SATIETY_BEAR);
    }
}
