package com.framework;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterizedTest04 {

    static List<String> provideNames1() {
        List<String> data = new ArrayList<String>();
        data.add("Alice");
        data.add("Bob");
        data.add("Charlie");
        return data;
    }

    static List<String> provideNames2() {
        List<String> data = new ArrayList<String>();
        data.add("Alice2");
        data.add("Bob2");
        data.add("Charlie2");
        return data;
    }

    @ParameterizedTest
    @MethodSource("provideNames1")
    void testName1(String name) {

        assertNotNull(name);
        System.out.println(name);
    }

    @ParameterizedTest
    @MethodSource("provideNames2")
    void testName2(String name) {

        assertNotNull(name);
        System.out.println(name);
    }
}