package TestngPackage;

import org.testng.annotations.Test;

public class DemoM {
	@Test                  
    public void test1(){
    	System.out.println("test 1 is running");
}
	@Test
    public void test2() {
    	System.out.println("test 2 is running");
    }
	@Test
    public void beforeMethod() {
     	System.out.println("Bfore Method\n");
    }
	@Test
    public void beforeTest(){
    	System.out.println("Before test");
    }
}
