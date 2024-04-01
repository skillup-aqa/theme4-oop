package ua.skillup.part2.RPG;

public class Warrior extends Unit{


    public Warrior() {
        setPower();
    }
    @Override
    void setPower() {
        this.healthPower = 100;
        this.kickPower = 20;
    }
}
