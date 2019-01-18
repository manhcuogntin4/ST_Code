import static org.junit.Assert.*;

import org.junit.Test;

public class TestFizzBuzz {

	@Test
	public void testFizzBuzz() {
		FizzBuzz fb = new FizzBuzz();
		assertEquals("FizzBuzz", fb.getFizzBuzz(15));
		assertEquals("Fizz", fb.getFizzBuzz(3));
		assertEquals("Buzz", fb.getFizzBuzz(5));
		assertEquals("4", fb.getFizzBuzz(4));
	}

}
