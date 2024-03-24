package ua.skillup.part2.rpg.personages;

public class Archer extends Personage {
    public Archer() {
        this.name = "Archer";
        this.health = 70;
        this.damage = 10;
    }

    @Override
    public void displayStats() {
        System.out.println(name + " has " + health + " health and " + damage + " damage. The enemy will be poisoned!");
    }
}
