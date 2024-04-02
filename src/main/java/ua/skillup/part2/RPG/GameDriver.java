package ua.skillup.part2.RPG;

public class GameDriver {

    Unit randomSoldier;
    Warrior warrior = new Warrior();
    Archer archer = new Archer();
    Magician magician = new Magician();
    Ork ork = new Ork();
    Unit[] arrayOfSoldiers = {warrior, archer, magician};

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
        if (kicker.unitName.equals("Magician")) {
            kicker.magicianMadeKick();
            kicker.kickPower = 0;
        }
    }

    public void raund(Unit kicker) {
        magician.magicianAddCounter();
        if (magician.getCounter() > 2) {
            magician.kickPower = 80;
        }
        randomSoldier = arrayOfSoldiers[(int) (Math.random() * 3)];
        kick(ork, randomSoldier);
        kick(kicker, ork);
        ork.display();
        randomSoldier.display();
        kicker.display();


    }
}


