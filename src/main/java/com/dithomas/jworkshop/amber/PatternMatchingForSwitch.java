package com.dithomas.jworkshop.amber;

/**
 * The PatternMatchingForSwitch class provides a method for processing different types of messages.
 */
public class PatternMatchingForSwitch {

    public String processMessage(Object message) {
        return switch (message) {
            case SoapMessage soapMessage -> "Processing SOAP message: " + soapMessage.content();
            case RestMessage restMessage -> "Processing REST message: " + restMessage.content();
            case JMSMessage jmsMessage -> "Processing JMS message: " + jmsMessage.content();
            case MessageInABottle bottleMessage
                when isBottleInOcean(bottleMessage) -> "Processing message in a bottle: " + bottleMessage.content();
            case MessageInABottle bottle -> "Message in a bottle cracked due to lack of ocean: " + bottle.content();
            default -> "I did nothing";
        };
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