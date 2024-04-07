package ua.skillup.part2.RPG;

abstract public class Unit {

    protected boolean isPoisoned = false;

    protected String unitName;
    protected int healthPower;
    protected int kickPower;

    protected static int counter = 3;

    public Unit(String unitName, int healthPower, int kickPower) {
        this.unitName = unitName;
        this.healthPower = healthPower;
        this.kickPower = kickPower;
    }


    public void setPoisoned(boolean poisoned) {
        this.isPoisoned = poisoned;
    }

    public void magicianMadeKick() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void magicianAddCounter() {
        counter += 1;
    }

    public void display() {
        System.out.println("Unit: " + unitName + " HP: " + healthPower + " KP: " + kickPower);
    }

    final public void changeHealth(int minus) {
        this.healthPower -= minus;
    }

    final public boolean isDead() {
        if (this.healthPower < 1) {
            return true;
        }
        return false;
    }
}


