package com.dithomas.jworkshop.amber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * The PatternMatchingForSwitchTest class provides unit tests for the PatternMatchingForSwitch class.
 */
public class PatternMatchingForSwitchTest {
    @Test
    void testProcessMessage_SoapMessage() {
        // arrange
        var patternMatching = new PatternMatchingForSwitch();
        var soapMessage = new SoapMessage("Hello SOAP world");
      
        // act
        var result = patternMatching.processMessage(soapMessage);
      
        // assert
        assertEquals("Processing SOAP message: Hello SOAP world", result);
    }
    
    @Test
    void testProcessMessage_RestMessage() {
        // arrange
        var patternMatching = new PatternMatchingForSwitch();
        var restMessage = new RestMessage("Hello REST world");
      
        // act
        var result = patternMatching.processMessage(restMessage);
       
        // assert
        assertEquals("Processing REST message: Hello REST world", result);
    }
   
    @Test
    void testProcessMessage_JMSMessage() {
        // arrange
        var patternMatching = new PatternMatchingForSwitch();
        var jmsMessage = new JMSMessage("Hello JMS world");
      
        // act
        var result = patternMatching.processMessage(jmsMessage);
      
        // assert
        assertEquals("Processing JMS message: Hello JMS world", result);
    }
    
    @Test
    void testProcessMessage_MessageInABottle_InOcean() {
        // arrange
        var patternMatching = new PatternMatchingForSwitch();
        var bottleMessage = new MessageInABottle("Hello ocean");
      
        // act
        var result = patternMatching.processMessage(bottleMessage);
      
        // assert
        assertEquals("Processing message in a bottle: Hello ocean", result);
    }

    @Test
    void testProcessMessage_MessageInABottle_OutsideOcean() {
        // arrange
        var patternMatching = new PatternMatchingForSwitch();
        var bottleMessage = new MessageInABottle("Hello message");
      
        // act
        var result = patternMatching.processMessage(bottleMessage);
      
        // assert
        assertEquals("Message in a bottle cracked due to lack of ocean: Hello message", result);
    }

    @Test
    void testProcessMessage_Default() {
        // arrange
        var patternMatching = new PatternMatchingForSwitch();
      
        // act
        var result = patternMatching.processMessage(new Object());
      
        // assert
        assertEquals("I did nothing", result);
    }
}