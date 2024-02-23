package com.dithomas.jworkshop.amber;

/**
 * The PatternMatchingForSwitch class provides a method for processing different types of messages.
 */
public class PatternMatchingForSwitch {

    //FIXME: Rewrite this using the Records and patternMatching
    public String processMessage(Object message) {
        if (message instanceof SoapMessage soapMessage) {
            return "Processing SOAP message: " + soapMessage.content();
        } else if (message instanceof RestMessage restMessage) {
            return "Processing REST message: " + restMessage.content();
        } else if (message instanceof JMSMessage jmsMessage) {
            return "Processing JMS message: " + jmsMessage.content();
        } else if (message instanceof MessageInABottle bottleMessage && isBottleInOcean(bottleMessage)) {
            /*
               Hint: the additional isBottleInOcean boolean can be used in a switch statement using:
               case x when <predicate>: ..
               case y: ..
             */
            return "Processing message in a bottle: " + bottleMessage.content();
        } else if (message instanceof MessageInABottle bottle) {
            return "Message in a bottle cracked due to lack of ocean: " + bottle.content();
        } else {
            return "I did nothing";
        }
    }


    /**
     * Checks if the content of a message in a bottle contains the word "ocean".
     *
     * @param bottleMessage The message in a bottle to check.
     * @return {@code true} if the content of the bottle message contains "ocean", {@code false} otherwise.
     */
    private static boolean isBottleInOcean(final MessageInABottle bottleMessage) {
        return bottleMessage.content().contains("ocean");
    }
}

record SoapMessage(String content) {
}

record MessageInABottle(String content) {
}

record RestMessage(String content) {
}

record JMSMessage(String content) {
}