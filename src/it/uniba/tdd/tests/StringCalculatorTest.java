package it.uniba.tdd.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import it.uniba.tdd.StringCalculator;

public class StringCalculatorTest {

	StringCalculator calculator;
	String emptyString;
	String oneDigits;
	String twoDigits;
	String twoNumbers;
	String moreNumbers;
	String noComma;
	String incorrectNoComma;
	String differentDelimiter;
	String negativeNumbers;
	
	@Before
	public void setup() {
		emptyString = "";
		oneDigits = "1";
		twoDigits = "12";
		twoNumbers = "12,3";
		moreNumbers = "12,34,56,78,90";
		noComma = "â€œ1\n2,3â€";
		incorrectNoComma = "â€œ1,\nâ€";
		differentDelimiter = "//;\n1;2";
		negativeNumbers = "//=\n-1=-2";
		calculator = new StringCalculator();
	}
	
	@Test
	public void emptyStringTest() {
		assertEquals(0, calculator.add(emptyString));
	}
	
	@Test
	public void oneNumberTest() {
		assertEquals(1, calculator.add(oneDigits));
		assertEquals(12, calculator.add(twoDigits));
	}
	
	@Test
	public void twoNumberTest() {
		assertEquals(15, calculator.add(twoNumbers));
	}
	
	@Test
	public void moreNumberTest() {
		assertEquals(270, calculator.add(moreNumbers));
	}
	
	@Test
	public void noCommaTest() {
		assertEquals(6, calculator.add(noComma));
		assertEquals(1, calculator.add(incorrectNoComma)); //da implementare
	}	
	
	@Test
	public void differentDelimiterTest() {
		assertEquals(3, calculator.add(differentDelimiter));
	}	
	
	@Test
	public void negativeNumbersTest() {
		//assertEquals(-3, calculator.add(negativeNumbers));
	}	
}
