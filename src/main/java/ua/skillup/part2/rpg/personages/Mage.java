package ua.skillup.part2.rpg.personages;

public class Mage extends Personage {

    private final Lightning lightning = new Lightning();

    public Mage() {
        this.name = "Mage";
        this.health = 50;
        this.damage = 80;
    }

    @Override
    public int attack() {
        return this.lightning.strike();
    }

    @Override
    public void displayStats() {
        System.out.println(this.name + " has " + health + " health and " + damage + " damage. " + this.lightning.status());
    }

    @Override
    public void onRoundEnd() {
        if (this.lightning.countdownToLightning > 0) {
            this.lightning.decreaseCountDown();
        }
    }

    private class Lightning {
        private final int DAMAGE = 80;
        private final int ROUNDS_TO_LIGHTNING = 3;

        private int countdownToLightning = -1;

        public void decreaseCountDown() {
            this.countdownToLightning--;
        }

        public int strike() {
            if (this.countdownToLightning == 0) {
                this.countdownToLightning = -1;
                return this.DAMAGE;
            }

            if (this.countdownToLightning == -1) {
                this.countdownToLightning = this.ROUNDS_TO_LIGHTNING;
            }

            System.out.println("Mage is preparing to strike with lightning bolt! Remaining rounds: " + this.countdownToLightning);
            return 0;
        }

        public String status() {
            if (this.countdownToLightning == 0) {
                return "Lightning bolt is ready to strike!";
            }
            if (this.countdownToLightning == -1) {
                return "Lightning bolt is not charging";
            }

            return "Lightning bolt is charging. Remaining rounds: " + this.countdownToLightning;
        }
    }
}
