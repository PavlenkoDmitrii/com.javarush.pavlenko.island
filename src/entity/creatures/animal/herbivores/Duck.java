package entity.creatures.animal.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Duck extends Herbivore {
    public Duck() {
        super(WEIGHT_DUCK, MAX_COUNT_DUCK, MAX_SPEED_DUCK, MAX_SATIETY_DUCK);
    }
}
