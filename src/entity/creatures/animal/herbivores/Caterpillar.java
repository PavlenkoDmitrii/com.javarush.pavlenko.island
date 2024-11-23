package entity.creatures.animal.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Caterpillar extends Herbivore {
    public Caterpillar() {
        super(WEIGHT_CATERPILLAR, MAX_COUNT_CATERPILLAR, MAX_SPEED_CATERPILLAR, MAX_SATIETY_CATERPILLAR);
    }
}
