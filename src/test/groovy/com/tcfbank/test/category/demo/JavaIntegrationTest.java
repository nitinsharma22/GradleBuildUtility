package com.tcfbank.test.category.demo;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.tcfbank.test.category.IntegrationTest;

@Category(IntegrationTest.class)
public class JavaIntegrationTest {
	
	@Test
	public void Test1() {
		assert 1==2;
	}
	
	@Test
	public void Test2() {
		assert 1==2;
	}

}
