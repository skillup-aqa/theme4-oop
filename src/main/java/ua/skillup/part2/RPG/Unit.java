package ua.skillup.part2.RPG;

abstract public class Unit {

    protected String unitName;
    protected int healthPower;
    protected int kickPower;

    public void setPower(String name, int health, int kick) {
        this.unitName = name;
        this.healthPower = health;
        this.kickPower = kick;
    }

    public void display() {
        System.out.println("Unit: " + unitName + "\n");
        System.out.println("HP: " + healthPower + "\n");
        System.out.println("KP: " + kickPower + "\n");
    }
}
