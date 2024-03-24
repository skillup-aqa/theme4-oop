package ua.skillup.part2.rpg.personages;

abstract public class Personage {
    protected int health = -1;
    protected int damage = -1;

    protected String name;


    public String getName() {
        return this.name;
    }

    public void receiveDamageOf(int damage) {
        health -= damage;

        System.out.println(this.name + " received " + damage + " damage.");

        if (this.isDead()) {
            System.out.println(this.name + " is dead :(");
        }
    }

    public int attack() {
        System.out.println(this.name + " attacks with " + this.damage + " damage");
        return this.damage;
    }

    public boolean isDead() {
        return health <= 0;
    }

    public void displayStats() {
        System.out.println(name + " has " + health + " health and " + damage + " damage");
    }

    public void onRoundEnd() {
        // Leaving it blanc.
        // Other classes may implement their hooks
    }
}
