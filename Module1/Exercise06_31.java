package Module1;

import java.util.Scanner;

public class Exercise06_31 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a credit card number as a long integer: ");
        long number = input.nextLong();

        if (isValid(number)) {
            System.out.println(number + " is valid");
        }
        else {
            System.out.println(number + " is invalid");
        }

        input.close();
    }

    public static boolean isValid(long number) {
        int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);

        // Check length, starting digits, and whether the total is divisible by 10
        if (getSize(number) < 13 || getSize(number) > 16) {
            return false;
        }

        if (!(prefixMatched(number, 4) || prefixMatched(number, 5) ||
                prefixMatched(number, 37) || prefixMatched(number, 6))) {
            return false;
        }

        return total % 10 == 0;
    }

    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;

        // Start with the second digit from the right
        number = number / 10;

        while (number > 0) {
            int digit = (int)(number % 10);
            digit = digit * 2;

            // If the doubled digit has two digits, getDigit adds them together
            sum = sum + getDigit(digit);

            number = number / 100;
        }

        return sum;
    }

    public static int getDigit(int number) {
        if (number < 10) {
            return number;
        }
        else {
            return number / 10 + number % 10;
        }
    }

    public static int sumOfOddPlace(long number) {
        int sum = 0;

        // Add every other digit starting from the far right
        while (number > 0) {
            int digit = (int)(number % 10);
            sum = sum + digit;

            number = number / 100;
        }

        return sum;
    }

    public static boolean prefixMatched(long number, int d) {
        long prefix = getPrefix(number, getSize(d));

        if (prefix == d) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int getSize(long d) {
        int count = 0;

        while (d > 0) {
            count++;
            d = d / 10;
        }

        return count;
    }

    public static long getPrefix(long number, int k) {
        int size = getSize(number);

        if (size <= k) {
            return number;
        }

        // Remove digits from the right until only the first k digits are left
        for (int i = 0; i < size - k; i++) {
            number = number / 10;
        }

        return number;
    }
}