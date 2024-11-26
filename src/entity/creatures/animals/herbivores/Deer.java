package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;

public class Deer extends Herbivore {

    private final HashMap<String, Integer> deerProbabilities;
    {
        deerProbabilities = new HashMap<>() {{
            put(PLANT_NAME, PROBABILITY_PLANTS_TO_BE_EATABLE);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return deerProbabilities;
    }

    public Deer() {
        super(WEIGHT_DEER, MAX_COUNT_DEER, DEER_NAME, MAX_SPEED_DEER, MAX_SATIETY_DEER);
    }
}
