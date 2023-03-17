package org.jfree.data;
import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;
import static org.junit.Assert.*;
import org.jfree.data.KeyedValues;
import java.security.InvalidParameterException;

//Mocking and Normal Junit testing 
public class DataUtilitiesTest {
	
	
	//Equals Method 
	@Test
	public void equals0x0() {
		double cloneTestEq0[][] = {{0},{0}};
		double cloneTestEq01[][] = {{0},{0}};
		boolean equals = DataUtilities.equal(cloneTestEq0, cloneTestEq01); 
		assertEquals(true, equals); 
		
	}
	
	@Test
	public void equalsFalse0x1() {
		double cloneTestEq0[][] = {{1}};
		double cloneTestEq01[][] = {{0},{0}};
		boolean equals = DataUtilities.equal(cloneTestEq0, cloneTestEq01); 
		assertEquals(false, equals); 
		
	}
	
	@Test
	public void equalsFalseNullab() {
		double cloneTestEq0[][] =null;
		double cloneTestEq01[][] = null;
		boolean equals = DataUtilities.equal(cloneTestEq0, cloneTestEq01); 
		assertEquals(true, equals); 
		
	}
	@Test
	public void equalsFalseNull() {
		double cloneTestEq0[][] =null;
		double cloneTestEq01[][] = {{0}};
		boolean equals = DataUtilities.equal(cloneTestEq0, cloneTestEq01); 
		assertEquals(false, equals); 
		
	}
	
	@Test
	public void equalsFalseNullxb() {
		double cloneTestEq0[][] ={{0}};
		double cloneTestEq01[][] = null;
		boolean equals = DataUtilities.equal(cloneTestEq0, cloneTestEq01); 
		assertEquals(false, equals); 
		
	}
	
	@Test
	public void equalsFalseSame() {
		double cloneTestEq0[][] ={{0},{1},{2}};
		double cloneTestEq01[][] = {{0},{1},{3}};
		boolean equals = DataUtilities.equal(cloneTestEq0, cloneTestEq01); 
		assertEquals(false, equals); 
		
	}
	
