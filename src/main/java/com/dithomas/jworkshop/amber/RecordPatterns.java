package com.dithomas.jworkshop.amber;


public class RecordPatterns {

    public String determineClubType(Object club){
//        The RecordPattern accepts forms of nesting, but in this my personal preference is not using it to recognize certain structure
//        if (club instanceof FootballClub(var clubName, var ranking, ClubManager(var name, var age))){
        if (club instanceof FootballClub(var clubName, var ranking, var clubManager)){
            System.out.println("Club name: " + clubName);
            System.out.println("Ranking: " + ranking);
            System.out.println("Club Manager: " + clubManager.name());
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
