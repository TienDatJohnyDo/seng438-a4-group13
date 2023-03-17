package org.jfree.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

//Assignment 2
//Alphabetical Order of test methods as well as in the source code
//equals (Object) method 
//getCentralValue() method
//getlength() method 
//getLowerBound() method 
//getUpperBound() method 
//tostring() method 
//Class for Range Test

public class RangeTest {
	// variable for assignment 4
	private Range testMutation;

	// New hasCode()
	private Range hashRange1;

	// Scale variables
	private Range scaleRange1;
	private Range scaleFactorRange1;

	// expand Margin variables
	private Range expandMargin1;
	private Range expandMargin2;

	// NaN bound variables
	Range lowerNaNRange;
	Range upperNaNRange;

	// Range() variables
	private Range illegalRange;
	private Range illegalRange2;

	// combine() variables
	private Range nullRange;

	// equals() Range vairables
	private Range myRangeOne;
	private Range myRangeTwo;
	private Range myRangeThree;
	private Range myRangeFour;
	private Range myRangeFive;
	private Range myRangeSix;

	// Assignment 2 getCentralValue() example variable
	private Range exampleRangeLab;

	// get Length Range variables
	private Range exampleRange;
	private Range exampleRange1;
	private Range exampleRange2;
	private Range exampleRange3;
	private Range exampleRange4;

	// getLowerBound() Range variables
	private Range LowerRange;
	private Range LowerRange2;
	private Range LowerRange3;
	private Range LowerRange4;
	private Range LowerRange5;
	// private Range LowerRange6;

	// getUpperBound()/Equals/toString Range variables
	private Range myRange;
	private Range myRange2;
	private Range myRange3;
	private Range myRange4;
	private Range myRange5;
	private Range myRange6;
	private int whiteBoxOne;

	// shift variables
	private Range shiftOriginal1;
	private Range shiftOriginal2;
	private Range shiftRange1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
//		// NaN Range initialization
//		lowerNaNRange = new Range(0 / 0, 10.0);
//		upperNaNRange = new Range(5.0, 0 / 0);
		// combine() Range initialization
//		nullRange = new Range(NaN, NaN);
		// HashCode initialization
		hashRange1 = new Range(0.0, 0.0);

		// Scale initialization
		scaleRange1 = new Range(-5.0, 10.0);

		// expandMargin initiliazation
		expandMargin1 = new Range(1.0, 10.0);
		expandMargin1 = new Range(5, 10);

		// equals() Range initialization
		myRangeOne = new Range(-15.0, 100.0);
		myRangeTwo = new Range(-5.0, -2.0);
		myRangeThree = new Range(10.0, 15.0);
		myRangeFour = new Range(0.0, 0.0);
		myRangeFive = new Range(0.0, 15.0);
		myRangeSix = new Range(-15.0, 0.0);

		// Assignment 2 get CentralValue() example variable initialization
		exampleRangeLab = new Range(-1, 1);

		// getLength() Range initialization
		exampleRange = new Range(-5, 10);// negative - positive
		exampleRange1 = new Range(-10, -5); // negative- negative
		exampleRange2 = new Range(0, 10); // 0-positive
		exampleRange3 = new Range(2, 10); // Positive-positive
		exampleRange4 = new Range(0, 0); // 0 -0

		// getLowerBound () Range initialization
		LowerRange = new Range(-5, 10); // Negative-positive
		LowerRange2 = new Range(0, 10); // 0-positive
		LowerRange3 = new Range(2, 10); // Positive - positive
		LowerRange4 = new Range(-10, -5); // Negative-Negative
		LowerRange5 = new Range(0, 0); // 0-0

		// LowerRange6 = new Range (-5,-10); //Opposite value (Test should fail)

