package ua.skillup.part2.RPG;

final public class Magician extends Unit {

    public Magician() {
        super("Magician", 50, 80);
    }

    @Override
    public void display() {
        System.out.println("Unit: " + unitName + " HP: " + healthPower + " KP: " + kickPower + " Counter: " + counter);
    }
}
