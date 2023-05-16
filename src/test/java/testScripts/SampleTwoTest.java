package testScripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
	 @Test(groups="feature1")
	  public void testOne() {
		 System.out.println("Test1 on Sample two" );
}
	 @Test(groups="feature1")
	  public void testtwo() {
		 System.out.println("Test2 on Sample two");
		 
}
	 @Test(groups="feature3")
	  public void testthree() {
		 System.out.println("Test21 on Sample two");
}
	 @Test(groups="feature2")
	  public void testfour() {
		 System.out.println("Test11 on Sample two");	 
}
}