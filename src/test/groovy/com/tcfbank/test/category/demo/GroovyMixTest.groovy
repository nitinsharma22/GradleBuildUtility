package com.tcfbank.test.category.demo

import org.junit.Test
import org.junit.experimental.categories.Category

import com.tcfbank.test.category.IntegrationTest
import com.tcfbank.test.category.UnitTest

//@Category({UnitTest,IntegrationTest})
public class GroovyMixTest {
	
	@Test
	public void Test1() {
		assert 1==2;
	}
	
	@Test
	public void Test2() {
		assert 1==2;
	}

}
