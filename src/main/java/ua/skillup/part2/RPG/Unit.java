package ua.skillup.part2.RPG;

abstract public class Unit {
    protected int healthPower;
    protected int kickPower;

    abstract void setPower();

    public void display() {
        System.out.println("HP: " + healthPower + "\n");
        System.out.println("KP: " + kickPower + "\n");
    }
}
