package ua.skillup.part2.RPG;

public class Warrior extends Unit{

    @Override
    void setPower() {
        this.healthPower = 100;
        this.kickPower = 20;
    }
}
