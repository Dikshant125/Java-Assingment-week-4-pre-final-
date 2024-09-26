/***
 * Question :- Conversions of all from base to others and Arithmetic operations
 * Date :- 26/09/2024
 * Owner :- Dikshant Goswami
 */

import java.util.Scanner;

public class CombinedConversionCalculation {

    /* Power functions is used where the base and the power which defines
     how much time a value will multiply itself passes as  parameters
     */
     /* --> parameter -> integer type
    --> return type -> integer
    */

    public static int powerfunction(int base, int exponent) {
        int result = 1;
        for (int start = 0; start < exponent; start++) {
            result = result * base;
        }
        return result;
    }

    /*Binary to Decimal conversion the binary number entered from user is passed as a parameter and return as the decimal
    --> parameter -> String
    --> return type -> integer type
    */
    public static int othertoDecimal(String binary) {
        int decimal = 0;
        for (int endoflength = binary.length() - 1, powervalue = 0; endoflength >= 0; endoflength--, powervalue++) {
            int bit = binary.charAt(endoflength) - '0';
            if (bit == 1) {
                decimal += powerfunction(2, powervalue);
            }
        }
        return decimal;
    }

    /* Decimal to Binary conversion
     here decimal is sent as an parameter of integer type and result will send our binary
    --> parameter -> integer type
    --> return type -> string
    */
    public static String othertoBinary(int decimal) {
        int Remainder;
        String Binary = "";
        while (decimal > 0) {
            Remainder = decimal % 2;
            Binary = Remainder + Binary;
            decimal = decimal / 2;
        }
        return Binary;
    }

    /* Decimal to Octal conversion
     here decimal is sent as our parameter and it will pass the octal value
    --> parameter -> integer type
    --> return type -> string
    */

    public static String othertooctal(int decimal) {
        int Remainder;
        String Octal = "";
        while (decimal != 0) {
            Remainder = decimal % 8;
            Octal = Remainder + Octal;
            decimal = decimal / 8;
        }
        return Octal;
    }

    /* Decimal to Hexadecimal conversion
     Here we receive the decimal as a parameter and get the Hexadecimal as a result
    --> parameter -> integer type
    --> return type -> string type
    */

