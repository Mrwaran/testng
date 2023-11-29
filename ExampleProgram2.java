package TestngPackage;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExampleProgram2 {
	@Test(groups = "test1")
	@Parameters({"username"})
public void test(String username) {
		System.out.println("ExampleProgram2"+username);
	
}
}
