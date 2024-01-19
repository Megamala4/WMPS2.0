package com_1.Master_Creation_Updated;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;
public class TC_02_Vendor_Master_Manufacturer extends BaseClass {

	@org.testng.annotations.Test
	public static void Vendor_Master() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++)
		{
			// **************************************************************************************************
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Manufacturer_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer_Edit", i);
			// **************************************************************************************************
			String VendorTypeManufacturer = xls.getCellData("Vendor_Supplier", "VendorTypeManufacturer", i);
			// **************************************************************************************************
			String Street = xls.getCellData("Vendor_Supplier", "Street", i);
			String Street1 = xls.getCellData("Vendor_Supplier", "Street1", i);
			String Postal_Code = xls.getCellData("Vendor_Supplier", "Postal_Code", i);
			// **************************************************************************************************			
			String Street_Edit = xls.getCellData("Vendor_Supplier", "Street_Edit", i);
			String Street1_Edit = xls.getCellData("Vendor_Supplier", "Street1_Edit", i);
			String Postal_Code_Edit = xls.getCellData("Vendor_Supplier", "Postal_Code_Edit", i);
			// **************************************************************************************************			
			String Street2 = xls.getCellData("Vendor_Supplier", "Street2", i);
			String Country = xls.getCellData("Vendor_Supplier", "Country", i);
			String State = xls.getCellData("Vendor_Supplier", "State", i);
			String City = xls.getCellData("Vendor_Supplier", "City", i);
			// **************************************************************************************************			
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			// **************************************************************************************************	
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String MaterialMasterRM_Edit = xls.getCellData("Excel_Data", "MaterialMasterRM_Edit", i);
			// **************************************************************************************************	
			WMPS_Login("Initiator", "Initiator_Password");
			mp.Master_Click();
			mp.Vendor_Master();
			w.Create();
			Thread.sleep(1000);
			w.VendorType(VendorTypeManufacturer);//Excel
			// **************************************************************************************************			
			//mp.Vendor_Name_SK(Vendor_Name_Manufacturer);
			mp.Vendor_Name_SK(Vendor_Name_Manufacturer_Edit);
			// **************************************************************************************************			
			w.Street(Street);
			w.Street1(Street1);
			w.Street2(Street2);Thread.sleep(1000);
			w.Country_DD_VT(Country);Thread.sleep(1000);
			w.State_DD_VT(State);Thread.sleep(1000);
			w.City_DD_VT(City);Thread.sleep(1000);
			mp.Postal_Code(Postal_Code);
			w.Submit_Button();w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Initiator_Password"));
			w.Submit_Button2();w.Ok();
			// **************************************************************************************************			
			//w.SearchBox(Vendor_Name_Manufacturer);
			w.SearchBox(Vendor_Name_Manufacturer_Edit);
			// **************************************************************************************************			
			w.ViewButton();scrollPagedown();
		}
		// driver.close();
	}
}
