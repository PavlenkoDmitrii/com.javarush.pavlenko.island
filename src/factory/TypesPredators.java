package factory;

import entity.creatures.Eatable;

import java.util.Arrays;

public enum TypesPredators implements Eatable {
    BEAR(0),
    BOA(1),
    EAGLE(2),
    FOX(3),
    WOLF(4);

    private final int ID;

    TypesPredators(int id) {
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    public static TypesPredators getPredatorByID(int id) {
        TypesPredators type;
            type = Arrays.stream(TypesPredators.values())
                    .filter(typePredator -> typePredator.getID() == id)
                    .findFirst().orElseThrow(() -> new RuntimeException("Указан некорректный ID: " + id));
        return type;
    }

    @Override
    public void die() {}
}
