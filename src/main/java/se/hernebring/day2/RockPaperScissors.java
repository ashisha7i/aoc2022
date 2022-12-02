package se.hernebring.day2;

public enum RockPaperScissors {
    ROCK(1), PAPER(2), SCISSORS(3);

    private final int value;

    RockPaperScissors(int value) {
        this.value = value;
    }

    public static RockPaperScissors getFromZeroIndex(int diff) {
        RockPaperScissors[] options = RockPaperScissors.values();
        for(int i = 0; i < options.length; i++) {
            if(i == diff)
                return options[i];

        }
        return null;
    }

    int getValue() {
        return value;
    }
}
