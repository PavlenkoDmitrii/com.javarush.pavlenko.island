package entity.creatures.animals.herbivores;

import entity.creatures.Eatable;
import entity.creatures.abstracts.Herbivore;

import java.util.HashMap;

import static config.Settings.*;
import static factory.TypesHerbivores.*;

public class Boar extends Herbivore {

    private final HashMap<Eatable, Integer> boarProbabilities;
    {
        boarProbabilities = new HashMap<>() {{
            put(MOUSE, PROBABILITY_BOAR_EAT_MOUSE);
            put(CATERPILLAR, PROBABILITY_BOAR_EAT_CATERPILLAR);
        }};
    }

    @Override
    public HashMap<Eatable, Integer> getProbabilities() {
        return boarProbabilities;
    }

    public Boar() {
        super(WEIGHT_BOAR, MAX_COUNT_BOAR, BOAR_NAME, MAX_SPEED_BOAR, MAX_SATIETY_BOAR);
    }

}
