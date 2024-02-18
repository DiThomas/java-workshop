package com.dithomas.jworkshop.amber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnnamedVariablesAndPatternsTest {

    /**
     * This class is used to test the determineCar method of 
     * the UnnamedVariablesAndPatterns. The determineCar method finds
     * out the type of car based on the given parameters.
     *
     */

    @Test
    void testDetermineCarForRaceCar() {
        RaceCar raceCar = new RaceCar("Fast Fury", "Nicholas Goatifi");
        Car testCar = new Car("Test car", raceCar, new Engine("V22", "OpenJDK"));
        UnnamedVariablesAndPatterns unnamedVarPat = new UnnamedVariablesAndPatterns(); 

        String result = unnamedVarPat.determineCarSwitch(testCar);
        assertEquals("Test car is a RaceCar by Fast Fury that goes VROOM", result);
    }

    @Test
    void testDetermineCarForSedanWithAirco() {
        Sedan sedanWithAirco = new Sedan(true);
        Car testCar = new Car("Test car", sedanWithAirco, new Engine("1.2 Hybrid", "Germany"));
        UnnamedVariablesAndPatterns unnamedVarPat = new UnnamedVariablesAndPatterns(); 

        String result = unnamedVarPat.determineCarSwitch(testCar);
        assertEquals("Test car is a Sedan with Airco", result);
    }

    @Test
    void testDetermineCarForSedanWithoutAirco() {
        Sedan sedanWithoutAirco = new Sedan(false);
        Car testCar = new Car("Test car", sedanWithoutAirco, new Engine("1.2 Hybrid", "Germany"));
        UnnamedVariablesAndPatterns unnamedVarPat = new UnnamedVariablesAndPatterns(); 

        String result = unnamedVarPat.determineCarSwitch(testCar);
        assertEquals("Test car is a Sedan with no Airco", result);
    }

    @Test
    void testDetermineCarForDefaultCase() {
        Object defaultObject = new Object();

        UnnamedVariablesAndPatterns unnamedVarPat = new UnnamedVariablesAndPatterns(); 

        String result = unnamedVarPat.determineCarSwitch(defaultObject);
        assertEquals("I did nothing", result);
    }
}