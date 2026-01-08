package com.gsrr.Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyMathTest {
	private MyMath math = new MyMath();

	@Test
	void calculateSum_ThreeMemberArray() {
		assertEquals(6, math.calculateSum(new int[] {1,2,3}));
	}
	@Test
	void calculateSum_ZeroLengthArray() {
		assertEquals(0, math.calculateSum(new int[] {}));
	}
//	@Test
//	void test1() {
//		int result = math.calculateSum(new int[] {});
//		System.out.println(result);
//		int expectedResult = 0;
//		assertEquals(expectedResult, result);
//
//}
	
//	@Test
//	void test() {
//		int result = math.calculateSum(new int[] {1,2,3});
//		System.out.println(result);
//		int expectedResult = 6;
//		assertEquals(expectedResult, result);
//		
//		//absence of failure is success
//		//Test Condition or Assert
//
//		//		fail("Not yet implemented");
//		
//		//{} => 0
//		
//	}
	
	}
