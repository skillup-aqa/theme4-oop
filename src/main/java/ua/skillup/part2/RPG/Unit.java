package ua.skillup.part2.RPG;

abstract public class Unit {

    protected boolean isPoisoned = false;

    protected String unitName;
    protected int healthPower;
    protected int kickPower;

    public void setPower(String name, int health, int kick) {
        this.unitName = name;
        this.healthPower = health;
        this.kickPower = kick;
    }

    public void setPoisoned(boolean poisoned) {
        this.isPoisoned = poisoned;
    }

    public void display() {
        System.out.println("Unit: " + unitName + "\n");
        System.out.println("HP: " + healthPower + "\n");
        System.out.println("KP: " + kickPower + "\n");
        System.out.println("Is poisoned: " + isPoisoned + "\n");
    }

    final public void changeHealth(int minus) {
        this.healthPower -= minus;
    }

    final public void changeKick(int plus) {
        this.kickPower += plus;
    }
}
