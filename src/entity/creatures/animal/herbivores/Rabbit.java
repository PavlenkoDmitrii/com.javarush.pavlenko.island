package entity.creatures.animal.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Rabbit extends Herbivore {
    public Rabbit() {
        super(WEIGHT_RABBIT, MAX_COUNT_RABBIT, MAX_SPEED_RABBIT, MAX_SATIETY_RABBIT);
    }
}
