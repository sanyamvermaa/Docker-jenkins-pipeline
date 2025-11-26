public class CalculatorTest {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        assert calc.add(2, 3) == 5 : "Test add failed";
        assert calc.sub(5, 3) == 2 : "Test sub failed";
        assert calc.mul(4, 2) == 8 : "Test mul failed";

        assert calc.div(9, 3) == 3 : "Test div failed";

        try {
            calc.div(1, 0);
            throw new AssertionError("Test div by zero failed");
        } catch (ArithmeticException e) {
            // Expected
        }

        System.out.println("All tests passed!");
    }
}
