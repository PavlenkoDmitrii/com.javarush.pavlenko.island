package entity.creatures.animal.predators;

import entity.creatures.abstracts.Predator;

import static config.Settings.*;

public class Eagle extends Predator {

    public Eagle() {
        super(WEIGHT_EAGLE, MAX_COUNT_EAGLE, EAGLE_NAME, MAX_SPEED_EAGLE, MAX_SATIETY_EAGLE);

    }
}
