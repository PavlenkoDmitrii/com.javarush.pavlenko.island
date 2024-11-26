package entity.creatures.animals.predators;

import entity.creatures.abstracts.Predator;
import java.util.HashMap;

import static config.Settings.*;

public class Wolf extends Predator {

    private final HashMap<String, Integer> wolfProbabilities;
    {
        wolfProbabilities = new HashMap<>() {{
            put(HORSE_NAME, PROBABILITY_WOLF_EAT_HORSE);
            put(DEER_NAME, PROBABILITY_WOLF_EAT_DEER);
            put(RABBIT_NAME, PROBABILITY_WOLF_EAT_RABBIT);
            put(MOUSE_NAME, PROBABILITY_WOLF_EAT_MOUSE);
            put(GOAT_NAME, PROBABILITY_WOLF_EAT_GOAT);
            put(SHEEP_NAME, PROBABILITY_WOLF_EAT_SHEEP);
            put(BOAR_NAME, PROBABILITY_WOLF_EAT_BOAR);
            put(BUFFALO_NAME, PROBABILITY_WOLF_EAT_BUFFALO);
            put(DUCK_NAME, PROBABILITY_WOLF_EAT_DUCK);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return wolfProbabilities;
    }

    public Wolf() {
        super(WEIGHT_WOLF, MAX_COUNT_WOLF, WOLF_NAME, MAX_SPEED_WOLF, MAX_SATIETY_WOLF);
    }


}
