package com_3.Master_ReInitiate_Updated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_02_Vendor_Master_Manufacturer_ReInitiate extends BaseClass
{

	@org.testng.annotations.Test
	public static void Vendor_Master() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);
		Actions actions = new Actions(driver);
		
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=rowcount;i++)
		{ 	
			String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);

			String Vendor_name_Manufacturer =xls.getCellData("Excel_Data", "Vendor_name_Manufacturer", i);
			String Street_Edit =xls.getCellData("Excel_Data", "Street", i);
			
			WMPS_Login("441111","Password");Thread.sleep(2000);
			WebElement MoveCursor = driver.findElement(By.xpath("//*[text()='Masters']"));Thread.sleep(2000);
			actions.moveToElement(MoveCursor).perform();Thread.sleep(1000);	
			mp.Master_Click();
			mp.Vendor_Master();
			//w.SearchBox(Vendor_name_Manufacturer);
			w.Edit_Action_Button();
			w.Comments("Vendor_Master_Manufacturer_ReInitiate");
			w.UpdateButton();
			w.Ok();
			w.Street(Street_Edit+"1");Thread.sleep(1000);
			w.UpdateButton();
			E_Signature1("Password");
//			w.Submit();w.Yes();w.Password_Fill(InitiatorPassword);
//			w.SubmitType_1();w.Ok();
		}}}