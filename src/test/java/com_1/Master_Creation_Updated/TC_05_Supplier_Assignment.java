package com_1.Master_Creation_Updated;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_05_Supplier_Assignment extends BaseClass {
	@SuppressWarnings("unused")
	@org.testng.annotations.Test
	public static void Supplier_Assignment() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);

		WMPS_Login("Initiator", "Initiator_Password");
		int rowcount = xls.getRowCount("SupplierAssignment");
		mp.Master_Click();
		mp.Supplier_Assignment();
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// **************************************************************************************************
			// **************************************************************************************************	
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String MaterialMasterRM_Edit = xls.getCellData("Excel_Data", "MaterialMasterRM_Edit", i);
			// **************************************************************************************************	
			// **************************************************************************************************
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier = xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			// **************************************************************************************************
			String Vendor_Name_Supplier_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Supplier_Edit", i);
			String Vendor_Name_Manufacturer_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer_Edit", i);
			// **************************************************************************************************
			// **************************************************************************************************
			String DateToday = xls.getCellData("Date", "DateToday", i);
			String Date1DB = xls.getCellData("Date", "Date1DB", i);//Date one day Back 

			// ************************************************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ************************************************************************************************************************************
			Thread.sleep(3000);
			w.Create_Button();	
			w.DD_01(MaterialMasterRM_Edit);
			// ************************************************************************************************************************************
			mp.Manfacturer_Name_Text(Vendor_Name_Manufacturer_Edit);
			mp.Name_of_the_Supplier(Vendor_Name_Supplier_Edit);
			// ************************************************************************************************************************************
			w.VendorStatusDD("Approved");
			w.qualifiedDate(DateToday);
			w.Save_Button();
			w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Initiator_Password"));
			w.Submit_Button();
			Thread.sleep(1000);
			w.Ok_Button();Thread.sleep(3000);
			// **************************************************************************************************			
			//w.SearchBox(MaterialMasterRM);
			w.SearchBox(Vendor_Name_Supplier_Edit);
			// **************************************************************************************************			
			w.ViewButton();scrollPagedown();

		}
		// driver.close();
	}
}
