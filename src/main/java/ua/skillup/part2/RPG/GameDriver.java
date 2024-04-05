package ua.skillup.part2.RPG;

import java.util.Scanner;

public class GameDriver {
    Unit randomSoldier;

    Unit kicker;
    Warrior warrior = new Warrior();
    Archer archer = new Archer();
    Magician magician = new Magician();
    Ork ork = new Ork();
    Unit[] arrayOfSoldiers = {warrior, archer, magician};

    public void selectSoldier() {
        Scanner scanner = new Scanner(System.in);
        System.out.println((warrior.isDead() ? "" : ("Choose: Warrior 'w' has " + warrior.kickPower + " kick power, ")) +
                (magician.isDead() ? "" : ("Magician 'm' has " + magician.kickPower + " kick power, ")) +
                (archer.isDead() ? "" : ("Archer 'a' has " + archer.kickPower + " kick power.")));
        char selected = scanner.next().charAt(0);
        if (!warrior.isDead() && (selected == 'w' || selected == 'W')) {
            this.kicker = warrior;
        } else if (!magician.isDead() && (selected == 'm' || selected == 'M')) {
            this.kicker = magician;
        } else if (!archer.isDead() && (selected == 'a' || selected == 'A')) {
            this.kicker = archer;
        } else {
            selectSoldier();
        }
    }


    public static void kick(Unit kicker, Unit kicked) {
        int minusHealth = kicker.kickPower;
        if (kicked.isPoisoned && kicked.unitName.equals("Ork")) {
            //the case when archer is used three times in a row is not considered
            minusHealth = kicker.kickPower + kicker.kickPower / 2;
            kicked.setPoisoned(false);
        }
        kicked.changeHealth(minusHealth);
        if (kicker.unitName.equals("Archer")) {
            kicked.setPoisoned(true);
        }
        if (kicker.unitName.equals("Magician")) {
            kicker.magicianMadeKick();
            kicker.kickPower = 0;
        }
    }

    public void round() {
        selectSoldier();
        magician.magicianAddCounter();
        if (magician.getCounter() > 2) {
            magician.kickPower = 80;
        }
        do {
            randomSoldier = arrayOfSoldiers[(int) (Math.random() * 3)];
            if (!randomSoldier.isDead()) {
                break;
            }

        } while (2 > 1);

        kick(kicker, ork);
        if (ork.healthPower > 0) {
            kick(ork, randomSoldier);
        }
        System.out.println(kicker.unitName + " kicks Ork");
        if (ork.healthPower > 0) {
            System.out.println("Ork kicks " + randomSoldier.unitName);
        }
        ork.display();
        if (ork.healthPower > 0) {
            randomSoldier.display();
        }
    }
}


