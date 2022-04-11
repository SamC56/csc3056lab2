package org.jfree.data.test;

import static org.junit.Assert.assertArrayEquals;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class DataUtilitiesTest extends TestCase {
	
	private Values2D values2D;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	protected void setUp() throws Exception {
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 1);
		testValues.addValue(3, 1, 0);
	}
	
	@After
	protected void tearDown() throws Exception {
		values2D = null;
	}

	@Test
	public void testValidDataAndColumnTotal() {
		assertEquals("Wrong sum returned. It should be 5.0", 4.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	//WECT1
	@Test
	public void testNoValuesAddedToValues2DColumnTotal()
	{
		DefaultKeyedValues2D testNoValues = new DefaultKeyedValues2D();
		assertEquals("Wrong sum returned. It should be 0.0", 0.0, DataUtilities.calculateColumnTotal(testNoValues, 0), 0.0000001d);
	}
	
	//WECT2
	@Test
	public void testOneValueAddedToValues2DColumnTotal()
	{
		DefaultKeyedValues2D testOneValue = new DefaultKeyedValues2D();
		testOneValue.addValue(5, 1, 99);
		assertEquals("Wrong sum returned. It should be 5.0", 5.0, DataUtilities.calculateColumnTotal(testOneValue, 99), 0.0000001d);
	}
	
	
	//WECT3
	@Test
	public void testThreeValuesAddedToValues2DColumnTotal()
	{
		DefaultKeyedValues2D testThreeValues = new DefaultKeyedValues2D();
		testThreeValues.addValue(5, 0, 0);
		testThreeValues.addValue(2, 1, 3);
		testThreeValues.addValue(7, 2, 0);
		assertEquals("Wrong sum returned. It should be 12.0", 12.0, DataUtilities.calculateColumnTotal(testThreeValues, 0), 0.0000001d);
	}
	
	
	/* Commented out as stops compiler for rest of tests
	//WECT4
	@Test
	public void testNullAddedToValues2DColumnTotal()
	{
		DefaultKeyedValues2D testThreeValues = new DefaultKeyedValues2D();
		testThreeValues.addValue(null, null, null);
		assertEquals("Wrong sum returned. It should be 12.0", 12.0, DataUtilities.calculateColumnTotal(testThreeValues, null), 0.0000001d);
	}
	*/
	
	//WECT5
	@Test
	public void testNullDataColumnTotal()
	{
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	//WECT6
	@Test
	public void testTwoValuesAddedToValues2DColumnTotal() {
		DefaultKeyedValues2D testTwoValues = new DefaultKeyedValues2D();
		testTwoValues.addValue(2, 0, 0);
		testTwoValues.addValue(1, 1, 0);
		assertEquals("Wrong sum returned. It should be 3.0", 3.0, DataUtilities.calculateColumnTotal(testTwoValues, 0), 0.0000001d);
	}
	
	//WECT7
	@Test
	public void testNoValuesAddedToValues2DRowTotal()
	{
		DefaultKeyedValues2D testNoValues = new DefaultKeyedValues2D();
		assertEquals("Wrong sum returned. It should be 0.0", 0.0, DataUtilities.calculateRowTotal(testNoValues, 0), 0.0000001d);
	}
	
	//WECT8
	@Test
	public void testOneValueAddedToValues2DRowTotal()
	{
		DefaultKeyedValues2D testOneValue = new DefaultKeyedValues2D();
		testOneValue.addValue(5, 99, 1);
		assertEquals("Wrong sum returned. It should be 5.0", 5.0, DataUtilities.calculateRowTotal(testOneValue, 99), 0.0000001d);
	}
	
	//WECT9
	@Test
	public void testThreeValuesAddedToValues2DRowTotal()
	{
		DefaultKeyedValues2D testThreeValues = new DefaultKeyedValues2D();
		testThreeValues.addValue(5, 0, 0);
		testThreeValues.addValue(2, 1, 3);
		testThreeValues.addValue(7, 0, 2);
		assertEquals("Wrong sum returned. It should be 12.0", 12.0, DataUtilities.calculateRowTotal(testThreeValues, 0), 0.0000001d);
	}
	
	/* Commented out as stops compiler for rest of tests
	//WECT10
	@Test
	public void testNullAddedToValues2DRowTotal()
	{
		DefaultKeyedValues2D testThreeValues = new DefaultKeyedValues2D();
		testThreeValues.addValue(null, null, null);
		assertEquals("Wrong sum returned. It should be 12.0", 12.0, DataUtilities.calculateRowTotal(testThreeValues, null), 0.0000001d);
	}
	*/
	
	//WECT11
	@Test
	public void testNullDataRowTotal()
	{
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	//WECT12
	@Test
	public void testTwoValuesAddedToValues2DRowTotal() {
		DefaultKeyedValues2D testTwoValues = new DefaultKeyedValues2D();
		testTwoValues.addValue(2, 0, 0);
		testTwoValues.addValue(1, 0, 1);
		assertEquals("Wrong sum returned. It should be 3.0", 3.0, DataUtilities.calculateRowTotal(testTwoValues, 0), 0.0000001d);
	}
	
	//SECT1
	@Test
	public void testEmptyArrayCreateNumberArray() {
		double[] testArray = new double[0];
		Number[] testNumberArray = new Number[0];
		assertArrayEquals("Incorrect Array returned. it should be []", testNumberArray, DataUtilities.createNumberArray(testArray));
	}
	
	//SECT2
	@Test
	public void testOneElementArrayCreateNumberArray() {
		double[] testArray = {1.0};
		Number[] testNumberArray = {1.0};
		assertArrayEquals("Incorrect Array returned. it should be [1.0]", testNumberArray, DataUtilities.createNumberArray(testArray));
	}
	
	//SECT3
	@Test
	public void testMultipleElementArrayCreateNumberArray() {
		double[] testArray = {1.0, 5.4, 6.0};
		Number[] testNumberArray = {1.0, 5.4, 6.0};
		assertArrayEquals("Incorrect Array returned. it should be [1.0, 5.4, 6.0]", testNumberArray, DataUtilities.createNumberArray(testArray));
	}
	
	//SECT4
	@Test
	public void testNullArrayCreateNumberArray() {
		try {
			DataUtilities.createNumberArray(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	//SECT5
	@Test
	public void testEmptyArrayInArray2DArrayCreateNumberArray() {
		double[][] testArray = {{}};
		Number[][] testNumberArray = {{}};
		assertArrayEquals("Incorrect Array returned. it should be [[]]", testNumberArray, DataUtilities.createNumberArray2D(testArray));
	}
	
	//SECT6
	@Test
	public void testOneElementArrayInArray2DArrayCreateNumberArray() {
		double[][] testArray = {{1.0}};
		Number[][] testNumberArray = {{1.0}};
		assertArrayEquals("Incorrect Array returned. it should be [[1.0]]", testNumberArray, DataUtilities.createNumberArray2D(testArray));
	}
	
	//SECT7
	@Test
	public void testTwoElementArrayInArray2DArrayCreateNumberArray() {
		double[][] testArray = {{1.0, 5.4}};
		Number[][] testNumberArray = {{1.0, 5.4}};
		assertArrayEquals("Incorrect Array returned. it should be [[1.0, 5.4]]", testNumberArray, DataUtilities.createNumberArray2D(testArray));
	}
	
	/*
	//SECT8
	@Test
	public void testNullElementArrayInArray2DArrayCreateNumberArray() {
		double[][] testArray = {{null}}; // This causes it to not compile
		try {
			DataUtilities.createNumberArray2D(testArray);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}
	*/
	
	//SECT9
	@Test
	public void testTwoOneElementArraysInArray2DArrayCreateNumberArray() {
		double[][] testArray = {{1.0}, {5.4}};
		Number[][] testNumberArray = {{1.0}, {5.4}};
		assertArrayEquals("Incorrect Array returned. it should be [[1.0],[5.4]]", testNumberArray, DataUtilities.createNumberArray2D(testArray));
	}
	
	//SECT10
	@Test
	public void testOneTwoElementArrayAndOneOneElementArrayInArray2DArrayCreateNumberArray() {
		double[][] testArray = {{1.0, 5.4}, {3.0}};
		Number[][] testNumberArray = {{1.0, 5.4}, {3.0}};
		assertArrayEquals("Incorrect Array returned. it should be [[1.0, 5.4],[3.0]]", testNumberArray, DataUtilities.createNumberArray2D(testArray));
	}
	
	//SECT11
	@Test
	public void testOneOneElementArrayAndOneTwoElementArrayInArray2DArrayCreateNumberArray() {
		double[][] testArray = {{1.0}, {3.0, 5.4}};
		Number[][] testNumberArray = {{1.0}, {3.0, 5.4}};
		assertArrayEquals("Incorrect Array returned. it should be [[1.0],[3.0, 5.4]]", testNumberArray, DataUtilities.createNumberArray2D(testArray));
	}
	
	
	//SECT12
	@Test
	public void testNullInput2DArrayCreateNumberArray() {
		try {
			DataUtilities.createNumberArray2D(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	//SECT13
	@Test
	public void testTwoTwoElementArraysInArray2DArrayCreateNumberArray() {
		double[][] testArray = {{1.0, 6.9}, {3.0, 5.4}};
		Number[][] testNumberArray = {{1.0, 6.9}, {3.0, 5.4}};
		assertArrayEquals("Incorrect Array returned. it should be [[1.0, 6.9],[3.0, 5.4]]", testNumberArray, DataUtilities.createNumberArray2D(testArray));
	}
	
	@Test
	public void testOneValueGetCumulativePercentages() {
		DefaultKeyedValues testValues = new DefaultKeyedValues();
		testValues.addValue((Integer)0, 5.0);
		
		DefaultKeyedValues expectedResult = new DefaultKeyedValues();
		expectedResult.addValue((Integer)0, 1.0);
		
		assertEquals("Wrong result returned.", expectedResult.getValue(0).doubleValue(), DataUtilities.getCumulativePercentages(testValues).getValue(0).doubleValue(), 0.0000001d);
	}
	
	//SECT15
	@Test
	public void testTwoValuesGetCumulativePercentages() {
		DefaultKeyedValues testValues = new DefaultKeyedValues();
		testValues.addValue((Integer)0, 5.0);
		testValues.addValue((Integer)1, 9.0);
		
		DefaultKeyedValues expectedResult = new DefaultKeyedValues();
		expectedResult.addValue((Integer)0, 0.3125);
		expectedResult.addValue((Integer)1, 0.875);
		
		assertEquals("Wrong result returned.", expectedResult.getValue(1).doubleValue(), DataUtilities.getCumulativePercentages(testValues).getValue(1).doubleValue(), 0.0000001d);
	}

	//SECT16
	@Test
	public void testNoValuesGetCumulativePercentages() {
		DefaultKeyedValues testValues = new DefaultKeyedValues();
		assertEquals("Wrong result returned.", 0, DataUtilities.getCumulativePercentages(testValues).getItemCount(), 0.0000001d);
	}
	
	//SECT17
	@Test
	public void testNullInputGetCumulativePercentages() {
		try {
			DataUtilities.getCumulativePercentages(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}
}