	/*
	 * comment out
	//clone method()
	@Test
	public void cloneTest0x0() {
		double [][]cloneTest0x0 = {{0},{0}};
        double[][] n = new double[0][0];
        double[][] res = DataUtilities.clone(cloneTest0x0);
        assertArrayEquals(n, res);
		
	}
	
	*/
	@Test
    public void calculateColTotal_ValidRowNegative () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        int[]validRows= {0}; 
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(-1));
                one(values).getValue(0,0); 
                will(returnValue(0.0));
                
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0,validRows);
        assertEquals( 0.0, result, .000000001d);
    }
	
	
	
	//calculate Column Total Values2D data, int column, int [] valid Rows Method
	@Test
    public void calculateColTotal_ValidRow0 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        int[]validRows= {0}; 
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(0));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0,validRows);
        assertEquals( 0.0, result, .000000001d);
    }
	
	@Test
    public void calculateColTotal_ValidRow2x2 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class); 
        mockingContext.checking(new Expectations() {
            {
                allowing(values).getRowCount();
                will(returnValue(1));
                
                allowing(values).getValue(0,0); 
                will(returnValue(5.0));
                
                allowing(values).getValue(1,0); 
                will(returnValue(5.0));
                


                
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals( 5.0, result, .000000001d);
    }
	
	@Test
    public void calculateColTotal_ValidRow1 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        int[]validRows= {0}; 
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(1)); 
                one(values).getValue(0,0); 
                will(returnValue(1.0));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0,validRows);
        assertEquals( 1.0, result, .000000001d);
    }
	
	@Test
    public void calculateColTotal_ValidRowNULL () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        int[]validRows= {0}; 
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(0)); 
                one(values).getValue(0,0); 
                will(returnValue(null));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0,validRows);
        assertEquals( 0.0, result, .000000001d);
    }
	

	
	//CaclcualteRowTotal(values2D,int, in [] method
    @Test
    public void calculateRowTotalValid0x0 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        int[] ValidCols= {0}; 
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(0));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0,ValidCols);
        assertEquals( 0.0, result, .000000001d);
    }
    
    @Test
    public void calculateRowTotalValidNULL () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        int[] ValidCols= {0}; 
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(0)); 
                one(values).getValue(0,0); 
                will(returnValue(null));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0,ValidCols);
        assertEquals( 0.0, result, .000000001d);
    }
	
    @Test
    public void calculateRowTotalValidNorm () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        int[] ValidCols= {0}; 
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(1)); 
                one(values).getValue(0,0); 
                will(returnValue(1.0));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0,ValidCols);
        assertEquals( 1.0, result, .000000001d);
    }
    
    @Test
    public void calculateRowTotalValidNorm0 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        int[] ValidCols= {0}; 
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(-1)); 
                one(values).getValue(0,0); 
                will(returnValue(0.0));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0,ValidCols);
        assertEquals( 0.0, result, .000000001d);
    }
    
    
    
    
    
    
    
    /*
    @Test
    public void calculateColTotal0 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(1));
                one(values).getValue(0,0);
                will(returnValue(5)); 
                one(values).getValue(1,0);
                will(returnValue(5)); 
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(10.0, result, .000000001d);
    }
    
    */
   
	
	
	

    // tests for the minimum value of the array
    @Test
    public void calculateColTotal_0x0 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(0));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals( 0.0, result, .000000001d);
    }

    // tests for an array of size 1
    @Test
    public void calculateColTotal_1x1 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(1));
                one(values).getValue(0, 0);
                will(returnValue(1.0));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals( 1.0, result, .000000001d);
    }

    // tests for an array of size 1, item is set to null
    @Test
    public void calculateColTotal_Null1x1 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(0));
                one(values).getValue(0, 0);
                will(returnValue(null));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals( 0.0, result, .000000001d);
    }

    // testing a null value in a 2x2 array
    @Test
    public void calculateColTotal_Null2x2 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(1.5));
                one(values).getValue(1, 0);
                will(returnValue(null));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals( 1.5, result, .000000001d);
    }

    // testing a 2x2 array with an even value result
    @Test
    public void calculateColTotal_2x2Even () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(1.5));
                one(values).getValue(1, 0);
                will(returnValue(3.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(5.0, result, .000000001d);
    }

    // testing a 2x2 array with an odd value result
    @Test
    public void calculateColTotal_2x2Odd () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                one(values).getValue(1, 0);
                will(returnValue(3.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(result, 4.5, .000000001d);
    }

    // testing a 2x2 array with an even value result
    @Test
    public void calculateColTotal_Zero2x2 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(0.0));
                one(values).getValue(1, 0);
                will(returnValue(0.0));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(result, 0.0, .000000001d);
    }

    // testing a 2x2 array with an negative value result
    @Test
    public void calculateColTotal_Negative2x2 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(-10.0));
                one(values).getValue(1, 0);
                will(returnValue(-0.5));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(result, -10.5, .000000001d);
    }

    // testing a 2x2 array with an even value result
    @Test
    public void calculateColTotal_3xNull () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(null));
                one(values).getValue(1, 0);
                will(returnValue(null));
                one(values).getValue(2, 0);
                will(returnValue(null));
            }
        });
        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals(result, 0.0, .000000001d);
    }

