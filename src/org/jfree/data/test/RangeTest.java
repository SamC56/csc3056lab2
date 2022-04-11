package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase {
	
	private Range rangeObjectUnderTest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-5, 5);
		
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	// Tests relating to contains() method
	@Test
	public void testContainsValueSmallerThanLower() {
		assertFalse("contains: Did not return expected output", rangeObjectUnderTest.contains(-10));
	}
	
	@Test
	public void testContainsValueLargerThanUpper() {
		assertFalse("contains: Did not return expected output", rangeObjectUnderTest.contains(10));
	}

	@Test
	public void testContainsValueEqualToLower() {
		assertTrue("contains: Did not return expected output", rangeObjectUnderTest.contains(-5));
	}
	
	@Test
	public void testContainsValueEqualToUpper() {
		assertTrue("contains: Did not return expected output", rangeObjectUnderTest.contains(5));
	}
	
	@Test
	public void testContainsValueInRange() {
		assertTrue("contains: Did not return expected output", rangeObjectUnderTest.contains(1));
	}
	
	// Tests relating to getLowerBound() method
	@Test
	public void testLowerEqualToUpper() {
		Range tempRange = new Range(5, 5);
		assertEquals("getLowerBound: Did not return the expected output", 5.0, tempRange.getLowerBound());
	}
	
	@Test
	public void testLowerAsNegative() {
		Range tempRange = new Range(-5, 100);
		assertEquals("getLowerBound: Did not return the expected output", -5.0, tempRange.getLowerBound());
	}
	
	@Test
	public void testLowerAsPositive() {
		Range tempRange = new Range(10, 200);
		assertEquals("getLowerBound: Did not return the expected output", 10.0, tempRange.getLowerBound());
	}
	
	// Tests relating to intersects() method
	@Test
	public void testIntersectsGivenLowerGreaterThanRangeUpper() {
		assertFalse("intersects: Did not return the expected output", rangeObjectUnderTest.intersects(7, 10));
	}
	
	@Test
	public void testIntersectsGivenUpperSmallerThanRangeLower() {
		assertFalse("intersects: Did not return the expected output", rangeObjectUnderTest.intersects(-10, -7));
	}
	
	@Test
	public void testIntersectsOnlyGivenUpperInsideRange() {
		assertTrue("intersects: Did not return the expected output", rangeObjectUnderTest.intersects(-10, -2));
	}
	
	@Test
	public void testIntersectsOnlyGivenLowerInsideRange() {
		assertTrue("intersects: Did not return the expected output", rangeObjectUnderTest.intersects(2, 10));
	}
	
	@Test
	public void testIntersectsBothGivenInsideRange() {
		assertTrue("intersects: Did not return the expected output", rangeObjectUnderTest.intersects(-3, 3));
	}
	
	@Test
	public void testIntersectsGivenLowerGreaterThanGivenUpper() {
		assertFalse("intersects: Did not return the expected output", rangeObjectUnderTest.intersects(3, 1));
	}
	
	// Tests relating to constrain() method
	@Test
	public void testConstrainValueGreaterThanUpperBound() {
		assertEquals("constrain: Did not return expected output", 5.0, rangeObjectUnderTest.constrain(7));
	}
	
	@Test
	public void testConstrainValueSmallerThanLowerBound() {
		assertEquals("constrain: Did not return expected output", -5.0, rangeObjectUnderTest.constrain(-10));
	}
	
	@Test
	public void testConstrainValueEqualToUpperBound() {
		assertEquals("constrain: Did not return expected output", 5.0, rangeObjectUnderTest.constrain(5));
	}
	
	@Test
	public void testConstrainValueEqualToLowerBound() {
		assertEquals("constrain: Did not return expected output", -5.0, rangeObjectUnderTest.constrain(-5));
	}
	
	@Test
	public void testConstrainValueInsideRange() {
		assertEquals("constrain: Did not return expected output", 1.0, rangeObjectUnderTest.constrain(1));
	}
	
	// Tests relating to getCentralValue() method
	@Test
	public void testCentralBothBoundsEqual() {
		Range tempRange = new Range(5, 5);
		assertEquals("getCentralValue: Did not return expected output", 5.0, tempRange.getCentralValue());
	}
	
	@Test
	public void testCentralPositiveUpperNegativeLower() {
		Range tempRange = new Range(-5, 5);
		assertEquals("getCentralValue: Did not return expected output", 0.0, tempRange.getCentralValue());
	}
	
	@Test
	public void testCentralBothBoundsPositive() {
		Range tempRange = new Range(1, 10);
		assertEquals("getCentralValue: Did not return expected output", 5.5, tempRange.getCentralValue());
	}
	
	@Test
	public void testCentralBothBoundsNegative() {
		Range tempRange = new Range(-15, -5);
		assertEquals("getCentralValue: Did not return expected output", -10.0, tempRange.getCentralValue());
	}
}
