package entity.creatures.animals.predators;

import entity.creatures.Eatable;
import entity.creatures.abstracts.Predator;
import java.util.HashMap;

import static config.Settings.*;
import static factory.TypesHerbivores.*;

public class Fox extends Predator {

    private final HashMap<String , Integer> foxProbabilities;
    {
        foxProbabilities = new HashMap<>() {{
            put(RABBIT_NAME, PROBABILITY_FOX_EAT_RABBIT);
            put(MOUSE_NAME, PROBABILITY_FOX_EAT_MOUSE);
            put(DUCK_NAME, PROBABILITY_FOX_EAT_DUCK);
            put(CATERPILLAR_NAME, PROBABILITY_FOX_EAT_CATERPILLAR);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return foxProbabilities;
    }

    public Fox() {
        super(WEIGHT_FOX, MAX_COUNT_FOX, FOX_NAME, MAX_SPEED_FOX, MAX_SATIETY_FOX);
    }
}
