package com.d.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RaghavGameTest {
    RaghavGame game = new RaghavGame();
    //0 20
    //1 20
    //1 10 2 10
    // Spares 5,5 and 1 18 times
    @Test

    void given20Rolls_checkAll0s() {
        rollMultipleTimes(0, 20);
        assertEquals(0, game.score());
    }

    @Test
    void given20Rolls_checkAll1s() {
        rollMultipleTimes(1, 20);
        assertEquals(20, game.score());
    }

    @Test
    void given20Rolls_check1s10TimesAnd2s10Times() {
        rollMultipleTimes(1, 10);
        rollMultipleTimes(2, 10);
        assertEquals(30, game.score());
    }

    @Test
    void given20Rolls_checkSpare() {
        rollASpare();
        rollMultipleTimes(1, 18);
        assertEquals(29, game.score());
    }

    @Test
    void given20Rolls_check2Spares() {
        rollASpare();
        rollASpare();
        rollMultipleTimes(1, 16);
        assertEquals(42, game.score());
    }

    @Test
    void given20Rolls_checkStrike() {
        rollAStrike();
        rollMultipleTimes(1, 18);
        assertEquals(30, game.score());
    }

    private void rollAStrike() {
        game.roll(10);
    }

    private void rollASpare() {
        rollMultipleTimes(5, 2);
    }

    private void rollMultipleTimes(int pinsKnockedDown, int noOfTimes) {
        for (int i = 0; i < noOfTimes; i++) {
            game.roll(pinsKnockedDown);
        }
    }

}
