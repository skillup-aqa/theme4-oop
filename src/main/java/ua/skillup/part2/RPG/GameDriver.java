package ua.skillup.part2.RPG;

import java.util.Scanner;

public class GameDriver {

    private boolean isQuit = false;
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
                (archer.isDead() ? "" : ("Archer 'a' has " + archer.kickPower + " kick power. 'q' to quit")));
        char selected = scanner.next().charAt(0);
        if (!warrior.isDead() && (selected == 'w' || selected == 'W')) {
            this.kicker = warrior;
        } else if (!magician.isDead() && (selected == 'm' || selected == 'M')) {
            this.kicker = magician;
        } else if (!archer.isDead() && (selected == 'a' || selected == 'A')) {
            this.kicker = archer;
        } else if (selected == 'q' || selected == 'Q') {
            isQuit = true;
        } else if (warrior.isDead() && magician.isDead() && archer.isDead()) {
            System.out.println("Wou lose");
        } else {
            selectSoldier();
        }
    }


    public void kickOrk(Unit kicker, Ork kicked) {
        int minusHealth = kicker.kickPower;
        if (kicked.isPoisoned && kicked.unitName.equals("Ork")) {
            minusHealth = kicker.kickPower + kicker.kickPower / 2;
            kicked.setPoisoned(false);
        }
        kicked.changeHealth(minusHealth);
        if (kicker.unitName.equals("Archer")) {
            kicked.setPoisoned(true);
        }
        if (kicker.unitName.equals("Magician")) {
            magician.magicianMadeKick();
        }
    }

    public void kickSoldier(Ork kicker, Unit kicked) {
        int minusHealth = kicker.kickPower;
        kicked.changeHealth(minusHealth);
    }

    public void round() {
        selectSoldier();
        if (!isQuit) {
            magician.magicianAddCounter();
            do {
                randomSoldier = arrayOfSoldiers[(int) (Math.random() * 3)];
                if (!randomSoldier.isDead()) {
                    break;
                }

            } while (true);

            kickOrk(kicker, ork);
            if (ork.healthPower > 0) {
                kickSoldier(ork, randomSoldier);
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

    public static void main(String[] args) {
        GameDriver game = new GameDriver();
        while (true) {
            if (game.ork.isDead()) {
                System.out.println("You WIN!!!");
                break;

            } else if (game.magician.isDead() && game.warrior.isDead() && game.archer.isDead()) {
                System.out.println("You Lose");
                break;
            } else if (game.isQuit) {
                System.out.println("Quit the game");
                break;
            } else {
                game.round();
            }
        }
    }
}


