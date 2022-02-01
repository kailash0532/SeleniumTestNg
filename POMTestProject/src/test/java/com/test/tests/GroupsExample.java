package com.test.tests;

import org.testng.annotations.Test;

public class GroupsExample {

	@Test(groups = "Regression")
	public void test1() {
		System.out.println("Test1 Regression");
	}

	@Test(groups = "Smoke")
	public void test2() {
		System.out.println("Test2 Smoke");
	}

	@Test(groups = "Sanity")
	public void test3() {
		System.out.println("Test3 Sanity");
	}

	@Test(groups = {"Regression","Smoke"})
	public void test4() {
		System.out.println("Test4 Smoke and Regression");
	}

}
