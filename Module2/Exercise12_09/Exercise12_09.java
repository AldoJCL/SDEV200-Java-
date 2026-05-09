package Module2.Exercise12_09;


import java.util.Scanner;

public class Exercise12_09 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a binary string: ");
        String binaryString = input.nextLine();

        try {
            int decimal = bin2Dec(binaryString);
            System.out.println("The decimal value is " + decimal);
        }
        catch (BinaryFormatException ex) {
            System.out.println(ex.getMessage());
        }

        input.close();
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        int decimal = 0;

        // Go through each character and make sure it is only 0 or 1
        for (int i = 0; i < binaryString.length(); i++) {
            char ch = binaryString.charAt(i);

            if (ch != '0' && ch != '1') {
                throw new BinaryFormatException(binaryString + " is not a binary string");
            }

            // Convert the binary number into decimal step by step
            decimal = decimal * 2 + (ch - '0');
        }

        return decimal;
    }
}
    

