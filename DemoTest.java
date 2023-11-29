package TestngPackage;

import org.testng.annotations.Test;

public class DemoTest {
	@Test(priority = 3)
	public void method1() {
		System.out.println("method1");
	    // Test method 1 logic
	}

	@Test(priority = 1,dependsOnMethods = "method1")
	public void method2() {
		System.out.println("method2");
	    // Test method 2 logic, which depends on method1
	}

	@Test(priority = 2)
	public void method3() {
		System.out.println("method3");
	    // Test method 3 logic, which depends on both method1 and method2
	}
}
