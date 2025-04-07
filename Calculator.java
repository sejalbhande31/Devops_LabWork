import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueCalculation = true;

        System.out.println("===== Welcome to the Simple Calculator =====");

        while (continueCalculation) {
            double num1 = 0, num2 = 0, result = 0;
            char operator;

            // Input first number with validation
            while (true) {
                System.out.print("Enter first number: ");
                if (scanner.hasNextDouble()) {
                    num1 = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                }
            }

            // Input operator with validation
            while (true) {
                System.out.print("Enter operator (+, -, *, /): ");
                operator = scanner.next().charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                } else {
                    System.out.println("Invalid operator. Please enter +, -, *, or /.");
                }
            }

            // Input second number with validation
            while (true) {
                System.out.print("Enter second number: ");
                if (scanner.hasNextDouble()) {
                    num2 = scanner.nextDouble();
                    if (operator == '/' && num2 == 0) {
                        System.out.println("Cannot divide by zero. Please enter a non-zero number.");
                        continue;
                    }
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                }
            }

            // Perform calculation
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            System.out.println("Result: " + result);

            // Ask user if they want to continue
            System.out.print("Do you want to perform another calculation? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes") && !choice.equals("y")) {
                continueCalculation = false;
                System.out.println("Thank you for using the calculator. Goodbye!");
            }
        }

        scanner.close();
    }
}



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
