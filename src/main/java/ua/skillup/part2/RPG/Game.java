package ua.skillup.part2.RPG;

public class Game {

    public static void main(String[] args) {
        GameDriver game = new GameDriver();
        game.round(game.archer);


        game.magician.display();
        game.ork.display();
    }
}
