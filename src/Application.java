import entity.creatures.abstracts.Creatures;
import entity.creatures.abstracts.Herbivore;
import entity.creatures.abstracts.Predator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Predator> predatorList = new ArrayList<>();
        List<Herbivore> herbivoreList = new ArrayList<>();
        TypesCreaturesFactory typesCreaturesFactory = new TypesCreaturesFactory();

        for (int i = 0; i < 5; i++) {
            int randomPredator = (int) (Math.random() * 5) + 1;
            predatorList.add((Predator) typesCreaturesFactory.createCreatures(TypesCreatures.getPredatorByID(randomPredator)));
        }

        for (int i = 0; i < 10; i++) {
            int randomHerbivore = (int) (Math.random() * 10) + 6;
            herbivoreList.add((Herbivore) typesCreaturesFactory.createCreatures(TypesCreatures.getHerbivoreByID(randomHerbivore)));
        }
        for (Predator predator : predatorList) {
            System.out.print(predator.getName() + " ");
        }
        System.out.println();
        System.out.println("*".repeat(100));
        for (Herbivore herbivore : herbivoreList) {
            System.out.print(herbivore.getName() + " ");
        }
    }
}