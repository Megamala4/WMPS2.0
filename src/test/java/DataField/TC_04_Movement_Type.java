package DataField;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_04_Movement_Type extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);

		JavascriptExecutor Js = (JavascriptExecutor) driver;
		
		int rowcount = xls.getRowCount("Datafields_ALL");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Movement_Type =xls.getCellData("Datafields_ALL", "Movement_Type", i);
			String Edit_Moment_Type =xls.getCellData("Datafields_ALL", "Edit_Moment_Type", i);
			
		WMPS_Login("Initiator","Password");
		w.Menu();
		driver.findElement(By.xpath("(//*[contains(text(),'Movement Type ')])[1]")).click();

		w.Create();
		
		df.Movement_Type_SK(Movement_Type);//Data1
		
//***************************************************************************************************		
		driver.findElement(By.xpath("//*[@class='dropdown-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[contains(text(),'Select All')])")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/app-root/div/div/app-movement-type-creation/div/app-pop-up[1]/div/div/div/div[2]/form/div[2]/div/ng-multiselect-dropdown/div/div[1]/span/span[5]/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='dropdown-multiselect__caret']")).click();
//***************************************************************************************************		
//		w.Submit();Thread.sleep(2000);
//		E_Signature("Password");
		
		Submit_E_Signature("Password");
//EDIT DROPDOWN		

		w.SearchBox(Movement_Type);//Data
		w.Edit_Action_Button();
		df.Movement_Type_SK(Edit_Moment_Type); //Edited_Data   
		
		w.Comments("Update_Comment");

		//CheckBox6();
		
		Submit_E_Signature("Password");
		//FOR DISABLING RECORD		
		
		w.SearchBox(Edit_Moment_Type);//Edited_Data
		
		
		
	//	Edit_Action_Button();
		
		w.Comments("Update_Comment");

		//CheckBox6();
		
		Submit_E_Signature("Password");
		
	//FOR ENABLING RECORD	
		w.SearchBox(Edit_Moment_Type);//Edited_Data

	//	Edit_Action_Button();
		
		w.Comments("Enable_Comment");

	//	CheckBox6();
		
		Submit_E_Signature("Password");
		
//Already Exist				
		
		
		w.Create();
		df.Movement_Type_SK(Edit_Moment_Type); //Edited_Data
		
		driver.findElement(By.xpath("//*[@class='dropdown-btn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//*[contains(text(),'Select All')])")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html/body/app-root/div/div/app-movement-type-creation/div/app-pop-up[1]/div/div/div/div[2]/form/div[2]/div/ng-multiselect-dropdown/div/div[1]/span/span[5]/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class='dropdown-multiselect__caret']")).click();
		
		w.Submit();
		w.Cross_Close_Button();
		
		driver.close();

		}}}
