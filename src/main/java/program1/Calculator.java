package program1;


public class Calculator {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Denominator cannot be 0.");  // Explicit exception
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.divide(10,2);  // Example usage
        System.out.println("Division result: " + result);
    }
}