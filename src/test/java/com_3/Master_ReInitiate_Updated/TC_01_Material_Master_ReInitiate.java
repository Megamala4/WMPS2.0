package com_3.Master_ReInitiate_Updated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_01_Material_Master_ReInitiate extends BaseClass {

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);
		Actions actions = new Actions(driver);
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// ************************************************************************************************************
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String MaterialMasterSFP = xls.getCellData("Excel_Data", "MaterialMasterSFP", i);
			String MaterialMasterFP = xls.getCellData("Excel_Data", "MaterialMasterFP", i);

			String MaterialMasterRM_Edit = xls.getCellData("Excel_Data", "MaterialMasterRM_Edit", i);
			String MaterialMasterSFP_Edit = xls.getCellData("Excel_Data", "MaterialMasterSFP_Edit", i);
			String MaterialMasterFP_Edit = xls.getCellData("Excel_Data", "MaterialMasterFP_Edit", i);
			// ************************************************************************************************************
			// ************************************************************************************************************
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier = xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			// ************************************************************************************************************
			String Vendor_Name_Supplier_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Supplier_Edit", i);
			String Vendor_Name_Manufacturer_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer_Edit", i);
			// **************************************************************************************************
			// ************************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ************************************************************************************************************
			// ************************************************************************************************************
			String Purchase_UOM_Edit = xls.getCellData("Material_Master", "Purchase_UOM_Edit", i);
			String Basic_UOM_Edit = xls.getCellData("Material_Master", "Basic_UOM_Edit", i);
			String Rounding_Edit = xls.getCellData("Material_Master", "Rounding_Edit", i);
			String AltUOM_Edit = xls.getCellData("Material_Master", "AltUOM", i);
			String StorageLocations_Edit = xls.getCellData("Material_Master", "StorageLocations_Edit", i);
			String InspectionType_Edit = xls.getCellData("Material_Master", "InspectionType_Edit", i);
			String Remarks = xls.getCellData("Material_Master", "Remarks", i);

			// ***********************************************************************************************************
			// ************************************************************************************************************
			WMPS_Login("Initiator", "Initiator_Password");
			Thread.sleep(2000);
			WebElement MoveCursor = driver.findElement(By.xpath("//*[text()='Masters ']"));
			Thread.sleep(2000);
			actions.moveToElement(MoveCursor).perform();
			Thread.sleep(1000);
			mp.Master_Click();
			mp.Material_Master();
			// ************************************************************************************************************
			w.SearchBox(MaterialMasterRM_Edit);// SEARCHING
			//w.SearchBox(MaterialMasterSFP_Edit);//SEARCHING
			// w.SearchBox(MaterialMasterFP_Edit);//SEARCHING
			// ************************************************************************************************************
			w.Edit_Action_Button();
			// ************************************************************************************************************
			mp.Material_Description_SK(MaterialMasterRM_Edit);
			// mp.Material_Description_SK(MaterialMasterSFP_Edit);
			// mp.Material_Description_SK(MaterialMasterFP_Edit);
			// ************************************************************************************************************
			mp.Rounding_Text(Rounding_Edit);
			mp.Purchase_UOM_Text_Edit(Purchase_UOM_Edit);
			System.out.print("1");
			mp.Basic_Unit_of_Measurement_Text_Edit(Basic_UOM_Edit);
			System.out.print("2");
			///mp.Alt_UOM_DD_Select(AltUOM_Edit);// AltUOM//L //Not in Raw Material
			System.out.print("3");
			mp.QualityManagement_Click();
			Thread.sleep(2000);
			mp.InspectionType_Edit(InspectionType_Edit);
			System.out.print("4");
			mp.Storage_Locations_Click();
			//mp.StorageLocations1_Edit(StorageLocations_Edit);
			System.out.print("5");
			mp.Remarks_SK("Material_Master_ReInitiate");
			//w.TT_15_Edit(AltUOM_X);// Alternate_UOM_X
			//w.TextBox17E(AltUOM_Y);// Alternate_UOM_Y
			// ************************************************************************************************************
			//w.Comments("Material_Master_ReInitiate");
			w.Submit_Button();w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Initiator_Password"));
			w.Submit_Button2();w.Ok_Button();
			// ************************************************************************************************************
			w.SearchBox(MaterialMasterRM_Edit);Thread.sleep(1000);
			// w.SearchBox(MaterialMasterSFP_Edit);//SEARCHING
			// w.SearchBox(MaterialMasterFP_Edit);//SEARCHING
			// ************************************************************************************************************
			w.ViewButton();scrollPagedown();
		}
	}
}
