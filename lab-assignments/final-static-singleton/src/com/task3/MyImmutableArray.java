package com.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyImmutableArray {
    private final ArrayList<Integer> immutableArray;

    public MyImmutableArray(ArrayList<Integer> immutableArray) {
        this.immutableArray = immutableArray;
    }

    public List<Integer> getList() {
        return Collections.unmodifiableList(immutableArray);
    }

    public ArrayList<Integer> getArrayList() {
        return new ArrayList<>(immutableArray);
        // We can also use the clone() method but there will be a
        // "unchecked cast" warning
    }
}
