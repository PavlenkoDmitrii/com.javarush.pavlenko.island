package entity.creatures.animals.herbivores;

import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;

public class Mouse extends Herbivore {

    private final HashMap<String, Integer> mouseProbabilities;
    {
        mouseProbabilities = new HashMap<>() {{
            put(CATERPILLAR_NAME, PROBABILITY_MOUSE_EAT_CATERPILLAR);
            put(PLANT_NAME, PROBABILITY_PLANTS_TO_BE_EATABLE);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return mouseProbabilities;
    }

    public Mouse() {
        super(WEIGHT_MOUSE, MAX_COUNT_MOUSE, MOUSE_NAME, MAX_SPEED_MOUSE, MAX_SATIETY_MOUSE);
    }
}
