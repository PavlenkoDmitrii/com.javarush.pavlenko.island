package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;

public class Goat extends Herbivore {
    private final HashMap<String, Integer> goatProbabilities;
    {
        goatProbabilities = new HashMap<>() {{
            put(PLANT_NAME, PROBABILITY_PLANTS_TO_BE_EATABLE);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return goatProbabilities;
    }

    public Goat() {
        super(WEIGHT_GOAT, MAX_COUNT_GOAT, GOAT_NAME, MAX_SPEED_GOAT, MAX_SATIETY_GOAT);
    }
}
