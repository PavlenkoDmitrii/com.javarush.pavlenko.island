package entity.creatures.animals.predators;

import entity.creatures.abstracts.Predator;

import java.util.HashMap;

import static config.Settings.*;

public class Eagle extends Predator {

    private final HashMap<String, Integer> eagleProbabilities;
    {
        eagleProbabilities = new HashMap<>() {{
            put(FOX_NAME, PROBABILITY_EAGLE_EAT_FOX);
            put(RABBIT_NAME, PROBABILITY_EAGLE_EAT_RABBIT);
            put(MOUSE_NAME, PROBABILITY_EAGLE_EAT_MOUSE);
            put(DUCK_NAME, PROBABILITY_EAGLE_EAT_DUCK);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return eagleProbabilities;
    }

    public Eagle() {
        super(WEIGHT_EAGLE, MAX_COUNT_EAGLE, EAGLE_NAME, MAX_SPEED_EAGLE, MAX_SATIETY_EAGLE);

    }
}
