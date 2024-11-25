package entity.creatures.animals.predators;

import entity.creatures.Eatable;
import entity.creatures.abstracts.Predator;

import java.util.HashMap;

import static config.Settings.*;
import static factory.TypesHerbivores.*;
import static factory.TypesPredators.*;

public class Eagle extends Predator {

    private final HashMap<Eatable, Integer> eagleProbabilities;
    {
        eagleProbabilities = new HashMap<>() {{
            put(FOX, PROBABILITY_EAGLE_EAT_FOX);
            put(RABBIT, PROBABILITY_EAGLE_EAT_RABBIT);
            put(MOUSE, PROBABILITY_EAGLE_EAT_MOUSE);
            put(DUCK, PROBABILITY_EAGLE_EAT_DUCK);
        }};
    }

    @Override
    public HashMap<Eatable, Integer> getProbabilities() {
        return eagleProbabilities;
    }

    public Eagle() {
        super(WEIGHT_EAGLE, MAX_COUNT_EAGLE, EAGLE_NAME, MAX_SPEED_EAGLE, MAX_SATIETY_EAGLE);

    }
}
