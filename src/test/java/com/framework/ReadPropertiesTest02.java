package com.framework;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

public class ReadPropertiesTest02 {

    @Test
    void testReadPropertiesFile() {

        String filePath = System.getProperty("user.dir") + "/src/test/resources/sample.properties";

        Properties props = new Properties();

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(filePath);
            props.load(fis);

            System.out.println(props.getProperty("username"));

            // Example assertions (adjust keys as per your properties file)
            assertEquals("admin", props.getProperty("username"));
            assertEquals("secret", props.getProperty("password"));

            // Print all properties
            for (Object key : props.keySet()) {
                Object value = props.get(key);
                System.out.println(key + " = " + value);
            }
        } catch (IOException e) {
            fail("Error reading properties file: " + e.getMessage());
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }
}