		// getUpperBound()/Equals/toString/contains Range variables initialization
		myRange = new Range(-15.0, 100.0);
		myRange2 = new Range(-5.0, -2.0);
		myRange3 = new Range(10.0, 15.0);
		myRange4 = new Range(0.0, 0.0);
		myRange5 = new Range(0.0, 15.0);
		myRange6 = new Range(-15.0, 0.0);
		whiteBoxOne = 1;

		// Shift method
		shiftOriginal1 = new Range(-5, 5);
		shiftOriginal2 = new Range(0.0, 0.0);

	}
	// equals() method Test Cases

	@Test
	// this test case tests equivalent class for
	// the lower bound being negative integer and upper bound being positive integer
	public void equalsOneTest() {
		assertEquals("The output should be true", true, myRange.equals(myRangeOne));
	}

	@Test
	// this test case tests equivalent class for
	// the lower bound being negative integer and upper bound being negative integer
	public void equalsTwoTest() {
		assertEquals("The output should be true", true, myRange2.equals(myRangeTwo));
	}

	@Test
// this test case tests equivalent class for
	// the lower bound being positive integer and upper bound being positive integer
	public void equalsThreeTest() {
		assertEquals("The output should be true", true, myRange3.equals(myRangeThree));
	}

	@Test
	// this test case tests equivalent class for
	// upper and lower bound being the same number
	public void equalsFourTest() {
		assertEquals("The output should be true", true, myRange4.equals(myRangeFour));
	}

	@Test
	// this test case tests equivalent class for
	// lower bound being 0 and upper bound being positive
	public void equalsFiveTest() {
		assertEquals("The output should be true", true, myRange5.equals(myRangeFive));
	}

	@Test
	// this test case tests equivalent class for
	// lower bound being a negative number and upper bound 0
	public void equalsSixTest() {
		assertEquals("The output should be true", true, myRange6.equals(myRangeSix));
	}

	@Test
	// this test case tests equivalent class for
	// object calls equal on itself
	public void equalsSevenTest() {
		assertEquals("The output should be true", true, myRange6.equals(myRange6));
	}

	// this test should be false because the two ranges do not equal each other
	@Test
	public void equalsFailTest() {
		assertEquals("The output should be false", false, myRange.equals(myRangeFour));
	}

	// centralValueShouldBeZero()- This test case is from the assignment 2 lab
	// hand-out
	@Test
	public void centralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, exampleRangeLab.getCentralValue(), .000000001d);
	}

	// getLength Method() Test Cases
	@Test
	public void correctLengthShouldBeFifthteen() {
		// assertion arguments are [message], [expected], [actual], [delta]
		// This method works correctly compared with Oracle to get length we do (maximum
		// - minimum)
		assertEquals("The length of the range -5 and 10 is 15", 15, exampleRange.getLength(), .000000001d);
	}

	// This test should fail
