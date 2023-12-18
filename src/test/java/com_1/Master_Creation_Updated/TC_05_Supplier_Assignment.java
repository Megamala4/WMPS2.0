package com_1.Master_Creation_Updated;
import org.openqa.selenium.By;
import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_05_Supplier_Assignment extends BaseClass {

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
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier = xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			String Password = xls.getCellData("Changable_Data", "Password", i);
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);

			// String Today_Date =xls.getCellData("Changable_Data", "Today_Date", i);
			String DateToday = xls.getCellData("Date", "DateToday", i);

			mp.Master_Click();			
			mp.Supplier_Assignment();
			Thread.sleep(4000);
//			driver.findElement(By.xpath("(//*[contains(text(),'Create')])[3]")).click();
			w.Create();
			mp.Material_Description_Text(MaterialMasterRM);
			mp.Manfacturer_Name_Text(Vendor_Name_Manufacturer);
			mp.Name_of_the_Supplier(Vendor_Name_Supplier);
			w.VendorStatusDD("Approved");
			w.qualifiedDate(DateToday);
			w.Save();
			w.Yes();
			w.Password_Fill(InitiatorPassword);
			 w.SubmitType_1();
			 //w.Ok();driver.close();
		}
	}
}
