package se.hernebring.day2;

public enum RockPaperScissors {
    ROCK(1), PAPER(2), SCISSORS(3);

    private final int value;

    RockPaperScissors(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}
