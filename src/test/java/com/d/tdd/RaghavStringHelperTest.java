package com.d.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RaghavStringHelperTest {
    RaghavStringHelper helper = new RaghavStringHelper();
    //"ABCD" => "BCD", "AACD"=> "CD", "BACD"=>"BCD", "AAAA" => "AA", "MNAA"=>"MNAA"
    //Red
    //Green
    //Refactor
    @Test
    void givenString_replaceAInFirst2Positions() {
        assertEquals("BCD", helper.replaceAInFirst2Positions("ABCD"));
        assertEquals("CD", helper.replaceAInFirst2Positions("AACD"));
        assertEquals("BCD", helper.replaceAInFirst2Positions("BACD"));
        assertEquals("AA", helper.replaceAInFirst2Positions("AAAA"));
        assertEquals("MNAA", helper.replaceAInFirst2Positions("MNAA"));
        assertEquals("", helper.replaceAInFirst2Positions(""));
        assertEquals("", helper.replaceAInFirst2Positions("A"));
        assertEquals("", helper.replaceAInFirst2Positions("AA"));
        assertEquals("B", helper.replaceAInFirst2Positions("B"));
        assertEquals("BC", helper.replaceAInFirst2Positions("BC"));
    }

    //""=>false, "A"=>false, "AB"=>true, "ABC"=>false, "AAA"=>true, "ABCAB"=>true, "ABCDEBA"=>false
    @Test
    void givenString_checkIfFirst2AndLast2CharactersAreSame() {
        assertFalse(helper.areFirst2AndLast2CharactersAreSame(""));
        assertFalse(helper.areFirst2AndLast2CharactersAreSame("A"));
        assertTrue(helper.areFirst2AndLast2CharactersAreSame("AB"));
        assertFalse(helper.areFirst2AndLast2CharactersAreSame("ABC"));
        assertTrue(helper.areFirst2AndLast2CharactersAreSame("AAA"));
        assertTrue(helper.areFirst2AndLast2CharactersAreSame("ABCAB"));
        assertFalse(helper.areFirst2AndLast2CharactersAreSame("ABCDEBA"));
    }
}
