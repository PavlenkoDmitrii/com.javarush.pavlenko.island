package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;

public class Sheep extends Herbivore {

    private final HashMap<String, Integer> sheepProbabilities;
    {
        sheepProbabilities = new HashMap<>() {{
            put(PLANT_NAME, PROBABILITY_PLANTS_TO_BE_EATABLE);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return sheepProbabilities;
    }

    public Sheep() {
        super(WEIGHT_SHEEP, MAX_COUNT_SHEEP, SHEEP_NAME, MAX_SPEED_SHEEP, MAX_SATIETY_SHEEP);
    }
}
