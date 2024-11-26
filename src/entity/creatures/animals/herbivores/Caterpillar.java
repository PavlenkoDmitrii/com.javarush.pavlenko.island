package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;

public class Caterpillar extends Herbivore {

    private final HashMap<String, Integer> caterpillarProbabilities;
    {
        caterpillarProbabilities = new HashMap<>() {{
            put(PLANT_NAME, PROBABILITY_PLANTS_TO_BE_EATABLE);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return caterpillarProbabilities;
    }

    public Caterpillar() {
        super(WEIGHT_CATERPILLAR, MAX_COUNT_CATERPILLAR, CATERPILLAR_NAME, MAX_SPEED_CATERPILLAR, MAX_SATIETY_CATERPILLAR);
    }
}
