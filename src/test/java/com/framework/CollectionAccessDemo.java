package com.framework;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class CollectionAccessDemo {

    @Test
    void testListAccess() {
        List<String> list = new ArrayList<String>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Access using for-each
        StringBuilder sb = new StringBuilder();
        for (String item : list) {
            sb.append(item).append(" ");
        }
        assertEquals("Apple Banana Cherry ", sb.toString());

        // Access using iterator
        Iterator<String> it = list.iterator();
        assertEquals("Apple", it.next());
        assertEquals("Banana", it.next());
        assertEquals("Cherry", it.next());
    }

    @Test
    void testSetAccess() {
        Set<String> set = new HashSet<String>();
        set.add("Red");
        set.add("Green");
        set.add("Blue");

        // Access using for-each
        int count = 0;
        for (String color : set) {
            assertNotNull(color);
            count++;
        }
        assertEquals(3, count);

        // Access using iterator
        Iterator<String> it = set.iterator();
        int iterCount = 0;
        while (it.hasNext()) {
            assertNotNull(it.next());
            iterCount++;
        }
        assertEquals(3, iterCount);
    }

    @Test
    void testMapAccess() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);

        // Access entries using for-each
        int sum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            assertNotNull(entry.getKey());
            assertNotNull(entry.getValue());
            sum += entry.getValue();
        }
        assertEquals(6, sum);

        // Access keys using for-each
        int keyCount = 0;
        for (String key : map.keySet()) {
            assertTrue(map.containsKey(key));
            keyCount++;
        }
        assertEquals(3, keyCount);

        // Access values using for-each
        int valueSum = 0;
        for (Integer value : map.values()) {
            valueSum += value;
        }
        assertEquals(6, valueSum);

        // Access entries using iterator
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        int iterSum = 0;
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            iterSum += entry.getValue();
        }
        assertEquals(6, iterSum);
    }
}