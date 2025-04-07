import java.util.*;

public class Calculator {

    static List<String> history = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        System.out.println("===== Welcome to the Enhanced Calculator =====");

        while (continueCalculation) {
            double num1 = getNumber(scanner, "Enter first number: ");
            char operator = getOperator(scanner);
            double num2 = getSecondNumber(scanner, operator);

            double result = performOperation(num1, num2, operator);
            System.out.println("Result: " + result);

            history.add(num1 + " " + operator + " " + num2 + " = " + result);

            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes") && !choice.equals("y")) {
                continueCalculation = false;
                System.out.println("\nCalculation History:");
                for (String entry : history) {
                    System.out.println(entry);
                }
                System.out.println("\nThank you for using the calculator. Goodbye!");
            }
        }

        scanner.close();
    }

    // Get a number from the user with validation
    public static double getNumber(Scanner scanner, String message) {
        double number;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // discard invalid input
            }
        }
        return number;
    }

    // Get a valid operator from the user
    public static char getOperator(Scanner scanner) {
        char operator;
        while (true) {
            System.out.println("Choose operation: +  -  *  /  %  ^");
            System.out.print("Enter operator: ");
            operator = scanner.next().charAt(0);
            if ("+-*/%^".indexOf(operator) != -1) {
                break;
            } else {
                System.out.println("Invalid operator. Please try again.");
            }
        }
        return operator;
    }

    // Get the second number with division/modulus zero check
    public static double getSecondNumber(Scanner scanner, char operator) {
        double number;
        while (true) {
            number = getNumber(scanner, "Enter second number: ");
            if ((operator == '/' || operator == '%') && number == 0) {
                System.out.println("Cannot divide or take modulus by zero. Try again.");
            } else {
                break;
            }
        }
        return number;
    }

    // Perform the chosen operation
    public static double performOperation(double num1, double num2, char operator) {
        switch (operator) {
            case '+': return num1 + num2;
            case '-': return num1 - num2;
            case '*': return num1 * num2;
            case '/': return num1 / num2;
            case '%': return num1 % num2;
            case '^': return Math.pow(num1, num2);
            default:
                System.out.println("Unexpected operator. Returning 0.");
                return 0;
        }
    }
}



// import java.util.Scanner;

// public class Calculator {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         boolean continueCalculation = true;

//         System.out.println("===== Welcome to the Simple Calculator =====");

//         while (continueCalculation) {
//             double num1 = 0, num2 = 0, result = 0;
//             char operator;

//             // Input first number with validation
//             while (true) {
//                 System.out.print("Enter first number: ");
//                 if (scanner.hasNextDouble()) {
//                     num1 = scanner.nextDouble();
//                     break;
//                 } else {
//                     System.out.println("Invalid input. Please enter a number.");
//                     scanner.next(); // clear invalid input
//                 }
//             }

//             // Input operator with validation
//             while (true) {
//                 System.out.print("Enter operator (+, -, *, /): ");
//                 operator = scanner.next().charAt(0);
//                 if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
//                     break;
//                 } else {
//                     System.out.println("Invalid operator. Please enter +, -, *, or /.");
//                 }
//             }

//             // Input second number with validation
//             while (true) {
//                 System.out.print("Enter second number: ");
//                 if (scanner.hasNextDouble()) {
//                     num2 = scanner.nextDouble();
//                     if (operator == '/' && num2 == 0) {
//                         System.out.println("Cannot divide by zero. Please enter a non-zero number.");
//                         continue;
//                     }
//                     break;
//                 } else {
//                     System.out.println("Invalid input. Please enter a number.");
//                     scanner.next(); // clear invalid input
//                 }
//             }

//             // Perform calculation
//             switch (operator) {
//                 case '+':
//                     result = num1 + num2;
//                     break;
//                 case '-':
//                     result = num1 - num2;
//                     break;
//                 case '*':
//                     result = num1 * num2;
//                     break;
//                 case '/':
//                     result = num1 / num2;
//                     break;
//             }

//             System.out.println("Result: " + result);

//             // Ask user if they want to continue
//             System.out.print("Do you want to perform another calculation? (yes/no): ");
//             String choice = scanner.next().toLowerCase();
//             if (!choice.equals("yes") && !choice.equals("y")) {
//                 continueCalculation = false;
//                 System.out.println("Thank you for using the calculator. Goodbye!");
//             }
//         }

//         scanner.close();
//     }
// }



// import java.util.Scanner;

// public class Calculator {

//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);

//         double num1, num2, result;
//         char operator;

//         System.out.println("Simple Calculator");
//         System.out.print("Enter first number: ");
//         num1 = scanner.nextDouble();

//         System.out.print("Enter operator (+, -, *, /): ");
//         operator = scanner.next().charAt(0);

//         System.out.print("Enter second number: ");
//         num2 = scanner.nextDouble();

//         switch (operator) {
//             case '+':
//                 result = num1 + num2;
//                 System.out.println("Result = " + result);
//                 break;
//             case '-':
//                 result = num1 - num2;
//                 System.out.println("Result = " + result);
//                 break;
//             case '*':
//                 result = num1 * num2;
//                 System.out.println("Result = " + result);
//                 break;
//             case '/':
//                 if (num2 != 0) {
//                     result = num1 / num2;
//                     System.out.println("Result = " + result);
//                 } else {
//                     System.out.println("Error: Cannot divide by zero!");
//                 }
//                 break;
//             default:
//                 System.out.println("Invalid operator!");
//                 break;
//         }

//         scanner.close();
//     }
// }
