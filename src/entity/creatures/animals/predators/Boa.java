package entity.creatures.animals.predators;

import entity.creatures.abstracts.Predator;

import java.util.HashMap;

import static config.Settings.*;

public class Boa extends Predator {

    private final HashMap<String, Integer> boaProbabilities;
    {
        boaProbabilities = new HashMap<>() {{
            put(FOX_NAME, PROBABILITY_BOA_EAT_FOX);
            put(RABBIT_NAME, PROBABILITY_BOA_EAT_RABBIT);
            put(MOUSE_NAME, PROBABILITY_BOA_EAT_MOUSE);
            put(DUCK_NAME, PROBABILITY_BOA_EAT_DUCK);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return boaProbabilities;
    }

    public Boa() {
        super(WEIGHT_BOA, MAX_COUNT_BOA, BOA_NAME, MAX_SPEED_BOA, MAX_SATIETY_BOA);
    }
}
