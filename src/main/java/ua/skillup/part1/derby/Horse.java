package ua.skillup.part1.derby;

public class Horse {
    private final String name;
    private double chances;

    public Horse(String name) {
        this.name = name;
        this.chances = 0.5;
    }

    public String getName() {
        return name;
    }

    public double getChances() {
        return chances;
    }

    public double calculateCoefficient() {
        return MathUtils.round(1 / chances, 2);
    }

    public void updateChances(int place, int total) {
        if (place == 1) {
            chances += 0.05;
        }
        if (place == total) {
            chances -= 0.05;
        }
    }
}
