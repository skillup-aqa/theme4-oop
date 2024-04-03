package ua.skillup.part2.RPG;

import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        GameDriver game = new GameDriver();
        while (2 > 1) {
            if (game.ork.isDead()) {
                System.out.println("You WIN!!!");
                break;

            } else if (game.magician.isDead() && game.warrior.isDead() && game.archer.isDead()) {

                System.out.println("You Lose");
                break;
            } else {

                game.round();
            }
        }
    }
}
