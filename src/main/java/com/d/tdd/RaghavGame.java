package com.d.tdd;

class RaghavGame {
    int[] rolls = new int[21];
    int rollIndex = 0;

    public void roll(int pinsKnockedDown) {
        rolls[rollIndex++] = pinsKnockedDown;
    }

    public int score() {
        int score = 0;
        int rollsIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rolls[rollsIndex])) {
                score += 10 + bonusForStrike(rollsIndex);
                rollsIndex += 1;

            } else if (isSpare(rollsIndex)) {
                score += 10 + bonusForSpare(rollsIndex);
                rollsIndex += 2;
            } else {
                score += rolls[rollsIndex] + rolls[rollsIndex + 1];
                rollsIndex += 2;

            }
        }
        return score;
    }

    private int bonusForSpare(int rollsIndex) {
        return rolls[rollsIndex + 2];
    }

    private int bonusForStrike(int rollsIndex) {
        return rolls[rollsIndex + 1] + rolls[rollsIndex + 2];
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    private boolean isSpare(int rollsIndex) {
        return rolls[rollsIndex] + rolls[rollsIndex + 1] == 10;
    }
}