//	@Test
//	public void failLowerBoundShouldBeTen() {
//		//assertion arguments are [message], [expected], [actual], [delta]
//		//This method works incorrectly compared with Oracle to get the upper bound 10 in a range of -5,10 when it should be -5
//		assertEquals("The length of the range -5 to 10 is 5",5, exampleRange.getLength(),.000000001d);
//		//Ask Stuart
//	}
	@Test
	public void rangeShouldBeFive() {
		// assertion arguments are [message], [expected], [actual], [delta]
		// This method works correctly compared with Oracle to get length we do (maximum
		// - minimum)
		assertEquals("The length of the range -10 and -5 is 5", 5, exampleRange1.getLength(), .000000001d);
	}

	@Test
	public void rangeShouldBeTen() {
		// assertion arguments are [message], [expected], [actual], [delta]
		// This method works correctly compared with Oracle to get length we do (maximum
		// - minimum)
		assertEquals("The length of the range 0 and 10 is 10", 10, exampleRange2.getLength(), .000000001d);
	}

	@Test
	public void rangeShouldBeEight() {
		// assertion arguments are [message], [expected], [actual], [delta]
		// This method works correctly compared with Oracle to get length we do (maximum
		// - minimum)
		assertEquals("The length of the range 2 and 10 is 8", 8, exampleRange3.getLength(), .000000001d);
	}

	@Test
	public void rangeShouldBeZero() {
		// assertion arguments are [message], [expected], [actual], [delta]
		// This method works correctly compared with Oracle to get length we do (maximum
		// - minimum)
		assertEquals("The length of the range 0 and 0 is 0", 0, exampleRange4.getLength(), .000000001d);
	}

	// getLowerBound() Method Test Cases

	// Test #1 : This test is correct
	@Test
	public void lowerBoundShouldBeMinusFive() {
		// assertion arguments are [message], [expected], [actual], [delta]
		// This method works correctly compared with Oracle to get the lower bound of -5
		// in a range of -5,10
		assertEquals("The lower bound of the range -5 and 10 should be -5", -5, LowerRange.getLowerBound(),
				.000000001d);
	}

	// Test 2 : This test is correct
	@Test
	public void lowerBoundShouldBeZero() {
		// assertion arguments are [message], [expected], [actual], [delta]
		// This method works correctly compared with Oracle to get the lower bound of 0
		// in a range of 0,10
		assertEquals("The lower bound of the range 0 and 10 should be 0", 0, LowerRange2.getLowerBound(), .000000001d);
	}

	@Test
	public void lowerBoundShouldBeTwo() {
		// assertion arguments are [message], [expected], [actual], [delta]
		// This method works correctly compared with Oracle to get the lower bound of 2
		// in a range of 2,10
		assertEquals("The lower bound of the range 2 and 10 should be 2", 2, LowerRange3.getLowerBound(), .000000001d);
	}

	@Test
	public void lowerBoundShouldBeMinusTen() {
		// assertion arguments are [message], [expected], [actual], [delta]
		// This method works correctly compared with Oracle to get the lower bound of 2
		// in a range of 2,10
		assertEquals("The lower bound of the range -10 and -5 should be -5", -10, LowerRange4.getLowerBound(),
				.000000001d);
	}

	@Test
	public void lowerBoundShouldBeZeroZero() {
		// assertion arguments are [message], [expected], [actual], [delta]
		// This method works correctly compared with Oracle to get the lower bound of 0
		// in a range of 0,0
		assertEquals("The lower bound of the range 0 and 0 should be 0", 0, LowerRange5.getLowerBound(), .000000001d);
	}
	// Opposite Value lower bound and upper bound are switch (Fail test case)
