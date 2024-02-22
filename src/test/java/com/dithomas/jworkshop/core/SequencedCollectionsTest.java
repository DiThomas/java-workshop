package com.dithomas.jworkshop.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SequencedCollection;

import org.junit.jupiter.api.Test;

public class SequencedCollectionsTest {

    public static final SequencedCollections seqCollections = new SequencedCollections();

    // Testing the orderCollectionCountingDown method of the SequencedCollections class
    @Test
    public void testOrderCollectionCountingDown() {
        // Initial list of numbers
        List<Integer> initList = Arrays.asList(1, 3, 2, 5, 4);
        SequencedCollection<Integer> result = seqCollections.orderCollectionCountingDown(initList);

        // Expected result of sorting in descending order
        SequencedCollection<Integer> expectedResult = Arrays.asList(5, 4, 3, 2, 1);
        
        // Assert that the results match
        assertEquals(expectedResult, result);
    }

    /**
     * The method under test is addAtStartOfList.
     * This test validates if the number is added correctly at the start of the list.
     */
    @Test
    public void testAddAtStartOfList_withNonEmptyList() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        SequencedCollection<Integer> result = seqCollections.addAtStartOfList(numbers, 1);
        assertEquals(1, result.getFirst());
    }

    /**
     * The method under test is addAtStartOfList.
     * This test validates if the number is added correctly at the start of an empty list.
     */
    @Test
    public void testAddAtStartOfList_withEmptyList() {
        List<Integer> numbers = new ArrayList<>();
        SequencedCollection<Integer> result = seqCollections.addAtStartOfList(numbers, 1);
        assertEquals(1, result.getFirst());
    }

    /**
     * This method tests 'addAtStartOfMap' method
     * of SequencedCollections class. The method is supposed to add
     * an Integer to the start of a SequencedMap.
     */
    @Test
    void testAddAtStartOfMap() {
        LinkedHashMap<Integer, Integer> sourceMap = new LinkedHashMap<>() {
            {
                put(1, 1);
                put(2, 2);
                put(3, 3);
            }
        };

        LinkedHashMap<Integer, Integer> expectedMap = new LinkedHashMap<>() {
            {
                put(0, 0);
                put(1, 1);
                put(2, 2);
                put(3, 3);
            }
        };

        LinkedHashMap<Integer, Integer> resultMap = new LinkedHashMap<>(seqCollections.addAtStartOfMap(sourceMap, 0));

        assertEquals(expectedMap, resultMap);
    }

}