package com.dithomas.jworkshop.core;

import java.util.List;
import java.util.SequencedCollection;
import java.util.SequencedMap;

public class SequencedCollections {


    public SequencedCollection<Integer> orderCollectionCountingDown(List<Integer> listOfNumbers){
        return listOfNumbers.stream()
            .sorted()
            .toList()
            .reversed();
    }

    public SequencedCollection<Integer> addAtStartOfList(List<Integer> listOfNumbers, Integer numberToAdd){
        listOfNumbers.addFirst(numberToAdd);
        return listOfNumbers;
    }

    public SequencedMap<Integer, Integer> addAtStartOfMap(SequencedMap<Integer, Integer> mapOfNumbers, Integer numberToAdd){
        mapOfNumbers.putFirst(numberToAdd, numberToAdd);
        return mapOfNumbers;
    }


}
