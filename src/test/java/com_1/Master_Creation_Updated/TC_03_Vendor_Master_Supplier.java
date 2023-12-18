package com_1.Master_Creation_Updated;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_03_Vendor_Master_Supplier extends BaseClass {

	@org.testng.annotations.Test
	public static void Vendor_Master_Supplier() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			String Vendor_Name_Supplier = xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String Street = xls.getCellData("Vendor_Supplier", "Street", i);
			String Street1 = xls.getCellData("Vendor_Supplier", "Street1", i);
			String Street2 = xls.getCellData("Vendor_Supplier", "Street2", i);
			String City = xls.getCellData("Vendor_Supplier", "City", i);
			String Postal_Code = xls.getCellData("Vendor_Supplier", "Postal_Code", i);
			String Country = xls.getCellData("Vendor_Supplier", "Country", i);
			String State = xls.getCellData("Vendor_Supplier", "State", i);

			WMPS_Login("Initiator", "Initiator_Password");
			mp.Master_Click();
			mp.Vendor_Master();
			w.Create();
			mp.Vendor_Type_DDselect();// maf or supplier
			mp.Vendor_Name_SK(Vendor_Name_Supplier);
			w.Street(Street);
			w.Street1(Street1);
			w.Street2(Street2);
			w.Country(Country);
			w.State(State);
			w.CityId(City);
			mp.postalSend(Postal_Code);
			Thread.sleep(2000);
			w.Submit();
			w.Yes();
			w.Password_Fill(InitiatorPassword);
			w.Ok();
			w.SubmitType_1();
			w.Password_Fill("Hetero@5");
			w.Ok();
			//driver.close();
		}
	}
}
