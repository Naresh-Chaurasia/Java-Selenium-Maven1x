package com.framework;

public class Read2DArray03 {
    public static void main(String[] args) {
        String[][] data = {
                { "Alice", "30", "New York" },
                { "Bob", "25", "London" },
                { "Charlie", "28", "Paris" }
        };

        // Display the values
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
