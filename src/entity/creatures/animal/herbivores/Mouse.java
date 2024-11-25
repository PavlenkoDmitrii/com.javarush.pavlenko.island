package entity.creatures.animal.herbivores;

import entity.creatures.abstracts.Herbivore;

import static config.Settings.*;

public class Mouse extends Herbivore {


    public Mouse() {
        super(WEIGHT_MOUSE, MAX_COUNT_MOUSE, MOUSE_NAME, MAX_SPEED_MOUSE, MAX_SATIETY_MOUSE);
    }
}
