package com.dithomas.jworkshop.amber;


public class RecordPatterns {

    public String determineClubType(Object club){
        if (club instanceof FootballClub(var clubName, var ranking, ClubManager cm)){
            System.out.println("Club name: " + clubName);
            System.out.println("Ranking: " + ranking);
            System.out.println("Club Manager: " + cm.name());
            return "FOOTBALLCLUB";
        }else if (club instanceof FanClub(var clubName, var idol)){
            System.out.println("Club name: " + clubName);
            System.out.println("Idolizing person: " + idol);
            return "FANCLUB";
        }else {
            return null;
        }
    }
}

record FootballClub(String name, int ranking, ClubManager clubManager) { }
record FanClub(String name, String idol){}
record ClubManager(String name, int age){}
