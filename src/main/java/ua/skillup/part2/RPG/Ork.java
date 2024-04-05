package ua.skillup.part2.RPG;

final public class Ork extends Unit {

    public Ork() {
        setPower("Ork", 250, 30);
    }

    @Override
    public void display() {
        System.out.println("Unit: " + unitName + " HP: " + healthPower + " KP: " + kickPower + " Is poisoned: "
                + isPoisoned);
    }
}