//		@Test
//		public void FaillowerBoundShouldBeMinusTen() {
//			//assertion arguments are [message], [expected], [actual], [delta]
//			//This method works correctly compared with Oracle to get the lower bound of -10 in a range of -5,-10
//			assertEquals("The lower bound of the range -5 and -10 should be -5",-5, LowerRange6.getLowerBound(),.000000001d);
//		}

	// getUpperBound() method Test Cases
	// this method FAILS
	// returns lower bound instead
	@Test
	// this test case tests equivalent class for
	// the lower bound being negative number and upper bound being positive number
	public void getUpperBoundOne() {
		assertEquals("The upper bound value of Range [-15, 100] should be 100", 100.0, myRange.getUpperBound(),
				.000000001d);
	}


	@Test
	// this test case tests equivalent class for
	// the lower bound being negative number and upper bound being negative number
	public void getUpperBoundTwo() {
		assertEquals("The upper bound value of Range [-5, -2] should be -2", -2.0, myRange2.getUpperBound(),
				.000000001d);
	}

	@Test
	// this test case tests equivalent class for
	// the lower bound being positive number and upper bound being positive number
	public void getUpperBoundThree() {
		assertEquals("The upper bound value of Range [10, 15] should be 15", 15.0, myRange3.getUpperBound(),
				.000000001d);
	}

	@Test
	// this test case tests equivalent class for
	// upper and lower bound being the same number
	public void getUpperBoundFour() {
		assertEquals("The upper bound value of Range [0, 0] should be 0", 0.0, myRange4.getUpperBound(), .000000001d);
	}

	@Test
	// this test case tests equivalent class for
	// lower bound being 0 and upper bound being positive
	public void getUpperBoundFive() {
		assertEquals("The upper bound value of Range [0, 15] should be 15", 15.0, myRange5.getUpperBound(),
				.000000001d);
	}

	@Test
	// this test case tests equivalent class for
	// lower bound being a negative number and upper bound 0
	public void getUpperBoundSix() {
		assertEquals("The upper bound value of Range [-15, 0] should be 0", 0.0, myRange6.getUpperBound(), .000000001d);
	}

	// toString() Method test Cases
	// this method FAILS
	// format is really strange/off
	// lower bound values are also different

	@Test
	// this test case tests equivalent class for
	// the lower bound being negative integer and upper bound being positive integer
	public void toStringOne() {

		assertEquals("The string should output 'Range[-15.0,100.0]'", "Range[-15.0,100.0]", myRange.toString());
	}

	@Test
	// this test case tests equivalent class for
	// the lower bound being negative integer and upper bound being negative integer
	public void toStringTwo() {

		assertEquals("The string should output 'Range[-5.0,-2.0]'", "Range[-5.0,-2.0]", myRange2.toString());
	}

	@Test
	// this test case tests equivalent class for
	// the lower bound being positive integer and upper bound being positive integer
	public void toStringThree() {

		assertEquals("The string should output 'Range[10.0,15.0]'", "Range[10.0,15.0]", myRange3.toString());
	}

	@Test
	// this test case tests equivalent class for
	// upper and lower bound being the same number
	public void toStringFour() {

		assertEquals("The string should output 'Range[0.0,0.0]'", "Range[0.0,0.0]", myRange4.toString());
	}

	@Test

	// this test case tests equivalent class for
	// lower bound being 0 and upper bound being positive
	public void toStringFive() {

		assertEquals("The string should output 'Range[0.0,15.0]'", "Range[0.0,15.0]", myRange5.toString());
	}

	@Test
	// this test case tests equivalent class for
	// lower bound being a negative number and upper bound 0
	public void toStringSix() {

		assertEquals("The string should output 'Range[-15.0,0.0]'", "Range[-15.0,0.0]", myRange6.toString());
	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR equals()**********
	///////////////////////////////////////////////////

	// test comparing 2 different objects
	@Test
	public void equalsDifferentObjectTest() {
		assertEquals("The output should be false", false, myRange.equals(whiteBoxOne));
	}

	// test if lower ranges are the same but upper ranges are different
	@Test
	public void equalsSameLowerDifferentUpper() {
		assertEquals("The output should be false", false, myRange.equals(myRange6));
	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR contains()**********
	///////////////////////////////////////////////////

	@Test
	public void containsValueLower() {
		assertEquals("The output should be false", false, myRange.contains(-100.0));
	}

	@Test
	public void containsValueUpper() {
		assertEquals("The output should be false", false, myRange.contains(10000.0));
	}

	@Test
	public void containsValueInBetween() {
		assertEquals("The output should be true", true, myRange.contains(1.0));
	}

	// value is exactly the lower bound
	@Test
	public void containsValueLowerBound() {
		assertEquals("The output should be true", true, myRange4.contains(0.0));
	}

//	// value is exactly the upper bound
//	@Test
//	public void containsValueUpperBound() {
//		assertEquals("The output should be true", true, myRange.contains(100.0));
//	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR Range()**********
	///////////////////////////////////////////////////

	// testing IllegalArgumentException in Range()
	@Test(expected = IllegalArgumentException.class)
	public void rangeIllegalArgumentExceptionTest() {
		// Range() Range initialization
		illegalRange = new Range(10.0, 5.0);
	}

	// ********WHITE-BOX TESTING FOR getLowerBound()**********
	// testing IllegalArgumentException in getLowerBound()
//	@Test(expected = IllegalArgumentException.class)
//	public void getLowerBoundIllegalArgumentExceptionTest() {
//
//		try {
//			illegalRange2 = new Range(10.0, 5.0);
//		} catch (IllegalArgumentException e) {
//
//		}
//		illegalRange2.getLowerBound();
//	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR intersects()**********
	///////////////////////////////////////////////////

	@Test
	// b0 smaller than lower bound and b1 greater than lower bound
	public void intersectsTestOne() {
		assertEquals("The output should be true", true, myRange.intersects(-20.0, 0.0));
	}

	@Test
	// b0 smaller than lower bound and b1 smaller than lower bound
	public void intersectsTestTwo() {
		assertEquals("The output should be false", false, myRange.intersects(-20.0, -19.0));
	}

	@Test
	// b0 greater than lower bound but less than upper bound
	// b1 greater or equal to b0
	public void intersectsTestThree() {
		assertEquals("The output should be true", true, myRange.intersects(0.0, 1.0));
	}

	@Test
	// b0 greater than lower bound but less than upper bound
	// b1 less than b0
	public void intersectsTestFour() {
		assertEquals("The output should be false", false, myRange.intersects(1.0, 0.0));
	}

	@Test
	// b0 greater than lower bound and greater than upper bound
	// b1 less than b0
	public void intersectsTestFive() {
		assertEquals("The output should be false", false, myRange.intersects(200.0, 150.0));
	}

	@Test
	// testing intersects(Range)
	public void intersectsRangeTest() {
		assertEquals("The output should be true", true, myRange.intersects(myRange2));
	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR constrain()**********
	///////////////////////////////////////////////////
	@Test
	// range does contain value
	public void constrainTestOne() {
		assertEquals("The output should be 0.0", 0.0, myRange.constrain(0.0), .000000001d);
	}

	@Test
	// range does not contain value and value is less than lower bound
	public void constrainTestTwo() {
		assertEquals("The output should be false", -15.0, myRange.constrain(-20.0), .000000001d);
	}

	@Test
	// range does not contain value and value is greater than upper bound
	public void constrainTestThree() {
		assertEquals("The output should be false", 100.0, myRange.constrain(200.0), .000000001d);
	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR combine()**********
	///////////////////////////////////////////////////
	@Test
	// range 1 not null but range 2 is null
	public void combineTestOne() {
		assertEquals("The output should be myRange", myRange, Range.combine(myRange, nullRange));
	}

	@Test
	// range 2 not null but range 1 is null
	public void combineTestTwo() {
		assertEquals("The output should be myRange", myRange, Range.combine(nullRange, myRange));
	}

	@Test
	// range 1 not null and range 2 not null
	public void combineTestThree() {
		assertEquals("The output should be myRange", myRange, Range.combine(myRange2, myRange));
	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR isNaNRange**********
	///////////////////////////////////////////////////
	@Test
	// lower and upper bound are not NaN
	public void isNaNRangeTestOne() {

		assertEquals("The output should be false", false, myRange.isNaNRange());
	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR combineIgnoringNaN**********
	///////////////////////////////////////////////////

	@Test
	// both ranges are not null
	public void combineIgnoringNaNTestOne() {
		assertEquals("The output should be myRange", myRange, Range.combineIgnoringNaN(myRange, myRange4));
	}

	@Test
	// range1 is null
	// range2 is not null and non NaN
	public void combineIgnoringNaNTestTwo() {

		Range testRange2 = Range.combineIgnoringNaN(null, myRange);
		assertEquals("The output should be myRange", myRange, testRange2);

	}

	@Test
	// range1 is null
	// range 2 is not null but is NaN
	public void combineIgnoringNaNTestThree() {
		double NaN = Math.sqrt(-1);
		Range testMutation = new Range(NaN, NaN);
		Range testRange2 = Range.combineIgnoringNaN(null, testMutation);
		assertNull("The output should be null", testRange2);

	}

	@Test
	// range1 is null
	// range 2 is null and is not NaN
	public void combineIgnoringNaNTest4() {
		Range testRange = Range.combineIgnoringNaN(null, null);
		assertNull("The output should be null", testRange);

	}

	// range1 is NaN
	// range2 is Null
	@Test
	public void combineIgnoringNaNTestFive() {
		double NaN = Math.sqrt(-1);
		Range testMutation = new Range(NaN, NaN);
		Range returnRange = Range.combineIgnoringNaN(testMutation, null);
		assertNull("The return value should be null", returnRange);

	}

	// range1 is not Null and not NaN
	// range2 is null
	@Test
	public void combineIgnoringNaNTestSix() {
		double NaN = Math.sqrt(-1);

		Range result = Range.combineIgnoringNaN(myRange, null);
		assertEquals("The return value should be null", myRange, result);

	}

	@Test
	public void combineIgnoringNaNSeven() {
		double NaN = Math.sqrt(-1);
		Range testMutation = new Range(NaN, NaN);
		Range returnRange = Range.combineIgnoringNaN(testMutation, new Range(NaN, 100.0));
		assertEquals("The return value should be 4", 100.0, returnRange.getUpperBound(), .000000001d);

	}

	@Test
	// range1 is NaN
	// Range2 is NaN
	public void combineIgnoringNaNEight() {
		double NaN = Math.sqrt(-1);
		Range testMutation = new Range(NaN, NaN);
		Range testRange2 = new Range(NaN, NaN);
		Range returnRange = Range.combineIgnoringNaN(testMutation, testRange2);
		assertNull("The return value should be 4", returnRange);

	}

	// this method also indirectly tests min() and max() since we cannot unit test
	// them
	// due to those specific methods being private methods

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR expandToInclude()**********
	///////////////////////////////////////////////////

	@Test
	// range is null
	public void expandToIncludeTestOne() {
		assertEquals("The output should be myRange", myRange4, Range.expandToInclude(nullRange, 0.0));
	}

	@Test
	// range is not null and value is less than lower bound
	public void expandToIncludeTestTwo() {
		Range testRange = new Range(-20.0, 100.0);
		assertEquals("The output should be myRange", testRange, Range.expandToInclude(myRange, -20.0));
	}

	@Test
	// range is not null and value is greater than upper bound
	public void expandToIncludeTestThree() {
		Range testRange = new Range(-15.0, 200.0);
		assertEquals("The output should be myRange", testRange, Range.expandToInclude(myRange, 200.0));
	}

	@Test
	// range is not null and value is less than upper bound but greater than lower
	// bound
	public void expandToIncludeTestFour() {
		Range testRange = new Range(-15.0, 100.0);
		assertEquals("The output should be myRange", testRange, Range.expandToInclude(myRange, 20.0));
	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR shift with boolean**********
	///////////////////////////////////////////////////

	@Test
	public void shiftup5() {

		Range shiftRange1 = new Range(0, 10);
		double delta = 5.0;
		assertEquals("Range should be :-10 to 10", shiftRange1, Range.shift(shiftOriginal1, delta, false));
	}

	@Test
	public void shiftup5true() {

		Range shiftRange1 = new Range(0, 10);
		double delta = 5.0;
		assertEquals("Range should be :-10 to 10", shiftRange1, Range.shift(shiftOriginal1, delta, true));
	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR shiftWithNoZeroCrossing()**********
	///////////////////////////////////////////////////

	@Test
	// test will make value is equal to 0
	public void shiftWithNoZeroCrossingTest() {

		Range testMutation = new Range(0, 100);
		Range shiftedRange = Range.shift(testMutation, 5, false);
		assertEquals("The output should be 105", 105, shiftedRange.getUpperBound(), .000000001d);
	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR shift without boolean**********
	///////////////////////////////////////////////////
	@Test
	public void shiftup5NoBool() {

		Range shiftRange1 = new Range(0, 10);
		double delta = 5.0;
		assertEquals("Range should be :-10 to 10", shiftRange1, Range.shift(shiftOriginal1, delta));
	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR hashcode**********
	///////////////////////////////////////////////////
//	temp = Double.doubleToLongBits(this.lower);
//    result = (int) (temp ^ (temp >>> 32));
//    temp = Double.doubleToLongBits(this.upper);
//    result = 29 * result + (int) (temp ^ (temp >>> 32));
//    return result;
	@Test
	public void hashCode0() {
		// Range (0,0);
		long temp = Double.doubleToLongBits(0.0);
		;
		long result = (int) (temp ^ (temp >>> 32));
		result = 29 * result + (int) (temp ^ (temp >>> 32));

		assertEquals("The output should be:", result, hashRange1.hashCode());

	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR scale**********
	///////////////////////////////////////////////////
	@Test
	public void scale1() {
		// -5,10
		double factor = 1.0;
		Range scaleFactorRange1 = new Range(-5, 10);
		assertEquals("Range should be :-5 to 10", scaleFactorRange1, Range.scale(scaleRange1, factor));

	}

	@Test
	public void scale2() {
		// -5,10
		double factor = 2.0;
		Range scaleFactorRange2 = new Range(-10, 20);
		assertEquals("Range should be :-5 to 10", scaleFactorRange2, Range.scale(scaleRange1, factor));

	}

	@Test(expected = IllegalArgumentException.class)
	public void scaleNegative2() throws IllegalArgumentException {
		// -5,10
		double factor = -2.0;
		// Range scaleFactorRange2 = new Range(-10,20);
		// assertEquals("Range should be :-5 to
		// 10",scaleFactorRange2,Range.scale(scaleRange1,factor));
		Range.scale(scaleRange1, factor);

	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR Expand (range,double,double)**********
	///////////////////////////////////////////////////
	// comment out
//	@Test
//	public void expandMargin1() {
//		// Should fail do to the call of getupper bound in the function
//		// 1,10
//		double lowerM = 0.5;
//		double upperM = 0.5;
//		// lower now is double lower = range.getLowerBound() - (length * lowerMargin);
//		// upper is now : double upper = range.getUpperBound() + (length * upperMargin);
//		Range expandedMargin = new Range(-3.5, 14.5);
//		assertEquals("Range should be :-3.5 to 14.5", expandedMargin, Range.expand(expandMargin1, lowerM, upperM));
//
//	}

	///////////////////////////////////////////////////
	// ********WHITE-BOX TESTING FOR min() and max()**********
	///////////////////////////////////////////////////
	@Test
	// range2 is NaN, there fore the max and min will be NaN
	public void minAndMaxTestOne() {
		double NaN = Math.sqrt(-1);

		Range returnRange = Range.combineIgnoringNaN(myRange, new Range(NaN, NaN));

		assertEquals("The output is 100,0", 100.0, returnRange.getUpperBound(), .000000001d);
	}
	
	// Assignment 4 starts here

	// kills one mutation
		@Test
		// testing getCentral where the result is a positive number
		public void getCentralPositiveValue() {
			testMutation = new Range(2, 6);
			assertEquals("Result should be 4", 4, testMutation.getCentralValue(), .000000001d);
		}



		// killed lots of mutants in intersects
		@Test
		// testing intersects where the Range lower bound is the intersect upper bound
		public void intersectsLowerBoundEqualsUpperBound() {
			testMutation = new Range(2, 6); 
			double lower = 0;
			double upper = 2;
			boolean result = testMutation.intersects(lower, upper); 
			assertFalse("Result should be false", result);

		}

		// killed in else statement line 161
		@Test
		//testing intersects where the Range upper bound is the intersect lower bound
		public void intersectsUpperBoundEqualsLowerBound() {
			testMutation = new Range(2, 6); 
			double lower = 6;
			double upper = 8;
			boolean result = testMutation.intersects(lower, upper); 
			assertFalse("Result should be false", result);

		}

		// killed 2 in if statement line 157
		@Test
		// testing intersects where the set upper and lower bound are the same as the Range lower bound
		public void intersectsLowerBound() {
			testMutation = new Range(2, 6);
			boolean result = testMutation.intersects(2, 2);
			assertFalse("Result should be false", result);
		}

		// killed mutant on line 157
		@Test
		// testing when the intersection boundaries are the same boundaries as the Range object
		public void intersectsDecrementMutation() {
			testMutation = new Range(2, 3);
			boolean result= testMutation.intersects(2, 3);
			assertTrue("Result should be true", result);
		}

		// killed one mutatnt on line 176
		@Test
		// testing intersect where the Range does not intersect with the set values
		public void doesNotIntersectsRange() {
			testMutation = new Range(2, 6); 
			double lower = 8;
			double upper = 10;
			Range testMutation2 = new Range(lower, upper);
			boolean result = testMutation.intersects(testMutation2); 
			assertFalse("Result should be false", result);
		
		}

		@Test
		// testing minimum function when there is a NaN Range
		public void minNaNLowerBound() {
			double NaN = Math.sqrt(-1); 
			testMutation = new Range(2, 6); 
			Range result;
			result = Range.combineIgnoringNaN(testMutation, new Range(NaN, NaN)); 
			assertEquals("Result should be 2", 2, result.getLowerBound(), .000000001d);

		}

		// killed 6 mutations on line 410
		@Test
		// testing when trying to scale by a factor of 0
		public void scaleZeroFactor() {
			testMutation = new Range(2, 6);
			Range testScale = Range.scale(testMutation, 0);
			assertEquals("Result should be 0 ", 0, testScale.getLowerBound(), .000000001d);
			// assertion that expected value matches the actual value of 0
		}
		

		// killed mutations 
		@Test
		// tesitng shiftWithNoZeroCrossing when the Range we are testing has upper and lower bound of 0
		public void shiftWithNoZeroCrossingValueEqualsZero() {
			testMutation = new Range(0, 0);
			Range result= Range.shift(testMutation, 200, false);
			assertEquals("Result should be 200 ", 200, result.getUpperBound(), .000000001d);

		}

		@Test
		// tesitng shiftWithNoZeroCrossing when the Range we are testing has upper and lower bound are negative
		public void shiftWithNoZeroCrossingValueIsNegative() {
			testMutation = new Range(-6, -2);
			Range result = Range.shift(testMutation, -200, false);
			assertEquals("Result should be -202 ", -202, result.getUpperBound(), .000000001d);

		}


		@Test
		// testing when upper bounds are equal but lower bounds are not equal
		public void equalsDifferentLowerBound() {
			testMutation = new Range(2, 6);
			boolean result = testMutation.equals(new Range(4, 6));
			assertFalse("Result should be false", result);

		}
		

		@Test
		// testing the hashing method to see the correctness of the hash
		public void hashCodeTest() {
			testMutation = new Range(2, 6);
			int result = testMutation.hashCode();
			assertEquals("Result should be ->", -2145910784, result);
			
		}

		@Test
		// testing when constrain value is right on the lower bound
		public void constrainDecrementMutation() {
			testMutation = new Range(1, 4);
			double result = testMutation.constrain(1);
			assertEquals("Result should be 1 ", 1, result, .000000001d);

		}
		
		
		@Test
		// testing constrain function when constrain value is below lower bound
		public void constrainBelowLowerRange() {
			testMutation = new Range(2, 6); 
			double result = testMutation.constrain(1); 
			assertEquals("Result should be 2", 2, result, .000000001d);

		}




	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}




