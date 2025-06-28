package com.framework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTest05 {

    static List<Arguments> providePersonData() {

        // Map -> List
        // data.add(Arguments.of("key", "New York"));
        List<Arguments> data = new ArrayList<Arguments>();
        data.add(Arguments.of("Alice", 30, "New York"));
        data.add(Arguments.of("Bob", 25, "London"));
        data.add(Arguments.of("Charlie", 28, "Paris"));
        return data;
    }

    @ParameterizedTest
    @MethodSource("providePersonData")
    void testPersonData(String name, int age, String city) {
        assertNotNull(name);
        assertTrue(age > 0);
        assertNotNull(city);
        System.out.println(name + " | " + age + " | " + city);
    }

    static Object[][] providePersonDataObjects() {
        return new Object[][] {
                { "Alice", 30, "New York" },
                { "Bob", 25, "London" },
                { "Charlie", 28, "Paris" }
        };
    }

    @ParameterizedTest
    @MethodSource("providePersonDataObjects")
    void testPersonDataObjects(String name, int age, String city) {
        assertNotNull(name);
        assertTrue(age > 0);
        assertNotNull(city);
        System.out.println(name + " | " + age + " | " + city);
    }
}