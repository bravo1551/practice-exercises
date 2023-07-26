import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class powerOfTwoTest {

	@Test
	void testTrue() {
		PowerOfTwo test = new PowerOfTwo();
		boolean output = test.isPowerOfTwo(8);
		assertEquals(true, output);
		//fail("Not yet implemented");
	}
	
	@Test
	void testFalse() {
		PowerOfTwo test = new PowerOfTwo();
		boolean output = test.isPowerOfTwo(8);
		assertEquals(false, output);
		//fail("Not yet implemented");
	}

}
