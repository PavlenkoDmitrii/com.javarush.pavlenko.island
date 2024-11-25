package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Deer extends Herbivore {

    public Deer() {
        super(WEIGHT_DEER, MAX_COUNT_DEER, DEER_NAME, MAX_SPEED_DEER, MAX_SATIETY_DEER);
    }
}
