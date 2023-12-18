package com_1.Master_Creation_Updated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_01_Material_Master_RawMaterial extends BaseClass {

	@org.testng.annotations.Test
	public static void Material_Master() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);
		Actions actions = new Actions(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			String Material_Type_RawMaterial = xls.getCellData("Excel_Data", "Material_Type", i);
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String Material_Long_Description_RawMaterial = xls.getCellData("Excel_Data", "Material_Long_Description_RM",
					i);
			String Purchase_UOM = xls.getCellData("Material_Master", "Purchase_UOM", i);
			String Material_Number = xls.getCellData("Material_Master", "Material_Number", i);
			String Basic_UOM = xls.getCellData("Material_Master", "Basic_UOM", i);
			String Storage_Conditions = xls.getCellData("Material_Master", "Storage_Conditions", i);
			String Specification_STP_No = xls.getCellData("Material_Master", "Specification_STP_No", i);
			String Procurement_Type = xls.getCellData("Material_Master", "Procurement_Type", i);
			String Rounding = xls.getCellData("Material_Master", "Rounding", i);
			String Production_Starting_Year = xls.getCellData("Material_Master", "Production_Starting_Year", i);
			String Remarks = xls.getCellData("Material_Master", "Remarks", i);
			String InspectIntervalPeriod = xls.getCellData("Material_Master", "InspectIntervalPeriod", i);
			String InspectIntervalPeriodDMY = xls.getCellData("Material_Master", "InspectIntervalPeriodDMY", i);
			String AltUOM_X = xls.getCellData("Material_Master", "AltUOM_X", i);
			String AltUOM = xls.getCellData("Material_Master", "AltUOM", i);
			String AltUOM_Y = xls.getCellData("Material_Master", "AltUOM_Y", i);
			String InspectionType = xls.getCellData("Material_Master", "InspectionType", i);
			String StorageLocations = xls.getCellData("Material_Master", "StorageLocations", i);
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);

			WMPS_Login("Initiator", "Initiator_Password");
			// driver.findElement(By.xpath("//*[contains(text(),'Hetero Labs')]")).click();
			// driver.findElement(By.cssSelector("div[class='tile purple']
			// p")).click();Thread.sleep(2000);
			// WebElement MoveCursor =
			// driver.findElement(By.xpath("//*[contains(text(),'Hetero
			// Labs')]"));Thread.sleep(2000);
			// actions.moveToElement(MoveCursor).perform();Thread.sleep(1000);

			mp.Master_Click();
			mp.Material_Master();
			w.Create();
			mp.Meterial_Type_Text(Material_Type_RawMaterial);// Keys_Enter
			mp.Material_Description_SK(MaterialMasterRM);
			mp.Material_Long_Description_SK(Material_Long_Description_RawMaterial);
			mp.Purchase_UOM_Text(Purchase_UOM);
			mp.DropDown_Select();
			mp.Material_Number_SK(Material_Number);
			mp.Basic_Unit_of_Measurement_Text(Basic_UOM);
			mp.DropDown_Select();
			mp.Storage_Conditions_Text(Storage_Conditions);
			mp.DropDown_Select();
			mp.Specification_STP_No_SK(Specification_STP_No);
			mp.Procurement_Type_Text(Procurement_Type);
			mp.DropDown_Select();// Always External in RAW MATERIAL
			mp.Rounding_Text(Rounding);
			mp.DropDown_Select();
			mp.Production_Starting_Year(Production_Starting_Year);// nakko in Raw Material
			mp.Remarks_SK(Remarks);
			w.TT_15(AltUOM_X);// Alternate_UOM_X
			mp.Alt_UOM_DD_Select(AltUOM);// AltUOM//L//Not in Raw Material
			w.TextBox17E(AltUOM_Y);// Alternate_UOM_Y
			mp.QualityManagement_Click();
			Thread.sleep(2000);
			w.TEN_02(InspectIntervalPeriod);
			Thread.sleep(2000);
			mp.InspectionType(InspectionType);
			Thread.sleep(2000);
			w.CheckBox_1();
			w.CheckBox_2();
			w.CheckBox_3();
			mp.Storage_Locations_Click();
			mp.StorageLocations1(StorageLocations);
			w.CheckBox_4();// Active
			// Scenarios***************************************************************************************************
			// w.Submit();w.Not_Create();
			// w.Submit();w.Yes();
			// w.Password_Fill("");w.Submit_Type();w.Cross_Close_Button();
			// w.Submit();w.Yes();w.Password_Fill(WrongPassword);w.Submit_Type();w.Ok();w.Cross_Close_Button();
			// w.Submit();w.Yes();w.Password_Fill(InitiatorPassword);w.Submit_Type();w.Ok();
			// ************************************************************************************************************
			w.Submit();
			w.Yes();
			w.Password_Fill(InitiatorPassword);
			w.SubmitType_1();
			w.Ok();
			// driver.close();
		}
	}
}
