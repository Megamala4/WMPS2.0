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
public class TC_02_Vendor_Master_Manufacturer_ReInitiate extends BaseClass {
	@org.testng.annotations.Test
	public static void Vendor_Master() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);
		Actions actions = new Actions(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= rowcount; i++) 
		{
			// **************************************************************************************************
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Manufacturer_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer_Edit", i);
			// **************************************************************************************************
			// **************************************************************************************************			
			String Street_Edit = xls.getCellData("Vendor_Supplier", "Street_Edit", i);
			String Street1_Edit = xls.getCellData("Vendor_Supplier", "Street1_Edit", i);
			String Postal_Code_Edit = xls.getCellData("Vendor_Supplier", "Postal_Code_Edit", i);
			// **************************************************************************************************
			// **************************************************************************************************
			String Street = xls.getCellData("Vendor_Supplier", "Street", i);
			String Street1 = xls.getCellData("Vendor_Supplier", "Street1", i);
			String Postal_Code = xls.getCellData("Vendor_Supplier", "Postal_Code", i);
			// **************************************************************************************************
			// **************************************************************************************************			
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			// **************************************************************************************************
			WMPS_Login("Initiator", "Initiator_Password");Thread.sleep(2000);
			WebElement MoveCursor = driver.findElement(By.xpath("//*[text()='Masters ']"));
			Thread.sleep(2000);
			actions.moveToElement(MoveCursor).perform();
			Thread.sleep(1000);
			mp.Master_Click();
			mp.Vendor_Master();
			// **************************************************************************************************
			w.SearchBox(Vendor_Name_Manufacturer);//SEARCHING 
			// **************************************************************************************************
			w.Edit_Action_Button();
			// **************************************************************************************************
			mp.Vendor_Name_SK(Vendor_Name_Manufacturer_Edit);// Vendor_Name_Manufacturer_Edit
			// **************************************************************************************************
			w.Street(Street_Edit);
			w.Street1(Street1_Edit);
			mp.Postal_Code(Postal_Code_Edit);
			w.Comments("Vendor_Master_Manufacturer_ReInitiate");
			w.Update_Button();w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Initiator_Password"));
			w.Submit_Button();
			w.Ok_Button();
			// **************************************************************************************************
			w.SearchBox(Vendor_Name_Manufacturer_Edit);//SEARCHING 
			// **************************************************************************************************
			w.ViewButton();scrollPagedown();

		}
	}
}