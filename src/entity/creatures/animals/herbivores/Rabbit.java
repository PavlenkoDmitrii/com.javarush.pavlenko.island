package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Rabbit extends Herbivore {

    public Rabbit() {
        super(WEIGHT_RABBIT, MAX_COUNT_RABBIT, RABBIT_NAME, MAX_SPEED_RABBIT, MAX_SATIETY_RABBIT);
    }
}
