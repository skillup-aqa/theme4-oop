package ua.skillup.part2.RPG;

final public class Ork extends Unit implements Poisoned {
    boolean isPoisoned;

    public Ork() {
        super("Ork", 250, 30);
        isPoisoned = false;
    }

    @Override
    public void display() {
        System.out.println("Unit: " + unitName + " HP: " + healthPower + " KP: " + kickPower + " Is poisoned: "
                + isPoisoned);
    }

    @Override
    public void setPoisoned(boolean poisoned) {
        this.isPoisoned = poisoned;
    }
}
