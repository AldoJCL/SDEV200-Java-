package Module4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Exercise20_11 {

    public static void main(String[] args) {
        // Make sure the user provided a file name
        if (args.length != 1) {
            System.out.println("Usage: java Exercise20_11 filename");
            return;
        }

        File file = new File(args[0]);

        try {
            Scanner input = new Scanner(file);

            // Stack stores opening grouping symbols
            Stack<Character> stack = new Stack<>();

            while (input.hasNextLine()) {
                String line = input.nextLine();

                // Check each character in the line
                for (int i = 0; i < line.length(); i++) {
                    char ch = line.charAt(i);

                    if (ch == '(' || ch == '{' || ch == '[') {
                        stack.push(ch);
                    }
                    else if (ch == ')' || ch == '}' || ch == ']') {
                        // If stack is empty, there is no matching opening symbol
                        if (stack.isEmpty()) {
                            System.out.println("Incorrect grouping pairs");
                            input.close();
                            return;
                        }

                        char opening = stack.pop();

                        if (!isMatchingPair(opening, ch)) {
                            System.out.println("Incorrect grouping pairs");
                            input.close();
                            return;
                        }
                    }
                }
            }

            input.close();

            // If stack is empty, all opening symbols were matched
            if (stack.isEmpty()) {
                System.out.println("Correct grouping pairs");
            }
            else {
                System.out.println("Incorrect grouping pairs");
            }

        }
        catch (FileNotFoundException ex) {
            System.out.println("File not found: " + args[0]);
        }
    }

    // Checks whether opening and closing symbols match
    public static boolean isMatchingPair(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
               (opening == '{' && closing == '}') ||
               (opening == '[' && closing == ']');
    }
}