package entity.creatures.animals.predators;

import entity.creatures.abstracts.Predator;
import entity.creatures.Eatable;
import java.util.HashMap;

import static config.Settings.*;
import static factory.TypesHerbivores.*;

public class Wolf extends Predator {

    private final HashMap<Eatable, Integer> wolfProbabilities;
    {
        wolfProbabilities = new HashMap<>() {{
            put(HORSE, PROBABILITY_WOLF_EAT_HORSE);
            put(DEER, PROBABILITY_WOLF_EAT_DEER);
            put(RABBIT, PROBABILITY_WOLF_EAT_RABBIT);
            put(MOUSE, PROBABILITY_WOLF_EAT_MOUSE);
            put(GOAT, PROBABILITY_WOLF_EAT_GOAT);
            put(SHEEP, PROBABILITY_WOLF_EAT_SHEEP);
            put(BOAR, PROBABILITY_WOLF_EAT_BOAR);
            put(BUFFALO, PROBABILITY_WOLF_EAT_BUFFALO);
            put(DUCK, PROBABILITY_WOLF_EAT_DUCK);
        }};
    }

    @Override
    public HashMap<Eatable, Integer> getProbabilities() {
        return wolfProbabilities;
    }

    public Wolf() {
        super(WEIGHT_WOLF, MAX_COUNT_WOLF, WOLF_NAME, MAX_SPEED_WOLF, MAX_SATIETY_WOLF);
    }


}
