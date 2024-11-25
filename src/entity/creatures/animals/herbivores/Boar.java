package entity.creatures.animals.herbivores;

import entity.creatures.Eatable;
import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;
import static factory.TypesHerbivores.*;

public class Boar extends Herbivore {

    private final HashMap<String, Integer> boarProbabilities;
    {
        boarProbabilities = new HashMap<>() {{
            put(MOUSE_NAME, PROBABILITY_BOAR_EAT_MOUSE);
            put(CATERPILLAR_NAME, PROBABILITY_BOAR_EAT_CATERPILLAR);
        }};
    }

    @Override
    public HashMap<String, Integer> getProbabilities() {
        return boarProbabilities;
    }

    public Boar() {
        super(WEIGHT_BOAR, MAX_COUNT_BOAR, BOAR_NAME, MAX_SPEED_BOAR, MAX_SATIETY_BOAR);
    }

}
