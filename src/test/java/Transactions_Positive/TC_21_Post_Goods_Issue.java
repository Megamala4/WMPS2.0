package Transactions_Positive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_21_Post_Goods_Issue extends BaseClass
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
		w.Menu_Navigate();
		w.Transactions();
		w.Pharma_Dispatch();
		w.Post_Goods_Issue();
		w.Menu_Navigate();
	
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)		
		{ 

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

			String Batch_Number =xls.getCellData("Material_Indent", "Batch_number", i);
			w.SearchBox(Batch_Number);
			w.Edit_Action_Button();
			
			WebElement CustomerName=driver.findElement(By.xpath("(//*[@type='text'])[7]"));
			CustomerName.sendKeys(Batch_Number);Thread.sleep(2000);
			
			WebElement Remarks=driver.findElement(By.xpath("(//*[@type='text'])[8]"));
			Remarks.sendKeys("Okay");Thread.sleep(2000);

			driver.findElement(By.xpath("(//*[contains(text(),' Goods Issue')])[5]")).click();Thread.sleep(2000);
			w.Yes();
			w.Password_Fill("321");
//			w.TYPE_SUBMIT();
//			w.OK_BUTTON();

		}}}
