package entity.creatures.animal.predators;

import entity.creatures.abstracts.Predator;

import static config.Settings.*;

public class Boa extends Predator {

    public Boa() {
        super(WEIGHT_BOA, MAX_COUNT_BOA, MAX_SPEED_BOA, MAX_SATIETY_BOA);
    }
}