    public static String othertoHexadecimal(int decimal) {
        int Remainder;
        String Hexadecimal = "";
        char HexadecimalArray[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (decimal != 0) {
            Remainder = decimal % 16;
            Hexadecimal = HexadecimalArray[Remainder] + Hexadecimal;
            decimal = decimal / 16;
        }
        return Hexadecimal;
    }

    /* Hexadecimal to Decimal conversion
      Here hexadecimal is passed as a parameter and decimal is received as a result output
    --> parameter -> string
    --> return type -> integer
    */

    public static int HexatoDecimal(String hexadecimal) {
        int decimal = 0;
        int exponent = 0;
        int lengthofhexadecimal = hexadecimal.length();

        for (int end = lengthofhexadecimal - 1; end >= 0; end--) {
            char hexChar = hexadecimal.charAt(end); //--> here hexchar defines the Hexadecimal particular single characters

            if (hexChar >= '0' && hexChar <= '9') {
                decimal += (hexChar - '0') * powerfunction(16, exponent);
            } else if (hexChar >= 'A' && hexChar <= 'F') {
                decimal += (hexChar - 'A' + 10) * powerfunction(16, exponent);
            } else if (hexChar >= 'a' && hexChar <= 'f') {
                decimal += (hexChar - 'a' + 10) * powerfunction(16, exponent);
            } else {
                System.out.println(Constants.INVALID_HEXCHAR + hexChar);
                return -1;
            }
            exponent++;
        }
        return decimal;
    }

    /* Octal to Decimal conversion
      Here the Octal value is passed as a parameters and result will get the decimal
    --> parameter -> integer
    --> return type -> integer
    */

    public static int octaltodecimal(int octal) {
        int Remainder = 0;
        int iteration = 0, decimal = 0, fixedvalue = 8; //--> Here iteration defines how many times our value will be multiplied with it own self
        while (octal != 0) {
            Remainder = octal % 10;
            decimal = decimal + powerfunction(fixedvalue, iteration) * Remainder;
            octal = octal / 10;
            iteration++;
        }
        return decimal;
    }

    /* Arithmetic Operations function
     Here our user will choose the options between the different conversion types and also choose
     the Arithmetic operation the he/she will give the inout which is used in calculation
    --> parameter -> integer
    --> return type -> nothing(void)
     */
    public static void arithmeticOperations(int systemChoice, int operationChoice) {
        try{
            Scanner inputfromuser = new Scanner(System.in);
            int num1Decimal = 0, num2Decimal = 0, resultDecimal = 0;
            String result = "";

            if (systemChoice == 1) {
                System.out.print(Constants.ENTER_FBINARY);
                String binary1 = inputfromuser.nextLine();
                System.out.print(Constants.ENTER_SBINARY);
                String binary2 = inputfromuser.nextLine();
                num1Decimal = othertoDecimal(binary1);
                num2Decimal = othertoDecimal(binary2);

            } else if (systemChoice == 2) {
                System.out.print(Constants.ENTER_FDECIMAL);
                num1Decimal = inputfromuser.nextInt();
                System.out.print(Constants.ENTER_SDECIMAL);
                num2Decimal = inputfromuser.nextInt();
            } else if (systemChoice == 3) {
                System.out.print(Constants.ENTER_FOCTAL);
                int octal1 = inputfromuser.nextInt();
                System.out.print(Constants.ENTER_SOCTAL);
                int octal2 = inputfromuser.nextInt();
                num1Decimal = octaltodecimal(octal1);
                num2Decimal = octaltodecimal(octal2);

            } else if (systemChoice == 4) {
                System.out.print(Constants.ENTER_FHEXADECIMAL);
                String hex1inputfromuser = inputfromuser.nextLine();
                System.out.print(Constants.ENTER_SHEXADECIMAL);
                String hex2inputfromuser = inputfromuser.nextLine();

                num1Decimal = HexatoDecimal(hex1inputfromuser);
                num2Decimal = HexatoDecimal(hex2inputfromuser);


                if (num1Decimal == -1 || num2Decimal == -1) {
                    System.out.println(Constants.INVALID_HEXADECIMAL);
                    return;
                }
            }


            // Here the result of the decimal values are done
            switch (operationChoice) {
                case 1:  // Addition
                    resultDecimal = num1Decimal + num2Decimal;
                    break;
                case 2:  // Subtraction
                    resultDecimal = num1Decimal - num2Decimal;
                    break;
                case 3:  // Multiplication
                    resultDecimal = num1Decimal * num2Decimal;
                    break;
                case 4:  // Division
                    if (num2Decimal != 0) {
                        resultDecimal = num1Decimal / num2Decimal;
                    } else {
                        System.out.println(Constants.DIVISION_NOT);
                        return;
                    }
                    break;
            }

        /* Convert result back to original system
           we will re convert the original values so that desire values can be obtained by our user
         */
            if (systemChoice == 1) {
                result = othertoBinary(resultDecimal);
                System.out.println(Constants.R_BINARY + result);
            } else if (systemChoice == 2) {
                System.out.println(Constants.R_DECIMAL + resultDecimal);
            } else if (systemChoice == 3) {
                result = othertooctal(resultDecimal);
                System.out.println(Constants.R_OCTAL + result);
            } else if (systemChoice == 4) {
                result = othertoHexadecimal(resultDecimal);
                System.out.println(Constants.R_HEXADECIMAL + result);
            }
        } catch (Exception e) {
            System.out.println("INVALID ");
        }
    }

    // Here all  conversions and arithmetic operation will take place
    public static void main(String[] args) {
        try {
            Scanner inputFromUser = new Scanner(System.in);
            boolean exitProgram = true;

            while (exitProgram) {
                System.out.println(Constants.MENU);
                System.out.println(Constants.B_TO_D);
                System.out.println(Constants.B_TO_O);
                System.out.println(Constants.B_TO_H);
                System.out.println(Constants.D_TO_B);
                System.out.println(Constants.D_TO_C);
                System.out.println(Constants.D_TO_H);
                System.out.println(Constants.O_TO_D);
                System.out.println(Constants.O_TO_B);
                System.out.println(Constants.O_TO_H);
                System.out.println(Constants.H_TO_D);
                System.out.println(Constants.H_TO_B);
                System.out.println(Constants.H_TO_O);
                System.out.println(Constants.ARITHMETIC_OP);
                System.out.println(Constants.EXIT);
                System.out.print(Constants.ENTER_CHOICE);
                int choice = inputFromUser.nextInt();
                inputFromUser.nextLine();

                switch (choice) {
                    case 1:  // Binary to Decimal
                        try {
                            System.out.print(Constants.ENTER_B_NUM);
                            String binary = inputFromUser.nextLine();
                            int decimalFromBinary = othertoDecimal(binary);
                            System.out.println(Constants.DECIMAL_VALUE + decimalFromBinary);
                        }catch (Exception error) {
                            System.out.println("invalid binary");
                        }
                        break;

                    case 2:  // Binary to Octal
                        try {
                            System.out.print(Constants.ENTER_B_NUM);
                            String binary = inputFromUser.nextLine();
                            int decimalFromBinary = othertoDecimal(binary);
                            String octalFromBinary = othertooctal(decimalFromBinary);
                            System.out.println(Constants.OCTAL_VALUE + octalFromBinary);
                        } catch (Exception error) {
                            System.out.println("invalid binary");
                        }
                        break;

                    case 3:  // Binary to Hexadecimal
                        try {
                            System.out.print(Constants.ENTER_B_NUM);
                            String binary = inputFromUser.nextLine();
                            int decimalFromBinary = othertoDecimal(binary);
                            String hexFromBinary = othertoHexadecimal(decimalFromBinary);
                            System.out.println(Constants.HEXADECIMAL_VALUE + hexFromBinary);
                        } catch (Exception error) {
                            System.out.println("invalid binary");
                        }
                        break;

                    case 4:  // Decimal to Binary
                        try {
                            System.out.print(Constants.ENTER_DECIMAL);
                            int decimal = inputFromUser.nextInt();
                            String binaryFromDecimal = othertoBinary(decimal);
                            System.out.println(Constants.BINARY_VALUE + binaryFromDecimal);
                        } catch (Exception error) {
                            System.out.println("invalid decimal");
                        }
                        break;

                    case 5:  // Decimal to Octal
                        try {
                            System.out.print(Constants.ENTER_DECIMAL);
                            int decimal = inputFromUser.nextInt();
                            String octalFromDecimal = othertooctal(decimal);
                            System.out.println(Constants.OCTAL_VALUE + octalFromDecimal);
                        } catch (Exception error) {
                            System.out.println("invalid decimal");
                        }
                        break;

                    case 6:  // Decimal to Hexadecimal
                        try{
                            System.out.print(Constants.ENTER_DECIMAL);
                            int decimal = inputFromUser.nextInt();
                            String hexFromDecimal = othertoHexadecimal(decimal);
                            System.out.println(Constants.HEXADECIMAL_VALUE + hexFromDecimal);
                        }catch(Exception e){
                            System.out.println("Invalid Decimal");
                        }
                        break;

                    case 7:  // Octal to Decimal
                        try {
                            System.out.print(Constants.ENTER_OCTAL);
                            int octal = inputFromUser.nextInt();
                            int decimalFromOctal = octaltodecimal(octal);
                            System.out.println(Constants.DECIMAL_VALUE + decimalFromOctal);
                        } catch (Exception e) {
                            System.out.println("Invalid In octal");
                        }
                        break;

                    case 8:  // Octal to Binary
                        try {
                            System.out.print(Constants.ENTER_OCTAL);
                            int octal = inputFromUser.nextInt();
                            int decimalFromOctal = octaltodecimal(octal);
                            String binaryFromOctal = othertoBinary(decimalFromOctal);
                            System.out.println(Constants.BINARY_VALUE + binaryFromOctal);
                        } catch (Exception e) {
                            System.out.println("Invalid octal");
                        }
                        break;

                    case 9:  // Octal to Hexadecimal
                        try {
                            System.out.print(Constants.ENTER_OCTAL);
                            int octal = inputFromUser.nextInt();
                            int decimalFromOctal = octaltodecimal(octal);
                            String hexFromOctal = othertoHexadecimal(decimalFromOctal);
                            System.out.println(Constants.HEXADECIMAL_VALUE + hexFromOctal);
                        } catch (Exception error) {
                            System.out.println("Invalid octal");
                        }
                        break;

                    case 10:  // Hexadecimal to Decimal
                        try {
                            System.out.print(Constants.ENTER_HEXADECIMAL);
                            String hexadecimal = inputFromUser.nextLine();
                            int decimalFromHexadecimal = HexatoDecimal(hexadecimal);
                            System.out.println(Constants.DECIMAL_VALUE + decimalFromHexadecimal);
                        } catch (Exception error) {
                            System.out.println("Invalid hexadecimal");
                        }
                        break;

                    case 11:  // Hexadecimal to Binary
                        try {
                            System.out.print(Constants.ENTER_HEXADECIMAL);
                            String hexadecimal = inputFromUser.nextLine();
                            int decimalFromHexadecimal = HexatoDecimal(hexadecimal);
                            String binaryFromHexadecimal = othertoBinary(decimalFromHexadecimal);
                            System.out.println(Constants.BINARY_VALUE + binaryFromHexadecimal);
                        } catch (Exception error) {
                            System.out.println("Invalid hexadecimal");
                        }
                        break;

                    case 12:  // Hexadecimal to Octal
                        try {
                            System.out.print(Constants.ENTER_HEXADECIMAL);
                            String hexadecimal = inputFromUser.nextLine();
                            int decimalFromHexadecimal = HexatoDecimal(hexadecimal);
                            String octalFromHexadecimal = othertooctal(decimalFromHexadecimal);
                            System.out.println(Constants.OCTAL_VALUE + octalFromHexadecimal);
                        } catch (Exception error) {
                            System.out.println("Invalid hexadecimal");
                        }
                        break;

                    case 13:  // Arithmetic Operations
                        System.out.println(Constants.CHOOSE_N_S);
                        System.out.println(Constants.B);
                        System.out.println(Constants.D);
                        System.out.println(Constants.O);
                        System.out.println(Constants.H);
                        System.out.print(Constants.ENTER_CHOICE);
                        try {
                            int systemChoice = inputFromUser.nextInt();
                            inputFromUser.nextLine();

                            System.out.println(Constants.CHOOSE_OPERATION);
                            System.out.println(Constants.ADD);
                            System.out.println(Constants.SUB);
                            System.out.println(Constants.MULTI);
                            System.out.println(Constants.DIV);
                            System.out.print(Constants.ENTER_CHOICE);
                            int operationChoice = inputFromUser.nextInt();
                            inputFromUser.nextLine();

                            arithmeticOperations(systemChoice, operationChoice);
                        } catch (Exception error) {
                            System.out.println("Invalid choice");
                        }
                        break;
                    //--> Exit from our program
                    case 14:
                        exitProgram = true;
                        break;

                    default:
                        System.out.println(Constants.INVALID);
                }
            }

            inputFromUser.close();
        } catch (Exception error) {
            System.out.println("Please write carefully! you have entered rather then option");
        }
    }
}
