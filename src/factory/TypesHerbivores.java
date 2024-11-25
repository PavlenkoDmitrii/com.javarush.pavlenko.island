package factory;

import entity.creatures.Eatable;

import java.util.Arrays;

public enum TypesHerbivores implements Eatable {
    BOAR(0),
    BUFFALO(1),
    CATERPILLAR(2),
    DEER(3),
    DUCK(4),
    GOAT(5),
    HORSE(6),
    MOUSE(7),
    RABBIT(8),
    SHEEP(9);

    private final int ID;

    TypesHerbivores(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public static TypesHerbivores getHerbivoreByID(int id) {
        TypesHerbivores type;
            type = Arrays.stream(TypesHerbivores.values())
                    .filter(typeHerbivore -> typeHerbivore.getID() == id)
                    .findFirst().orElseThrow(() -> new RuntimeException("Указан некорректный ID: " + id));
        return type;
    }

    @Override
    public void die() {}
}
