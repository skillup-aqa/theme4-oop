package ua.skillup.part2.RPG;

abstract public class Unit {

    protected String unitName;
    protected int healthPower;
    protected int kickPower;

    public Unit(String unitName, int healthPower, int kickPower) {
        this.unitName = unitName;
        this.healthPower = healthPower;
        this.kickPower = kickPower;
    }

    public void display() {
        System.out.println("Unit: " + unitName + " HP: " + healthPower + " KP: " + kickPower);
    }

    final public void changeHealth(int minus) {
        this.healthPower -= minus;
    }

    final public boolean isDead() {
        return this.healthPower < 1;
    }

}


