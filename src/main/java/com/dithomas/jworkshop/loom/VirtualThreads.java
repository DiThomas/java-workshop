package com.dithomas.jworkshop.loom;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VirtualThreads {

    public void byExecutor() throws InterruptedException {
        Instant startTime = Instant.now();
        System.out.println("Starttime: " + startTime);
        
        int taskCount = 10_000;
        executeTasksByExecutor(taskCount, startTime);
    }

    private static void executeTasksByExecutor(final int taskCount, final Instant startTime) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(taskCount);
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        for (int i = 0; i < taskCount; i++) {
            executorService.submit(() -> {
                process();
                latch.countDown();
            });
        }

        latch.await();
        
        logExecutionTime(startTime);
        
        executorService.shutdown();
    }

    private static void logExecutionTime(final Instant startTime) {
        Instant endTime = Instant.now();
        System.out.println("Endtime: " + endTime + " Time took (in ms) to process: " + Duration.between(startTime, endTime).toMillis());
    }

    public static void process(){
        try {
            System.out.println("Retrieving fake data");
            Thread.sleep(3000L);
            System.out.println("Doing some SQL");
            Thread.sleep(3000L);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}