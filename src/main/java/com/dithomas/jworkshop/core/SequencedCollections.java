package com.dithomas.jworkshop.core;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SequencedCollections {


    public Collection<Integer> orderCollectionCountingDown(List<Integer> listOfNumbers){
        return listOfNumbers.stream()
            .sorted(Collections.reverseOrder())
            .collect(Collectors.toList());
    }

    public Collection<Integer> addAtStartOfList(List<Integer> listOfNumbers, Integer numberToAdd){
        listOfNumbers.add(0,numberToAdd);
        return listOfNumbers;
    }

    public Map<Integer, Integer> addAtStartOfMap(Map<Integer, Integer> mapOfNumbers, Integer numberToAdd){
        mapOfNumbers.put(numberToAdd, numberToAdd);
        return mapOfNumbers;
    }


}
