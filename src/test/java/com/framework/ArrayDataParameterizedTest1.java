package com.framework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayDataParameterizedTest1 {

    // Provide 2D array data as a list of Arguments (no streams)
    static List<Arguments> provideArrayData() {
        List<Arguments> data = new ArrayList<Arguments>();
        data.add(Arguments.of("Alice", 30, "New York"));
        data.add(Arguments.of("Bob", 25, "London"));
        data.add(Arguments.of("Charlie", 28, "Paris"));
        return data;
    }

    @ParameterizedTest
    @MethodSource("provideArrayData")
    void testArrayData(String name, int age, String city) {
        assertNotNull(name);
        assertTrue(age > 0);
        assertNotNull(city);
        System.out.println(name + " | " + age + " | " + city);
    }
}