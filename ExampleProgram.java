package TestngPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleProgram {
	
	
	@Test
	public void test32() {
		System.out.println("test case3");
	}
	@Test
	public void test1234() {
		System.out.println("test case1");
	}
	@Test(dataProvider = "sampleData" , dataProviderClass = DataProviderExample.class)
	public void test2234(String username,String password) {
		System.out.println("test case2"+username+" "+password);
	}

//	@BeforeMethod
	public void beforeMethod() {
		System.out.println("before Method");
	}
//	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	
	
	public void beforeClass() {
		System.out.println("before class");
	}
	
	
	public void afterClass() {
		System.out.println("after class");
	}
	
}
