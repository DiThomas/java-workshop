package com.dithomas.jworkshop.amber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecordPatternsTest {


    @Test
    public void testDetermineFootballClubType() {
        RecordPatterns recordPatterns = new RecordPatterns();
        FootballClub testClub = new FootballClub("FC Knudde", 1, new ClubManager("Test ClubManager", 42));
        String result = recordPatterns.determineClubType(testClub);

        // Verifying the club type for FootballClub
        assertEquals("FOOTBALLCLUB", result);
    }

    @Test
    public void testDetermineFanClubType() {
        RecordPatterns recordPatterns = new RecordPatterns();
        FanClub testFanClub = new FanClub("In Frans we trust", "Frans Bauer");
        String result = recordPatterns.determineClubType(testFanClub);

        // Verifying the club type for FanClub
        assertEquals("FANCLUB", result);
    }

    @Test
    public void testDetermineOtherClubType() {
        RecordPatterns recordPatterns = new RecordPatterns();
        String result = recordPatterns.determineClubType(new Object());

        // Verifying the club type for other types of club
        assertNull(result);
    }
}