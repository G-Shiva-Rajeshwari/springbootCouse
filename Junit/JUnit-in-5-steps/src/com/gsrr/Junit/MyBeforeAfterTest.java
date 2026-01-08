package com.gsrr.Junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;

class MyBeforeAfterTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("beforAll");
	}
	@BeforeEach
	void beforeEach() {
		System.out.println("Before Each");
	}
	
	@AfterEach
	void AfterEach() {
		System.out.println("After Each");
	}
	
	@Test
	void test1() {
		System.out.println("test1");
	}
	
	@Test
	void test2() {
		System.out.println("test2");
	}
	
	@Test
	void test3() {
		System.out.println("test3");
	}
	
	@AfterAll
	static void AfterAll() {
		System.out.println("After All");
	}

}
