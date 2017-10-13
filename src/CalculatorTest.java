package is.ru.stringcalculator;
//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testOneNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void testTwoNumbers() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testMultipleNumbers() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void testNewLines() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void testNewLines() {
		assertEquals(7, Calculator.add("1\n2,4"));
	}

	@Test
    public void testSumWithNegativeNumbers() {
        boolean exceptionHappens = false;
        try {
            calculator.add("50,-100,70,-80");
        } 
        catch (NegativeNumberException e) {
            assertEquals("Negatives not allowed", e.getMessage());
            exceptionHappens = true;
        }

        assertTrue(exceptionHappens);
    }


}