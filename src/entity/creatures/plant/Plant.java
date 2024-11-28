package entity.creatures.plant;

import entity.creatures.abstracts.Creature;

import static config.Settings.*;

public class Plant extends Creature {

    public Plant() {
        super(WEIGHT_PLANT, MAX_COUNT_PLANT, PLANT_NAME);
    }

    @Override
    public Creature reproduce(Creature creature) {
        if (creature instanceof Plant) {
            return new Plant();
        }
        return this;
    }
}
