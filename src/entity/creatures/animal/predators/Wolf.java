package entity.creatures.animal.predators;

import entity.creatures.abstracts.Predator;

import static config.Settings.*;

public class Wolf extends Predator {

    public Wolf() {
        super(WEIGHT_WOLF, MAX_COUNT_WOLF, WOLF_NAME, MAX_SPEED_WOLF, MAX_SATIETY_WOLF);
    }
}
