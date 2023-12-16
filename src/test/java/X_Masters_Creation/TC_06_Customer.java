package X_Masters_Creation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_06_Customer extends BaseClass
{

	@org.testng.annotations.Test
	public static void Customer() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);

		WMPS_Login("Initiator","Password");
		w.Menu();
		
		
		driver.findElement(By.xpath("(//*[@class='nav-link'])[9]")).click();Thread.sleep(3000);		
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
			
		w.Create();
		w.CustomerName("");
		driver.findElement(By.xpath("//*[@formcontrolname='customerName']")).sendKeys("Herbal_Pharmacy");Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@formcontrolname='street']")).sendKeys("Street");Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@formcontrolname='street1']")).sendKeys("Street1");Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@formcontrolname='street2']")).sendKeys("Street2");Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@formcontrolname='postalCode']")).sendKeys("800051");Thread.sleep(1000);
		
		Select country=new Select(driver.findElement(By.xpath("//*[@formcontrolname='countryId']")));
		country.selectByIndex(3);Thread.sleep(2000);//country.selectByVisibleText(Country);
		
		Select state=new Select(driver.findElement(By.xpath("//*[@formcontrolname='stateId']")));
		state.selectByIndex(1);//state.selectByVisibleText(State);
		
		driver.findElement(By.xpath("//*[@formcontrolname='cityId']")).sendKeys(City);		
		driver.findElement(By.xpath("//*[@formcontrolname='Remarks']")).sendKeys("Create_Customer");Thread.sleep(1000);
		w.Submit();
		E_Signature_Masters("Password");
	}}}



