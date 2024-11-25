package entity.creatures.animals.predators;

import entity.creatures.Eatable;
import entity.creatures.abstracts.Predator;

import java.util.HashMap;

import static config.Settings.*;
import static factory.TypesHerbivores.*;
import static factory.TypesPredators.FOX;

public class Boa extends Predator {

    private final HashMap<Eatable, Integer> boaProbabilities;
    {
        boaProbabilities = new HashMap<>() {{
            put(FOX, PROBABILITY_BOA_EAT_FOX);
            put(RABBIT, PROBABILITY_BOA_EAT_RABBIT);
            put(MOUSE, PROBABILITY_BOA_EAT_MOUSE);
            put(DUCK, PROBABILITY_BOA_EAT_DUCK);
        }};
    }

    @Override
    public HashMap<Eatable, Integer> getProbabilities() {
        return boaProbabilities;
    }

    public Boa() {
        super(WEIGHT_BOA, MAX_COUNT_BOA, BOA_NAME, MAX_SPEED_BOA, MAX_SATIETY_BOA);
    }
}
