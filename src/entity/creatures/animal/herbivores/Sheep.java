package entity.creatures.animal.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Sheep extends Herbivore {
    public Sheep() {
        super(WEIGHT_SHEEP, MAX_COUNT_SHEEP, MAX_SPEED_SHEEP, MAX_SATIETY_SHEEP);
    }
}
