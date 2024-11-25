package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Caterpillar extends Herbivore {

    public Caterpillar() {
        super(WEIGHT_CATERPILLAR, MAX_COUNT_CATERPILLAR, CATERPILLAR_NAME, MAX_SPEED_CATERPILLAR, MAX_SATIETY_CATERPILLAR);
    }
}
