package parallelScripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
	 @Test
	public void testOne() {
		 long id = Thread.currentThread().getId();
		 System.out.println("Test1 on Sample three..." +id);
}
	 @Test
	  public void testtwo() {
		 long id = Thread.currentThread().getId();
		 System.out.println("Test2 on Sample three..." +id);
		 
}
	 @Test
	  public void testthree() {
		 long id = Thread.currentThread().getId();
		 System.out.println("Test21 on Sample three..."+id);
}
	 @Test
	  public void testfour() {
		 long id = Thread.currentThread().getId();
		 System.out.println("Test11 on Sample three..." +id);	 
}
}
