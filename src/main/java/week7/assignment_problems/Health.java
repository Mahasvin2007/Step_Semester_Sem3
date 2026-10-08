class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        health -= amount;

        if (health < 0) {
            health = 0;
        }

        System.out.println("Health = " + health);
    }

    public void heal(int amount) {
        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }

        System.out.println("Health = " + health);
    }

    public int getHealth() {
        return health;
    }
}

public class Health {
    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);   // Health = 70
        c.heal(50);         // Health = 100 (capped)
        c.takeDamage(150);  // Health = 0 (floored)
    }
}