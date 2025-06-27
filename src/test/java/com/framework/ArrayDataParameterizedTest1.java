package com.framework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayDataParameterizedTest1 {

    int count = 0;

    static List<String> provideNames() {
        List<String> data = new ArrayList<String>();
        data.add("Alice");
        data.add("Bob");
        data.add("Charlie");
        return data;
    }

    @ParameterizedTest
    @MethodSource("provideNames")
    void testName(String name) {

        count = count + 1;
        System.out.println("Test count: " + count);

        assertNotNull(name);
        System.out.println(name);
    }
}