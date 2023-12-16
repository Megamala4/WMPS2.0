package X_Masters_Creation;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_07_Label_Master extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);

		WMPS_Login("Initiator","Password");
		w.Menu();
		
		
		hp.menuclick();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[contains(text(),'Label Master')]")).click();
		Thread.sleep(3000);
		
		int rowcount = xls.getRowCount("Customer");
		System.out.println(rowcount);
		for(int i=2; i<=rowcount;i++)
		{ 
			String Customer_name =xls.getCellData("Customer", "Customer_name", i);
			String City =xls.getCellData("Customer", "City", i);
			String PostalCode =xls.getCellData("Customer", "PostalCode", i);
			String Country =xls.getCellData("Customer", "Country", i);
			String State =xls.getCellData("Customer", "State", i);
			String Remarks =xls.getCellData("Customer", "Remarks", i);
			
			String Street =xls.getCellData("Vendor_Supplier", "Street", i);
			String Street1 =xls.getCellData("Vendor_Supplier", "Street1", i);
			String Street2 =xls.getCellData("Vendor_Supplier", "Street2", i);

			
			driver.findElement(By.xpath("//*[@class='ng-arrow-wrapper']")).click();
			driver.findElement(By.xpath("(//*[@role='option'])[3]")).click();//LEVEL SELECTION
			//driver.findElement(By.xpath("//*[@class='ng-arrow-wrapper']")).click();

			driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();
			driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
			driver.findElement(By.xpath("(//*[@type='checkbox'])[3]")).click();
			driver.findElement(By.xpath("(//*[@type='checkbox'])[4]")).click();
			driver.findElement(By.xpath("(//*[@type='checkbox'])[5]")).click();
			driver.findElement(By.xpath("(//*[@type='checkbox'])[6]")).click();
			driver.findElement(By.xpath("(//*[@type='checkbox'])[7]")).click();
			driver.findElement(By.xpath("(//*[@type='checkbox'])[8]")).click();
			driver.findElement(By.xpath("(//*[@type='checkbox'])[9]")).click();
			driver.findElement(By.xpath("(//*[@type='checkbox'])[10]")).click();
			

		
		driver.findElement(By.xpath("//*[@formcontrolname='comments']")).sendKeys("Customer_name1");
		Thread.sleep(1000);
		hp.saveClick();
		Thread.sleep(2000);
		
		hp.yesButtonClick();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(Pro.getProperty("Password"));
		Thread.sleep(2000);
		
		
	//	driver.findElement(By.xpath("(//*[contains(text(),'Submit')])")).click();
		
		
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
		Thread.sleep(2000);
		Thread.sleep(3000);	
		}}}