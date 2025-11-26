import java.util.Scanner;

public class Calculator {

    // Logic methods
    public double add(double a, double b) { return a + b; }
    public double sub(double a, double b) { return a - b; }
    public double mul(double a, double b) { return a * b; }
    public double div(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero!");
        return a / b;
    }

    // CLI Main
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=== Simple Calculator CLI (Java) ===");
        System.out.println("1) Add\n2) Subtract\n3) Multiply\n4) Divide");

        try {
            System.out.print("Enter choice (1-4): ");
            int choice = Integer.parseInt(sc.nextLine());

            System.out.print("Enter first number: ");
            double a = Double.parseDouble(sc.nextLine());

            System.out.print("Enter second number: ");
            double b = Double.parseDouble(sc.nextLine());

            double result = 0;

            switch (choice) {
                case 1: result = calc.add(a, b); break;
                case 2: result = calc.sub(a, b); break;
                case 3: result = calc.mul(a, b); break;
                case 4: result = calc.div(a, b); break;
                default:
                    System.out.println("Invalid option.");
                    return;
            }

            if (result == Math.floor(result))
                System.out.println("Result: " + (long)result);
            else
                System.out.println("Result: " + result);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
