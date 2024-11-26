package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;

public class Rabbit extends Herbivore {

    private final HashMap<String, Integer> rabbitProbabilities;
    {
        rabbitProbabilities = new HashMap<>() {{
            put(PLANT_NAME, PROBABILITY_PLANTS_TO_BE_EATABLE);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return rabbitProbabilities;
    }

    public Rabbit() {
        super(WEIGHT_RABBIT, MAX_COUNT_RABBIT, RABBIT_NAME, MAX_SPEED_RABBIT, MAX_SATIETY_RABBIT);
    }
}
