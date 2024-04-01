package ua.skillup.part2.RPG;

import com.sun.source.util.SourcePositions;

abstract public class Unit {
    protected int healthPower;
    protected int kickPower;

    public void setPower(int healthPower, int kickPower) {
        this.healthPower = healthPower;
        this.kickPower = kickPower;
    }

    public void display() {
        System.out.println("HP: " + healthPower + "\n");
        System.out.println("KP: " + kickPower + "\n");
    }
}
