import java.util.Random;
import java.util.Arrays;

interface Monster {
    float attack();
}

class Zombie implements Monster {
    @Override
    public float attack() {
        return 5.0f;
    }

    @Override
    public String toString() {
        return "Zombie, " + attack() + " damage";
    }
}

class Vampire implements Monster {
    @Override
    public float attack() {
        return 10.0f;
    }

    @Override
    public String toString() {
        return "Vampire, " + attack() + " damage";
    }
}

class Dragon implements Monster {
    @Override
    public float attack() {
        return 20.0f;
    }

    @Override
    public String toString() {
        return "Dragon, " + attack() + " damage";
    }
}

class MonsterFactory {
    private static final int NUM_MONSTER_TYPES = 3;

    public static Monster createMonster(Random random) {
        int monsterType = random.nextInt(NUM_MONSTER_TYPES);
        switch (monsterType) {
            case 0:
                return new Zombie();
            case 1:
                return new Vampire();
            case 2:
                return new Dragon();
            default:
                return null;
        }
    }
}

public class Game {
    public static void main(String[] args) {
        Random random = new Random();
        Monster[] monsters = new Monster[5];
        float totalAttack = 0.0f;

        for (int i = 0; i < monsters.length; i++) {
            monsters[i] = MonsterFactory.createMonster(random);
            totalAttack += monsters[i].attack();
            System.out.println("Monster " + (i + 1) + " attacks with " + monsters[i].attack() + " damage.");
        }

        System.out.println("Total attack by monsters: " + totalAttack);

        if (totalAttack < 50) {
            System.out.println("The hero wins!");
        } else {
            System.out.println("The hero is defeated!");
        }

        System.out.println("Monsters are: " + Arrays.toString(monsters));
    }
}
