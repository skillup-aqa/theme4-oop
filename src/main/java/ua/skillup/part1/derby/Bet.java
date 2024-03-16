package ua.skillup.part1.derby;

public class Bet {
    private double amount;
    private String horseName;
    private double coefficient;

    public Bet(double amount, String horseName, double coefficient) {
        this.amount = amount;
        this.horseName = horseName;
        this.coefficient = coefficient;
    }

    public String  getHorseName() {
        return horseName;
    }

    public double getAmount() {
        return amount;
    }

    public double calculatePrice() {
        return amount * coefficient;
    }
}
