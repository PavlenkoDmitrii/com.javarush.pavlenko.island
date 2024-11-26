package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;

public class Buffalo extends Herbivore {

    private final HashMap<String, Integer> buffaloProbabilities;
    {
        buffaloProbabilities = new HashMap<>() {{
            put(PLANT_NAME, PROBABILITY_PLANTS_TO_BE_EATABLE);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return buffaloProbabilities;
    }

    public Buffalo() {
        super(WEIGHT_BUFFALO, MAX_COUNT_BUFFALO, BUFFALO_NAME, MAX_SPEED_BUFFALO, MAX_SATIETY_BUFFALO);
    }
}
