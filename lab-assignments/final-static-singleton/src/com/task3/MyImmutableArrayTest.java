package com.task3;

import java.util.ArrayList;
import java.util.Arrays;

public class MyImmutableArrayTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 3, 5 ,7));
        MyImmutableArray myImmutableArray = new MyImmutableArray(arrayList);

        var immutableList = myImmutableArray.getList();
        immutableList.add(3); // expect runtime error
        System.out.println(myImmutableArray.getList());

        var immutableArrayList = myImmutableArray.getArrayList();
        immutableArrayList.add(3);
        System.out.println(myImmutableArray.getArrayList());
    }
}
