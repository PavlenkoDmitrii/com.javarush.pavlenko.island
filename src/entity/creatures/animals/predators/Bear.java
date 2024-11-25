package entity.creatures.animals.predators;

import entity.creatures.Eatable;
import entity.creatures.abstracts.Predator;

import java.util.HashMap;

import static config.Settings.*;
import static factory.TypesHerbivores.*;
import static factory.TypesPredators.*;

public class Bear extends Predator {

    private final HashMap<Eatable, Integer> bearProbabilities;
    {
        bearProbabilities = new HashMap<>() {{
            put(BOA, PROBABILITY_BEAR_EAT_BOA);
            put(HORSE, PROBABILITY_BEAR_EAT_HORSE);
            put(DEER, PROBABILITY_BEAR_EAT_DEER);
            put(RABBIT, PROBABILITY_BEAR_EAT_RABBIT);
            put(MOUSE, PROBABILITY_BEAR_EAT_MOUSE);
            put(GOAT, PROBABILITY_BEAR_EAT_GOAT);
            put(SHEEP, PROBABILITY_BEAR_EAT_SHEEP);
            put(BOAR, PROBABILITY_BEAR_EAT_BOAR);
            put(BUFFALO, PROBABILITY_BEAR_EAT_BUFFALO);
            put(DUCK, PROBABILITY_BEAR_EAT_DUCK);
        }};
    }

    @Override
    public HashMap<Eatable, Integer> getProbabilities() {
        return bearProbabilities;
    }

    public Bear() {
        super(WEIGHT_BEAR, MAX_COUNT_BEAR, BEAR_NAME, MAX_SPEED_BEAR, MAX_SATIETY_BEAR);
    }
}
