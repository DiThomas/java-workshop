package com.dithomas.jworkshop.amber;


import java.util.regex.Pattern;

/**
 * RecordPatterns is released since Java 21,
 * with it, it's possible to write cleaner code where you can access the fields directly
 * This feature is build upon Java 16 released Pattern Matching for instanceof
 */
public class RecordPatterns {

    public String determineClubType(Object club) {
        /**
         * FIXME: This instanceof can be rewritten so that record values are deconstructed
         * Hint: FootballClub itself can be written to a Pattern, which can be then accessed directly
         */
        //(Hints:
        if (club instanceof FootballClub) {
            //Prior to Java 16 this ugly cast is always needed
            var fc = (FootballClub)club;
            //Since Java 21 it is possible to access these fields as deconstructed values
            var clubName = fc.name();
            int ranking = fc.ranking();
            ClubManager clubManager = fc.clubManager();
            System.out.println("Club name: " + clubName);
            System.out.println("Ranking: " + ranking);
            System.out.println("Club Manager: " + clubManager.name());
            return "FOOTBALLCLUB";
        } else if (club instanceof FanClub fc) {
            var clubName = fc.name();
            var idol = fc.idol();
            System.out.println("Club name: " + clubName);
            System.out.println("Idolizing person: " + idol);
            return "FANCLUB";
        } else {
            return null;
        }

    }





}

record FootballClub(String name, int ranking, ClubManager clubManager) {
}
record FanClub(String name, String idol) {
}
record ClubManager(String name, int age) {
}
