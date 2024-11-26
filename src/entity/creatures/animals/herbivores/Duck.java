package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;

public class Duck extends Herbivore {

    private final HashMap<String, Integer> duckProbabilities;
    {
        duckProbabilities = new HashMap<>() {{
            put(CATERPILLAR_NAME, PROBABILITY_DUCK_EAT_CATERPILLAR);
            put(PLANT_NAME, PROBABILITY_PLANTS_TO_BE_EATABLE);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return duckProbabilities;
    }

    public Duck() {
        super(WEIGHT_DUCK, MAX_COUNT_DUCK, DUCK_NAME, MAX_SPEED_DUCK, MAX_SATIETY_DUCK);
    }
}
