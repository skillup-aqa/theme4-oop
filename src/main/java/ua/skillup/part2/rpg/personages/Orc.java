package ua.skillup.part2.rpg.personages;

public class Orc extends Personage {
    private int poisonStatus = 0;

    public Orc() {
        name = "Orc";
        health = 250;
        damage = 30;
    }

    @Override
    public void receiveDamageOf(int damage) {
        if (this.poisonStatus > 0) {
            System.out.println("Orc is poisoned! Health is decreasing twice faster!");
            super.receiveDamageOf((int) Math.round(damage * 1.5));
        } else {
            super.receiveDamageOf(damage);
        }
    }

    @Override
    public void onRoundEnd() {
        if (this.poisonStatus > 0) {
            this.poisonStatus--;
        }
    }

    public int attack(String targetName) {
        System.out.println("Orc attacks " + targetName + " with " + this.damage + " damage");
        return this.damage;
    }

    public Personage selectTargetFrom(Personage[] personages) {
        return personages[(int) (Math.random() * personages.length)];
    }

    public void poisoned() {
        System.out.println("Orc is poisoned!");
        this.poisonStatus = 2;
    }

}
