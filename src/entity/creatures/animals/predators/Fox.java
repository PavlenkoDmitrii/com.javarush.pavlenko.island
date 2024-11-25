package entity.creatures.animals.predators;

import entity.creatures.Eatable;
import entity.creatures.abstracts.Predator;
import java.util.HashMap;

import static config.Settings.*;
import static factory.TypesHerbivores.*;

public class Fox extends Predator {

    private final HashMap<Eatable, Integer> foxProbabilities;
    {
        foxProbabilities = new HashMap<>() {{
            put(RABBIT, PROBABILITY_FOX_EAT_RABBIT);
            put(MOUSE, PROBABILITY_FOX_EAT_MOUSE);
            put(DUCK, PROBABILITY_FOX_EAT_DUCK);
            put(CATERPILLAR, PROBABILITY_FOX_EAT_CATERPILLAR);
        }};
    }

    @Override
    public HashMap<Eatable, Integer> getProbabilities() {
        return foxProbabilities;
    }

    public Fox() {
        super(WEIGHT_FOX, MAX_COUNT_FOX, FOX_NAME, MAX_SPEED_FOX, MAX_SATIETY_FOX);
    }
}
