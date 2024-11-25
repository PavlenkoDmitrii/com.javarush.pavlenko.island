package entity.creatures.animals.herbivores;

import config.Settings;
import entity.creatures.Eatable;
import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;
import static factory.TypesHerbivores.CATERPILLAR;

public class Mouse extends Herbivore {

    private final HashMap<String, Integer> mouseProbabilities;
    {
        mouseProbabilities = new HashMap<>() {{
            put(CATERPILLAR_NAME, PROBABILITY_MOUSE_EAT_CATERPILLAR);
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
