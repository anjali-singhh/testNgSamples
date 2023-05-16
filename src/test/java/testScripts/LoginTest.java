package testScripts;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;



public class LoginTest {
	
	WebDriver driver;
	Properties prop;
	@Parameters("browser")
	//@BeforeMethod

//  public void setUp(String strBrowser) {
//		if(strBrowser.equalsIgnoreCase("chrome"))
//		{
//			driver = new ChromeDriver();
//		}
//		else if(strBrowser.equalsIgnoreCase("edge"))
//		{
//			driver = new EdgeDriver();
//		}
//	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
//	   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
//	   driver.manage().window().maximize();
//		
//  }
	   @BeforeMethod
	    public void setup() throws IOException{
        String path = System.getProperty("user.dir") + "//src//test//resources//configFiles//config.properties";
        FileInputStream fin = new FileInputStream(path);
        prop = new Properties();
        prop.load(fin);
        String strBrowser = prop.getProperty("browser");
        if(strBrowser.equalsIgnoreCase("chrome")) {
	    driver = new ChromeDriver();
        }
        else if (strBrowser.equalsIgnoreCase("edge")) {
	    driver = new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
	    driver.manage().window().maximize();
	    CSVReader reader = new CSVReader(new FileReader(path));
	   
	}
	
       @Test(dataProvider = "loginData")
        public void validLogin(String strUser,String strPwd) {
	    driver.get(prop.getProperty("url"));
		driver.findElement(By.id(readObjPath("user_name"))).sendKeys(strUser);
		driver.findElement(By.name(readObjPath("user_pwd"))).sendKeys(strPwd);
		WebElement btn = driver.findElement(By.tagName(readObjPath("login_btn")));
        boolean isDisp = driver.findElement(By.cssSelector("successMsg")).isDisplayed();
        Assert.assertTrue(isDisp);
       }
  
       //To use excel as objectrepo
       public String readObjPath(String objName) {
    	   String objPath= "";
    	   String path = System.getProperty("user.dir") + "//src//test//resources//dataFiles//loginPage.xlsx";
           //HSSF.... -> xls
    	   //XSSF.... -> .xlsx
    	   FileInputStream fin;
    	   XSSFWorkbook workbook = null;
    	   try {
    		   fin = new FileInputStream(path);
    		   workbook = new XSSFWorkbook(fin);
    	   } catch (FileNotFoundException e) {
    		   e.printStackTrace();
    	   } catch (IOException e) {
    		   e.printStackTrace();
    	   }
    	   XSSFSheet loginSheet = workbook.getSheet("loginPage");
    	   int numRows = loginSheet.getLastRowNum();
    	   for(int i = 1; i<= numRows; i++) {
    		   XSSFRow row = loginSheet.getRow(i);
    		   if(row.getCell(0).getStringCellValue().equalsIgnoreCase(objName)) {
    			   objPath = row.getCell(1).getStringCellValue();
    		   }
    	   }
		return objPath;
    	   }

       @DataProvider(name="loginData")
        public Object[][] getData() throws CsvValidationException, IOException{
		String path = System.getProperty("user.dir") + "//src//test//resources//dataFiles//loginData.csv";
	    
	    CSVReader reader = new CSVReader(new FileReader(path));
        
        String cols[];
        ArrayList<Object> dataList = new ArrayList<Object>();
        while((cols=reader.readNext())!= null) {
        	Object record[] = {cols[0], cols[1]};
        	dataList.add(record);
        }
        reader.close();
        return dataList.toArray(new Object[dataList.size()][]);
  }
       @AfterMethod
        public void tearDown() {
	    driver.close();
		
  }
}