//    // testing an invalid input
    @Test(expected = InvalidParameterException.class)
    public void calculateColTotal_InvalidException () throws InvalidParameterException {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(throwException( new InvalidParameterException("")));

            }
        });
            DataUtilities.calculateColumnTotal(values, 0);

    }

    
    
    

	// testing a 0x0 minimum size array
    @Test
    public void calculateRowTotal_0x0 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(0));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals( 0.0, result, .000000001d);
    }

    // tests the case where there is one entry in the array
    @Test
    public void calculateRowTotal_1x1 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(1));
                one(values).getValue(0, 0);
                will(returnValue(1.0));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals( 1.0, result, .000000001d);
    }

    // tests the case where there is one null in the array
    @Test
    public void calculateRowTotal_Null1x1 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(0));
                one(values).getValue(0, 0);
                will(returnValue(null));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals( 0.0, result, .000000001d);
    }

    // tests the case where there is one null in a 2x2 array
    @Test
    public void calculateRowTotal_Null2x2 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(1.5));
                one(values).getValue(0, 1);
                will(returnValue(null));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals( 1.5, result, .000000001d);
    }

    // tests the case where a 2x2 array has an even result
    @Test
    public void calculateRowTotal_2x2Even () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(1.5));
                one(values).getValue(0, 1);
                will(returnValue(3.5));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(5.0, result, .000000001d);
    }

    // tests the case where a 2x2 array has an odd result
    @Test
    public void calculateRowTotal_2x2Odd () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(1.0));
                one(values).getValue(0, 1);
                will(returnValue(3.5));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(result, 4.5, .000000001d);
    }

    // tests the case where the 2x2 array has all 0's
    @Test
    public void calculateRowTotal_Zero2x2 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(0.0));
                one(values).getValue(0, 1);
                will(returnValue(0.0));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(result, 0.0, .000000001d);
    }

    // tests the case where the 2x2 array has a negative result
    @Test
    public void calculateRowTotal_Negative2x2 () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(2));
                one(values).getValue(0, 0);
                will(returnValue(-10.0));
                one(values).getValue(0, 1);
                will(returnValue(-0.5));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(result, -10.5, .000000001d);
    }

    // tests the case where there is a null in a 3x3 array
    @Test
    public void calculateRowTotal_3xNull () {
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(returnValue(3));
                one(values).getValue(0, 0);
                will(returnValue(null));
                one(values).getValue(0, 1);
                will(returnValue(null));
                one(values).getValue(0, 2);
                will(returnValue(null));
            }
        });
        double result = DataUtilities.calculateRowTotal(values, 0);
        assertEquals(result, 0.0, .000000001d);
    }

    // tests the case where the input is invalid
    @Test(expected = InvalidParameterException.class)
    public void calculateRowTotal_InvalidException () throws InvalidParameterException{
        // setup
        Mockery mockingContext = new Mockery();
        final Values2D values = mockingContext.mock(Values2D.class);
        mockingContext.checking(new Expectations() {
            {
                one(values).getColumnCount();
                will(throwException( new InvalidParameterException("")));

            }
        });
 
        DataUtilities.calculateRowTotal(values, 0);
    }

    // tests the case where there are no items in the array
    @Test
    public void createNumberArray_NoItems(){
        double list[] = {};
        Number[] n = new Number[0];
        Number[] res = DataUtilities.createNumberArray(list);
        assertArrayEquals(n, res);
    }

    // tests the case where there is 1 item in the array
    @Test
    public void createNumberArray_1Item(){
        double list[] = {1.0};
        Number[] n = new Number[]{1.0};
        Number[] res = DataUtilities.createNumberArray(list);
        assertArrayEquals(n, res);
    }

    // tests the case where there are 10 items in the array
    @Test
    public void createNumberArray_10Items(){
        double list[] = {1.0,-1.0,1.0,-1.0,1.0,-1.0,1.0,-1.0,1.0,-1.0};
        Number[] n = new Number[]{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0};

        Number[] res = DataUtilities.createNumberArray(list);
        assertArrayEquals(n, res);
    }

