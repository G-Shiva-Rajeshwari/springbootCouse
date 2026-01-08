package com.gsrr.Junit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	List<String> todos = Arrays.asList("AWS","Azure","Devops");
	@Test
	void test() {
		boolean test = todos.contains("AWS");
		boolean test2 = todos.contains("gsfr");
		
		//assertEquals(true, test);
		//assertTrue(test);
		
		//assertEquals(3, todos.size());
		
		//assertNull, assertNotNull
		
//		 assertFalse(test2);
		
		assertArrayEquals(new int[] {3,2,4}, new int[] {2,3,1});
//		fail("Not yet implemented");
	}

}
