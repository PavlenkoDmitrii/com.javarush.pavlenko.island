package entity.creatures.animals.predators;

import entity.creatures.Eatable;
import entity.creatures.abstracts.Predator;

import java.util.HashMap;

import static config.Settings.*;
import static factory.TypesHerbivores.*;
import static factory.TypesPredators.*;

public class Bear extends Predator {

    private final HashMap<String, Integer> bearProbabilities;
    {
        bearProbabilities = new HashMap<>() {{
            put(BOA_NAME, PROBABILITY_BEAR_EAT_BOA);
            put(HORSE_NAME, PROBABILITY_BEAR_EAT_HORSE);
            put(DEER_NAME, PROBABILITY_BEAR_EAT_DEER);
            put(RABBIT_NAME, PROBABILITY_BEAR_EAT_RABBIT);
            put(MOUSE_NAME, PROBABILITY_BEAR_EAT_MOUSE);
            put(GOAT_NAME, PROBABILITY_BEAR_EAT_GOAT);
            put(SHEEP_NAME, PROBABILITY_BEAR_EAT_SHEEP);
            put(BOAR_NAME, PROBABILITY_BEAR_EAT_BOAR);
            put(BUFFALO_NAME, PROBABILITY_BEAR_EAT_BUFFALO);
            put(DUCK_NAME, PROBABILITY_BEAR_EAT_DUCK);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return bearProbabilities;
    }

    public Bear() {
        super(WEIGHT_BEAR, MAX_COUNT_BEAR, BEAR_NAME, MAX_SPEED_BEAR, MAX_SATIETY_BEAR);
    }
}
