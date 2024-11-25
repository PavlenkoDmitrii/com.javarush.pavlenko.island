package entity.creatures.animal.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Buffalo extends Herbivore {

    public Buffalo() {
        super(WEIGHT_BUFFALO, MAX_COUNT_BUFFALO, BUFFALO_NAME, MAX_SPEED_BUFFALO, MAX_SATIETY_BUFFALO);
    }
}
