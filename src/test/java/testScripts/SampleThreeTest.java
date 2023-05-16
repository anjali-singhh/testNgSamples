package testScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
	 @Test(groups="feature2")
	  public void testOne() {
		 System.out.println("Test12 on Sample three");
}
	 @Test
	  public void testtwo() {
		 System.out.println("Testtwo on Sample three");
		 
}
	 @Test(groups="feature1")
	  public void testthree() {
		 System.out.println("Test3 on Sample three");
}
	 @Test(groups="feature3")
	  public void testfour() {
		 System.out.println("Test22 on Sample three");	 
}
}
