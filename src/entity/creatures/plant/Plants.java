package entity.creatures.plant;

import entity.creatures.abstracts.Creature;

import static config.Settings.*;

public class Plants extends Creature {

    public Plants() {
        super(WEIGHT_PLANT, MAX_COUNT_PLANT, PLANT_NAME);
    }

    @Override
    public void reproduce() {

    }
}

