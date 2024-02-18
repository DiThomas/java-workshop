package com.dithomas.jworkshop.amber;

public class UnnamedVariablesAndPatterns {
    public String determineCarSwitch(Object car){
        return switch (car) {
            case Car(var name, RaceCar(var teamName, _), _) -> name +  " is a RaceCar by " + teamName +" that goes VROOM";
            case Car(var name, Sedan(var hasAirco), _)
                when hasAirco -> name + " is a Sedan with Airco";
            case Car(var name, Sedan _ , _) -> name + " is a Sedan with no Airco";
            default -> "I did nothing";
        };
    }

    public int tryParse(String value){
        try{
            return Integer.parseInt(value);
        } catch (NumberFormatException _){
            throw new IllegalArgumentException("You cant insert other characters than 0-9");
        }
    }

}


record Car(String name,Object type, Engine engine){}
record RaceCar(String teamName, String driver) { }
record Sedan(boolean hasAirco){}
record Engine(String name, String factory ){}
