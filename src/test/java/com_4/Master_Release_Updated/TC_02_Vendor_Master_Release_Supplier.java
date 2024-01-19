package com_4.Master_Release_Updated;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_02_Vendor_Master_Release_Supplier extends BaseClass {

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);

		WMPS_Login("Approver_ID", "Approver_Password");
		w.Second_Level();
		w.ReviewApprovalCategory("Vendor Master Release");
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// ******************************************************************************************************
			String Vendor_Name_Supplier = xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			String Vendor_Name_Supplier_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Supplier_Edit", i);
			// ******************************************************************************************************
			// ******************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ******************************************************************************************************
			Thread.sleep(2000);
			w.Search_Button();
			// ******************************************************************************************************
			//w.SearchBox(Vendor_Name_Supplier);
			w.SearchBox(Vendor_Name_Supplier_Edit);
			// ******************************************************************************************************
			w.Edit_Action_Button();
			w.Comments("Vendor_Master_Release");
			// ******************************************************************************************************
			//w.ActionLevelApproverAction(Status);
			w.ActionLevelApproverAction(Pro.getProperty("Action_1"));
			// ******************************************************************************************************
			w.Submit_Button();w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Approver_Password"));
		//	w.Submit_Button2();w.Ok();
			// ******************************************************************************************************
			//w.SearchBox(Vendor_Name_Supplier);
			w.SearchBox(Vendor_Name_Supplier_Edit);
			// ******************************************************************************************************
			w.ViewButton();scrollPagedown();
		}
	}
}
