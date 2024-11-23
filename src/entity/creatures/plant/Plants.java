package entity.creatures.plant;

import entity.creatures.abstracts.Creatures;

import static config.Settings.*;

public class Plants extends Creatures {

    public Plants() {
        super(WEIGHT_PLANT, MAX_COUNT_PLANT);
    }

    @Override
    public void reproduce() {

    }
}

