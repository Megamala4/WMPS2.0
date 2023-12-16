package Transactions_Positive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_10_Batch_Process_Closure extends BaseClass
{

	@org.testng.annotations.Test
	public static void Bill_Of_Material() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);
		
		WMPS_Login("441111","Password");
		w.Menu_Navigate();w.Menu_Navigate();
		w.Production();
		w.Batch_Process_Closure();
		w.Create();
		
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)			
		{ 
			String MaterialMasterSFP=xls.getCellData("Excel_Data", "MaterialMasterSFP", i);	//New Semifinished Material Upper Part		
			String Batch_Number_I =xls.getCellData("Dependency", "Batch_Number_I", i);

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

			WebElement ProductName = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[4]"));
			ProductName.sendKeys(MaterialMasterSFP);Thread.sleep(2000);
			ProductName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);

			
			WebElement BatchNumber = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[5]"));
			BatchNumber.sendKeys(Batch_Number_I);Thread.sleep(2000);
			BatchNumber.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);Thread.sleep(4000);
			w.Remarks("Okay");
			w.Submit();w.Yes();
			w.Password_Fill(InitiatorPassword);
			//w.SubmitType12();w.Ok();
		}}}
    
