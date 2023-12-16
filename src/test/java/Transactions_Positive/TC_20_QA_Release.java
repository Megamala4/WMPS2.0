package Transactions_Positive;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_20_QA_Release extends BaseClass
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
		//w.Menu_Navigate();
		//w.Transactions();
		w.Pharma_Dispatch();
		w.QA_Release();
		w.Menu_Navigate();
			
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)		
		{ 			
			String Delivery_Number =xls.getCellData("Dependency", "Delivery_Number", i);

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);
String MaterialMasterFP=xls.getCellData("Excel_Data", "MaterialMasterFP", i);//New Semifinished Material Upper Part		
String Batch_Number_II =xls.getCellData("Dependency", "Batch_Number_II", i);



			WebElement DeliveryNumber = driver.findElement(By.xpath("(//*[@type='text'])[1]"));
			DeliveryNumber.sendKeys(Delivery_Number);
			Thread.sleep(2000);w.DropDown1Select();
			//DeliveryNumber.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);						
			Thread.sleep(2000);Thread.sleep(2000);
			
			
				WebElement ProductName = driver.findElement(By.xpath("(//*[@type='text'])[2]"));Thread.sleep(2000);
				ProductName.sendKeys(MaterialMasterFP);Thread.sleep(2000);
				w.DropDown1Select();Thread.sleep(2000);
				//ProductName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);
		
					WebElement BatchNumber = driver.findElement(By.xpath("(//*[@type='text'])[3]"));
					BatchNumber.sendKeys(Batch_Number_II);w.DropDown1Select();Thread.sleep(2000);
					//BatchNumber.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);Thread.sleep(4000);

				w.Get_Button();
				w.Print_Button();
				w.Yes();
				w.Password_Fill(InitiatorPassword);
				w.SubmitType_1();
				Thread.sleep(2000);Thread.sleep(2000);
				Close_Opened_File();
				w.Ok();
		}}}
