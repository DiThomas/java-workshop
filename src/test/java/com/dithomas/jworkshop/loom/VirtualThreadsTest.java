package com.dithomas.jworkshop.loom;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.Test;

public class VirtualThreadsTest {
    
      VirtualThreads virtualThreads = new VirtualThreads();
    @Test
    public void ShouldBeBelow10Seconds() {
       
        Instant start = Instant.now();
        try {
            virtualThreads.byExecutor();
        } catch (InterruptedException e) {
            e.printStackTrace();
            fail("Caught InterrudptedException: "+ e.getMessage());
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        long seconds = duration.getSeconds();
        assertTrue(seconds < 10);
       
    }
      
    
}