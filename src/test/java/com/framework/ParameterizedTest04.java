package com.framework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTest04 {

    int count = 0;

    static List<String> provideNames() {
        List<String> data = new ArrayList<String>();
        data.add("Alice");
        data.add("Bob");
        data.add("Charlie");
        return data;
    }

    // The testName method will be called three times—once for each element in the
    // list ("Alice", "Bob", "Charlie").
    // However, the value of count will always be 1 in each test execution, because
    // JUnit creates a new instance of ArrayDataParameterizedTest1 for each test
    // method invocation.
    // So, count is initialized to 0 each time, incremented to 1, and then the test
    // ends.
    @ParameterizedTest
    @MethodSource("provideNames")
    void testName(String name) {

        count = count + 1;
        System.out.println("Test count: " + count);

        assertNotNull(name);
        System.out.println(name);
    }
}