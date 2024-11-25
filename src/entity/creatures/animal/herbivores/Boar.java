package entity.creatures.animal.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Boar extends Herbivore {

    public Boar() {
        super(WEIGHT_BOAR, MAX_COUNT_BOAR, BOAR_NAME, MAX_SPEED_BOAR, MAX_SATIETY_BOAR);
    }

}
