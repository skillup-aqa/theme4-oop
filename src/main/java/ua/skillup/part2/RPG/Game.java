package ua.skillup.part2.RPG;

public class Game {

    public static void main(String[] args) {
        Warrior warrior = new Warrior();
        Archer archer = new Archer();
        Magician magician = new Magician();
        Ork ork = new Ork();


        warrior.display();
        archer.display();
        magician.display();
        ork.display();

    }
}
