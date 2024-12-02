package entity.creatures.plant;

import entity.creatures.abstracts.Creature;
import entity.place.Location;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static config.Settings.*;
import static factory.TypesCreatures.PLANT;
import static factory.TypesCreaturesFactory.createCreature;

public class Plant extends Creature {

    public Plant() {
        super(WEIGHT_PLANT, MAX_COUNT_PLANT, PLANT_NAME);
    }

    public void growOfPlantsOnLocation(Location location) {
        location.getLock().lock();
        try {
            if (location.getAllPlants().size() >= MAX_COUNT_PLANT) {
                return;
            }
            List<Creature> temp = location.getCreaturesOnLocation();
            int random = ThreadLocalRandom.current().nextInt(0, (MAX_COUNT_PLANT - location.getAllPlants().size()) + 1);
            for (int i = 0; i < random/130; i++) {                      //искусственно ограничен рост травы
                Creature creature = createCreature(PLANT);
                temp.add(creature);
            }
            location.setCreaturesOnLocation(temp);
        } finally {
            location.getLock().unlock();
        }
    }
}