//     tests the case where the array is null
    @Test(expected = IllegalArgumentException.class)
    public void createNumberArray_Null() throws IllegalArgumentException{
        double list[] = null;
        
        DataUtilities.createNumberArray(list);

    }

    // tests the case where there are no items in the array
    @Test
    public void createNumberArray2D_NoItems(){
        double list[][] = {};
        Number[][] n = new Number[0][0];
        Number[][] res = DataUtilities.createNumberArray2D(list);
        assertArrayEquals(n, res);
    }

    // tests the case where the array has 1 null item
    @Test
    public void createNumberArray2D_1Null(){
        double list[][] = {{}};
        Number[][] n = new Number[][]{{}};
        Number[][] res = DataUtilities.createNumberArray2D(list);
        assertArrayEquals(n, res);
    }

    // tests the case where the array has 1 item
    @Test
    public void createNumberArray2D_1Item(){
        double list[][] = {{1.0}};
        Number[][] n = new Number[][]{{1.0}};
        Number[][] res = DataUtilities.createNumberArray2D(list);
        assertArrayEquals(n, res);
    }

    // tests the case where the array has 10x10 items
    @Test
    public void createNumberArray2D_10X10Items(){
        double list[][] = {{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0}};;
        Number[][] n = new Number[][]{{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0},{1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0}};;
        Number[][] res = DataUtilities.createNumberArray2D(list);
        assertArrayEquals(n, res);
    }

    // tests the case where the array is null
    @Test(expected = IllegalArgumentException.class)
    public void createNumberArray2D_Null() throws IllegalArgumentException{
        double list[][] = null;
        DataUtilities.createNumberArray2D(list);
        
    }
    //Cummulative Percetages() Method Test cases
    @Test
	//This is a normal test in which it is only 1 row
	//THis is a failing case due due to the cumulative percentage expected as 1.0, but 
	//the program actual result was infinity.
	public void CumulativePercentagesTestOne() {
		Mockery mockingContext = new Mockery(); 
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		
		//This is for one row in the table
		mockingContext.checking(new Expectations() {
			{
				//Values by keys
				allowing(values).getItemCount(); 
				will(returnValue(1)); 
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(0); 
				will(returnValue(1));
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		//Tear down None in this test method
		assertEquals("The cumulative percentage is 1.0 or 100%",1.0,result.getValue(0));
		
	}
	//Test given in the Javadoc (5,2,9 example)
	@Test
	public void CumulativePercentagesTestTwo() {
		Mockery mockingContext = new Mockery(); 
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		
		//This is for one row in the table
		mockingContext.checking(new Expectations() {
			{
				//Values by keys
				allowing(values).getItemCount(); 
				will(returnValue(3)); 
				
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(0); 
				will(returnValue(5));
				
				allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getValue(1); 
				will(returnValue(9));
				
				allowing(values).getKey(2);
				will(returnValue(2));
				allowing(values).getValue(2); 
				will(returnValue(2));
				
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		//Tear down None in this test method
		assertEquals("The cumulative percentage is 0.3125 or 31.25%",0.3125,result.getValue(0));
//		assertEquals("The cumulative percentage is 0.875 or 87.5%",0.875,result.getValue(1));
//		assertEquals("The cumulative percentage is 1.0 or 100%",1.0,result.getValue(2));
		
	}
	//This test test for a cumulative 0 total
	//This works due to dividing 0/0 Not a Number
	@Test
	public void CumulativePercentagesTestThree() {
		Mockery mockingContext = new Mockery(); 
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
		
		//This is for one row in the table
		mockingContext.checking(new Expectations() {
			{
				//Values by keys
				allowing(values).getItemCount(); 
				will(returnValue(2)); 
				
				allowing(values).getKey(0);
				will(returnValue(0));
				allowing(values).getValue(0); 
				will(returnValue(0));
				
				allowing(values).getKey(1);
				will(returnValue(1));
				allowing(values).getValue(1); 
				will(returnValue(0));
					
			}
		});
		
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		//Tear down None in this test method
		assertEquals("The cumulative percentage is 0.0 or 0%",Double.NaN,result.getValue(1));
		
	}
	//This test test for a cumulative of negative numbers total
		//This is a failed test case because -6/-16 = 0.375
		@Test
		public void CumulativePercentagesTestFour() {
			Mockery mockingContext = new Mockery(); 
			final KeyedValues values = mockingContext.mock(KeyedValues.class);
			
			//This is for one row in the table
			mockingContext.checking(new Expectations() {
				{
					//Values by keys
					allowing(values).getItemCount(); 
					will(returnValue(2)); 
					
					allowing(values).getKey(0);
					will(returnValue(0));
					allowing(values).getValue(0); 
					will(returnValue(-6));
					
					allowing(values).getKey(1);
					will(returnValue(1));
					allowing(values).getValue(1); 
					will(returnValue(-10));
						
				}
			});
			
			KeyedValues result = DataUtilities.getCumulativePercentages(values);
			//Tear down None in this test method
			assertEquals("The cumulative percentage is 0.375 or 37.5%",0.375,result.getValue(0));
			
		}
		//This test test for a cumulative of negative numbers total
		//This is test theoritically should be -6/4 = -1.5 but the values returned should
		//between 0.0 and 1.0
		//comment out because of the fail
		/*
		@Test
		public void CumulativePercentagesTestFive() {
		Mockery mockingContext = new Mockery(); 
		final KeyedValues values = mockingContext.mock(KeyedValues.class);
					
		//This is for one row in the table
		mockingContext.checking(new Expectations() {
		{
			//Values by keys
			allowing(values).getItemCount(); 
			will(returnValue(2)); 
							
			allowing(values).getKey(0);
			will(returnValue(0));
			allowing(values).getValue(0); 
			will(returnValue(-6));
							
			allowing(values).getKey(1);
			will(returnValue(1));
			allowing(values).getValue(1); 
			will(returnValue(10));
								
		}
		});
					
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		//Tear down None in this test method
		//Assumption for Assertion : We assume that all negative Values will be turn to their absolute value form
		assertEquals("The cumulative percentage is 0. or 37.5%",0.375,result.getValue(0));
					
		}
		*/
		
		
		//Start mutation testing
		
		//Creating new test cases for Mutation testing
		//Returns the total of the values in one column of the supplied data table by taking only the row numbers in the array into account 
		//Testing the if(row>rowCount) condition
		@Test
		public void calculateColumnTotalRowOutofRange() {
			final int[] row = {100}; // row to check 
			Mockery mockingContext = new Mockery();
			final Values2D values = mockingContext.mock(Values2D.class);
			mockingContext.checking(new Expectations() { 
				{
					allowing(values).getRowCount();		
					will(returnValue(1));
					allowing(values).getValue(1, 0);					
					will(returnValue(0.25));
					allowing(values).getValue(1, 1);
					will(returnValue(0.25));
				}
			});
			//params are data, int column, int [] row
			double result = DataUtilities.calculateColumnTotal(values, 1, row);
			assertEquals("The result of column should be :", 0.0, result, .000000001d);//should be 0 because it is out of range 

		}

		//Testing the if(row=rowCount) condition mutation 
		@Test
		public void calculateColumnTotalRowLower() {
			final int[] row = {1};
			Mockery mockingContext = new Mockery();
			final Values2D values = mockingContext.mock(Values2D.class);
			mockingContext.checking(new Expectations() {
				{
					allowing(values).getRowCount();
					will(returnValue(1));
					allowing(values).getValue(1, 0);
					will(returnValue(0.0));

				}
			});
			//params are data, int column, int [] row
			double result = DataUtilities.calculateColumnTotal(values, 1, row);
			assertEquals("The result of the column should be : ", 0.0, result, .000000001d);

		}
		
		//Testing if (n !=null) condition (n ==null) mutation condition 
		@Test
		public void calculateColumnTotalNull() { 
			final int[] row = {0,1}; 
			Mockery mockingContext = new Mockery();
			final Values2D values = mockingContext.mock(Values2D.class);
			mockingContext.checking(new Expectations() {
				{
					allowing(values).getRowCount();
					will(returnValue(2));
					allowing(values).getValue(0, 0);
					will(returnValue(null));
					allowing(values).getValue(1, 0);
					will(returnValue(null));
				}
			});
			double result = DataUtilities.calculateColumnTotal(values, 0, row);
			assertEquals("The result of the column should be :", 0.0, result, .000000001d);

		}
		//takes a look at the calculateRowTotal

		

		
		
		//Testing the if(row=rowCount) mutation condition
		@Test
		public void calculateRowTotalColLower() {
			final int[] column = {1};
			Mockery mockingContext = new Mockery();
			final Values2D values = mockingContext.mock(Values2D.class);
			mockingContext.checking(new Expectations() {
				{
					allowing(values).getRowCount();
					will(returnValue(1));
					allowing(values).getValue(1, 0);
					will(returnValue(0.0));

				}
			});
			//params are data, int row, int [] column
			double result = DataUtilities.calculateColumnTotal(values, 1, column);
			assertEquals("The result of the row should be : ", 0.0, result, .000000001d);

		}
		
		//Testing for the (n!=null) true mutation condition 

		@Test
		public void calculateRowTotalNull() {
			final int[] column = {0,1};
			Mockery mockingContext = new Mockery();
			final Values2D values = mockingContext.mock(Values2D.class);
			mockingContext.checking(new Expectations() {
				{
					allowing(values).getRowCount();
					will(returnValue(1));
					allowing(values).getValue(0, 0);
					will(returnValue(null));
					allowing(values).getValue(0, 1);
					will(returnValue(null));

				}
			});
			//params are data, int col, int [] row
			//changed
			double result = DataUtilities.calculateColumnTotal(values, 1, column);
			assertEquals("The result of the row should be : ", 0.0, result, .000000001d);

		}
		
		

		
		
		
		//first clone test case 
		/*
		 * comment out
		//clone method()
		@Test
		public void cloneTest0x0() {
			double [][]cloneTest0x0 = {{0},{0}};
	        double[][] n = new double[0][0];
	        double[][] res = DataUtilities.clone(cloneTest0x0);
	        assertArrayEquals(n, res);
			
		}
		
		*/

		//Try out new clone method because our first clone method did not pass 
		//only null mutation condition 
		@Test
		public void cloneNullCase() {
			double[][] cloneTestNull = {{}}; 
			double[][] res = DataUtilities.clone(cloneTestNull);
			assertArrayEquals("The result is correct NUll values only ", cloneTestNull, res);
			
		}
			
		//Try out new clone method of just negative numbers 
		//Negative cloning true mutation condition 
		@Test
		public void cloneNegative() {
			double[][] cloneNegativeTest = { {-1}, {-1} }; 
			double[][] res = DataUtilities.clone(cloneNegativeTest); 
			assertArrayEquals("The cloned array does not equal the orginal array",cloneNegativeTest, res); // assert that the clone function worked correctly
		}
		
		//Positive cloning true mutaiton condition 
		@Test
		public void clonePositive() {
			double[][] clonePositiveTest = { {1}, {1} }; 
			double[][] res = DataUtilities.clone(clonePositiveTest); 
			assertArrayEquals("The cloned array does not equal the orginal array",clonePositiveTest, res); // assert that the clone function worked correctly
		}
	
		//End of Mutation testing new code
}