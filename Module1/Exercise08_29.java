package Module1;

import java.util.Scanner;

public class Exercise08_29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[][] m1 = new int[3][3];
        int[][] m2 = new int[3][3];

        // Get the values for the first 3 by 3 array
        System.out.print("Enter m1 (a 3 by 3 matrix) row by row: ");

        for (int row = 0; row < m1.length; row++) {
            for (int col = 0; col < m1[row].length; col++) {
                m1[row][col] = input.nextInt();
            }
        }

        // Get the values for the second 3 by 3 array
        System.out.print("Enter m2 (a 3 by 3 matrix) row by row: ");

        for (int row = 0; row < m2.length; row++) {
            for (int col = 0; col < m2[row].length; col++) {
                m2[row][col] = input.nextInt();
            }
        }

        // Check if the arrays match
        if (equals(m1, m2)) {
            System.out.println("The two arrays are identical");
        }
        else {
            System.out.println("The two arrays are not identical");
        }

        input.close();
    }

    public static boolean equals(int[][] m1, int[][] m2) {
        // Compare each value in the same position
        for (int row = 0; row < m1.length; row++) {
            for (int col = 0; col < m1[row].length; col++) {
                if (m1[row][col] != m2[row][col]) {
                    return false;
                }
            }
        }

        // If nothing was different, then they are identical
        return true;
    }
}