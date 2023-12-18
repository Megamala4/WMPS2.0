package com_1.Master_Creation_Updated;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
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
		for (int i = 2; i <= 2; i++) {
			String VendorTypeManufacturer = xls.getCellData("Vendor_Supplier", "VendorTypeManufacturer", i);
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);// *************

			String Street = xls.getCellData("Vendor_Supplier", "Street", i);
			String Street1 = xls.getCellData("Vendor_Supplier", "Street1", i);
			String Street2 = xls.getCellData("Vendor_Supplier", "Street2", i);
			String City = xls.getCellData("Vendor_Supplier", "City", i);
			String Postal_Code = xls.getCellData("Vendor_Supplier", "Postal_Code", i);
			String Country = xls.getCellData("Vendor_Supplier", "Country", i);
			String State = xls.getCellData("Vendor_Supplier", "State", i);
			String Street_Edit = xls.getCellData("Excel_Data", "Street", i);

			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);

			WMPS_Login("Initiator", "Initiator_Password");
			mp.Master_Click();
			mp.Vendor_Master();
			w.Create();
			Thread.sleep(1000);
			w.VendorType(VendorTypeManufacturer);// Excel
			mp.Vendor_Name_SK(Vendor_Name_Manufacturer);
			w.Street(Street);
			Thread.sleep(1000);
			w.Street1(Street1);
			Thread.sleep(1000);
			w.Street2(Street2);
			Thread.sleep(1000);
			w.Country(Country);
			Thread.sleep(1000);
			w.State(State);
			Thread.sleep(1000);
			w.CityId(City);
			Thread.sleep(1000);
			mp.postalSend(Postal_Code);
			Thread.sleep(2000);
			w.Submit();
			w.Yes();
			w.Password_Fill("Hetero@5");
			w.Ok();
			w.SubmitType_1();w.Ok();driver.close();
		}
	}
}
