package Module4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exercise21_03 {

    public static void main(String[] args) {
        // Make sure the user gave a file name
        if (args.length != 1) {
            System.out.println("Usage: java Module4.Exercise21_03 filename");
            return;
        }

        File file = new File(args[0]);

        if (!file.exists()) {
            System.out.println("File " + args[0] + " does not exist");
            return;
        }

        try {
            int count = countKeywords(file);
            System.out.println("The number of keywords in " + args[0] + " is " + count);
        }
        catch (FileNotFoundException ex) {
            System.out.println("File " + args[0] + " does not exist");
        }
    }

    public static int countKeywords(File file) throws FileNotFoundException {
        String[] keywordString = {
            "abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else",
            "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public",
            "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws",
            "transient", "try", "void", "volatile", "while",
            "true", "false", "null"
        };

        Set<String> keywordSet = new HashSet<>();

        for (String keyword : keywordString) {
            keywordSet.add(keyword);
        }

        int count = 0;
        boolean inBlockComment = false;

        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            String line = input.nextLine();

            String cleanedLine = "";
            boolean inString = false;
            boolean inChar = false;

            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                // Handle block comments
                if (inBlockComment) {
                    if (ch == '*' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                        inBlockComment = false;
                        i++;
                    }
                    continue;
                }

                // Handle line comments
                if (!inString && !inChar && ch == '/' && i + 1 < line.length() && line.charAt(i + 1) == '/') {
                    break;
                }

                // Handle block comment start
                if (!inString && !inChar && ch == '/' && i + 1 < line.length() && line.charAt(i + 1) == '*') {
                    inBlockComment = true;
                    i++;
                    continue;
                }

                // Handle strings
                if (!inChar && ch == '"') {
                    inString = !inString;
                    cleanedLine += " ";
                    continue;
                }

                // Handle characters
                if (!inString && ch == '\'') {
                    inChar = !inChar;
                    cleanedLine += " ";
                    continue;
                }

                if (!inString && !inChar) {
                    cleanedLine += ch;
                }
                else {
                    cleanedLine += " ";
                }
            }

            Scanner lineScanner = new Scanner(cleanedLine);

            while (lineScanner.hasNext()) {
                String word = lineScanner.next();

                word = word.replaceAll("[^a-zA-Z0-9_]", "");

                if (keywordSet.contains(word)) {
                    count++;
                }
            }

            lineScanner.close();
        }

        input.close();
        return count;
    }
}