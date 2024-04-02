package ua.skillup.part2.RPG;

public class Game {

    public static void main(String[] args){
        GameDriver game = new GameDriver();
        game.raund(game.magician);
        game.raund(game.warrior);
        game.raund(game.archer);
        game.raund(game.archer);

        game.magician.display();
    }
}
