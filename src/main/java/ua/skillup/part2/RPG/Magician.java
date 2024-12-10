package ua.skillup.part2.RPG;

final public class Magician extends Unit {

    private int counter = 3;

    public Magician() {
        super("Magician", 50, 80);
    }


    public void magicianMadeKick() {
        this.counter = 0;
        kickPower = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void magicianAddCounter() {
        if (counter < 4) {
            counter += 1;
        }
        if (counter > 2) {
            kickPower = 80;
        }
    }

    @Override
    public void display() {
        System.out.println("Unit: " + unitName + " HP: " + healthPower + " KP: " + kickPower + " Counter: " + counter);
    }
}
