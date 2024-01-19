package com_1.Master_Creation_Updated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_06_Product_Requirement_FP extends BaseClass {
	@org.testng.annotations.Test
	public static void Material_Master() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);
		Actions actions = new Actions(driver);
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			String MaterialMasterFP = xls.getCellData("Excel_Data", "MaterialMasterFP", i);
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String Material_Description_RawMaterial = xls.getCellData("Excel_Data", "Material_Description", i);
			String Material_Description = xls.getCellData("Excel_Data", "Material_Description", i);// **************
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String Market = xls.getCellData("Changable_Data", "Market", i);
			String Password = xls.getCellData("Changable_Data", "Password", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			String Stage = xls.getCellData("Material_Master", "Stage", i);
			// DataMapping
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);// *************
			WMPS_Login("Initiator", "Initiator_Password");
			WebElement MoveCursor = driver.findElement(By.xpath("//*[text()='Masters ']"));
			Thread.sleep(2000);
			actions.moveToElement(MoveCursor).perform();
			Thread.sleep(1000);
			mp.Master_Click();
			mp.Product_Requirement();
			Thread.sleep(4000);
			w.Create();
			w.TT_1(MaterialMasterFP);
			Thread.sleep(2000);
			w.Stage(Stage);
			w.TT_2(Pro.getProperty("RawMaterial3"));// Change Raw materials which we given in excle& give
			w.ManufactureName(Vendor_Name_Manufacturer);
			w.MarketName("EUROPE");// we can take from excel too
			w.Add_Button();
			w.ManufactureName(Vendor_Name_Manufacturer);
			w.MarketName("JAPAN");
			w.Add_Button();
			w.ManufactureName(Vendor_Name_Manufacturer);
			w.MarketName("US");
			w.Add_Button();
			w.Remarks(Material_Description);
			w.CheckBox_1();
			w.CheckBox_2();
			w.CheckBox_3();
			w.Submit();
			w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Initiator_Password"));
			w.SubmitType_1();
			w.Ok();
			driver.close();
		}
	}
}
