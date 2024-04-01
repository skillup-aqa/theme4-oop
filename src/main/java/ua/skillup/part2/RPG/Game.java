package ua.skillup.part2.RPG;

public class Game {

    public static void kick(Unit kicker, Unit kicked) {
        int minusHealth = kicker.kickPower;
        if (kicked.isPoisoned) {
            //the case when archer is used three times in a row is not considered
            minusHealth = kicker.kickPower + kicker.kickPower / 2;
        }
        kicked.changeHealth(minusHealth);
        if (kicker.unitName.equals("Archer")) {
            kicked.setPoisoned(true);
        } else {
            kicked.setPoisoned(false);
        }
    }

    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Archer archer = new Archer();
        Magician magician = new Magician();
        Ork ork = new Ork();
        Unit[] arrayOfSoldiers = {warrior, archer, magician};

//        warrior.display();
//        archer.display();
//        magician.display();
//        ork.display();

        kick(archer, ork);
        ork.display();

        kick(warrior, ork);
        ork.display();

        kick(warrior, ork);
        ork.display();
        System.out.println(arrayOfSoldiers[(int) (Math.random() * 3)].unitName);
    }
}
