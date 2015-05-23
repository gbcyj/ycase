package test.com;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorsTest {

	private Calculators cal = new Calculators();
	@Before
	public void setUp() throws Exception {
		System.out.println("testing is starting....");
	}
	@After  
    public void tearDown() throws Exception {  
        System.out.println("testing finish....");  
    }
	@SuppressWarnings("deprecation")
	@Test
	public void testAdd() {
		int result = cal.add(2, 3);
		Assert.assertEquals(5, result);
//		fail("Not yet implemented");
	}

	@Test
	public void testMinus() {
		int result = cal.minus(10, 4);
		Assert.assertEquals(6, result);
//		fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		int result = cal.multiply(6, 3);
		Assert.assertEquals(18, result);
//		fail("Not yet implemented");
	}

	@Test
	public void testDivide() {
		int result;
		try {
			result = cal.divide(18,2);
			Assert.assertEquals(9, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		fail("Not yet implemented");
	}

}
