package com.c.refactoring.movie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaghavMovieTest {
    @Test
    public void testIsValidRating() {    	
        assertTrue(new RaghavMovieRefactored("B1").isValidRating());
        assertTrue(new RaghavMovieRefactored("B2").isValidRating());
        assertTrue(new RaghavMovieRefactored("B3").isValidRating());
        assertTrue(new RaghavMovieRefactored("B4").isValidRating());
        assertFalse(new RaghavMovieRefactored("B5").isValidRating());
        assertFalse(new RaghavMovieRefactored("B10").isValidRating());

        assertTrue(new RaghavMovieRefactored("A10").isValidRating());
        assertTrue(new RaghavMovieRefactored("A11").isValidRating());
        assertTrue(new RaghavMovieRefactored("A99").isValidRating());

        assertFalse(new RaghavMovieRefactored("A1").isValidRating());
        assertFalse(new RaghavMovieRefactored("A2").isValidRating());
        assertFalse(new RaghavMovieRefactored("A100").isValidRating());
        assertFalse(new RaghavMovieRefactored("A786").isValidRating());
    }

}