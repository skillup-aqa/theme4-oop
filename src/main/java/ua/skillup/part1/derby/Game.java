package ua.skillup.part1.derby;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Game {
    private final Horse[] horses = {
            new Horse("Maverick"),
            new Horse("Samson"),
            new Horse("Apollo"),
    };
    private final Player player = new Player(1000.0);

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        String greeting = """
                ===== Welcome to the Derby! =====
                You have 1000.0 to start with.
                Place your bets!
                """;

        System.out.println(greeting);

        while (true) {
            Bet bet = requestBet();

            if (bet == null) {
                System.out.println("Your balance is " + player.getBalance() + " now.");
                System.out.println("Thanks for the game! Goodbye!");
                break;
            }

            Horse winner = runRound();
            if (winner.getName() == bet.getHorseName()) {
                System.out.println("Your horse " + winner.getName() + " won! Congratulations!");
                player.setBalance(MathUtils.round(player.getBalance() + bet.calculatePrice(), 2));
            } else {
                System.out.println("You horse " + bet.getHorseName() + " lost to " + winner.getName() + " :(");
                player.setBalance(MathUtils.round(player.getBalance() - bet.getAmount(), 2));
            }

            System.out.println();

            if (player.getBalance() == 0) {
                System.out.println("You're broke! Game over :( Better luck next time!");
                break;
            }
        }
    }

    private Bet requestBet() {
        System.out.println("===== Getting a bet =====");
        System.out.println("Your balance is " + player.getBalance() + " now.");
        printHorses();

        double betValue;
        while (true) {
            System.out.println("Input your bet (should not be greater then your budget), 0 to skip and -1 to quit: ");
            betValue = scanner.nextDouble();

            if (betValue == -1) {
                return null;
            }

            if (betValue == 0) {
                return new Bet(0, "", 0);
            }

            if (betValue < -1) {
                System.out.println("Invalid input");
                continue;
            }

            if (betValue <= player.getBalance()) {
                System.out.println("The bet of " + betValue + " is accepted");
                break;
            }

            System.out.println("You don't have enough money, select a smaller bet");
        }

        int horseNumber;
        while (true) {
            System.out.println("Select a horse number (from 1 to " + horses.length + "): ");
            horseNumber = scanner.nextInt();

            if (horseNumber > 0 &&  horseNumber <= horses.length) {
                break;
            }

            System.out.println("Invalid input, try again");
        }

        Horse selectedHorse = horses[horseNumber - 1];
        System.out.println("You selected " + selectedHorse.getName() + " with coefficient " + selectedHorse.calculateCoefficient() + " to win");
        return new Bet(betValue, selectedHorse.getName(), selectedHorse.calculateCoefficient());
    }

    private void printHorses() {
        System.out.println("The horses are:");
        for (int i = 0; i < horses.length; i++) {
            System.out.println(" #" + (i + 1) + ": " + horses[i].getName() + " with coefficient " + horses[i].calculateCoefficient());
        }
    }

    private Horse runRound() {
        System.out.println();
        System.out.println("===== Running the race =====");

        Result[] results = new Result[horses.length];
        for (int i = 0; i < results.length; i++) {
            results[i] = new Result(horses[i], horses[i].getChances() * Math.random());
        }
        sortResults(results);
        printResults(results);

        for (int i = 0; i < results.length; i++) {
            results[i].getHorse().updateChances(i + 1, results.length);
        }
        
        return results[0].getHorse();
    }

    private void sortResults(Result[] results) {
        for (int i = 0; i < results.length; i++) {
            for (int j = i + 1; j < results.length; j++) {
                if (results[i].getResult() < results[j].getResult()) {
                    Result temp = results[i];
                    results[i] = results[j];
                    results[j] = temp;
                }
            }
        }
    }

    private void printResults(Result[] results) {
        System.out.println("Race completed with the following results: ");
        for (int i = 0; i < results.length; i++) {
            System.out.println(" #" + (i + 1) + ": " + results[i].getHorse().getName() + " finished with result " + results[i].getResult());
        }
    }
}
