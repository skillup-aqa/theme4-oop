package ua.skillup.part1.derby;

public class Result {
    private Horse horse;
    private double result;

    public Result(Horse horse, double result) {
        this.horse = horse;
        this.result = result;
    }

    public Horse getHorse() {
        return horse;
    }

    public double getResult() {
        return result;
    }
}
