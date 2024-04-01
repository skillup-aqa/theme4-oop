package ua.skillup.part2.rpg;

import ua.skillup.part2.rpg.personages.*;

import java.util.Scanner;

public class RpgGame {
    public void start() {
        System.out.println("Game started");

        Orc orc = new Orc();
        Warrior warrior = new Warrior();
        Archer archer = new Archer();
        Mage mage = new Mage();

        Personage[] party = {warrior, archer, mage};
        Personage[] all = {warrior, archer, mage, orc};

        while (true) {

            System.out.println("===== Round start =====");

            orc.displayStats();
            Personage target = orc.selectTargetFrom(party);
            target.receiveDamageOf(orc.attack(target.getName()));
            if (target.isDead()) {
                party = removeDeadHero(party, target);
            }

            if (party.length == 0) {
                System.out.println("All heroes are dead, orc wins :(");
                return;
            }

            Personage hero = playerSelectsHero(party);
            orc.receiveDamageOf(hero.attack());
            if (hero instanceof Archer) {
                orc.poisoned();
            }

            if (orc.isDead()) {
                System.out.println("Orc is dead, heroes win!");
                return;
            }

            for (Personage personage : all) {
                personage.onRoundEnd();
            }

            System.out.println("===== Round end =====");
        }
    }


    private Personage[] removeDeadHero(Personage[] heroes, Personage deadHero) {
        Personage[] newHeroes = new Personage[heroes.length - 1];
        int i = 0;
        for (Personage hero : heroes) {
            if (hero != deadHero) {
                newHeroes[i++] = hero;
            }
        }
        return newHeroes;
    }

    private Personage playerSelectsHero(Personage[] heroes) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Select hero:");
        for (int i = 0; i < heroes.length; i++) {
            System.out.print((i + 1) + ". ");
            heroes[i].displayStats();
        }

        while (true) {
            int selectedHero = scanner.nextInt();
            if (selectedHero >= 1 && selectedHero <= heroes.length) {
                return heroes[selectedHero - 1];
            }
            System.out.println("Invalid hero number, try again");
        }
    }
}
