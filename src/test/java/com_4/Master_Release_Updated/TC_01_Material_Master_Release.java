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

public class TC_01_Material_Master_Release extends BaseClass {

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String MaterialMasterSFP = xls.getCellData("Excel_Data", "MaterialMasterSFP", i);// Change
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);

			WMPS_Login("Approver_ID","Approver_Password");
			w.Second_Level();
			w.ReviewApprovalCategory("Material Master Release");
			w.Search_Button();
			Thread.sleep(2000);
			// w.SearchBox();//Thread.sleep(2000);
			// w.SearchBox(" Created");Thread.sleep(2000);
			w.Edit_Action_Button();
			Thread.sleep(1000);
			w.Comments("Material_Master_Release");// Thread.sleep(2000);
			w.ActionLevel("Release");
			w.Submit();
			w.Yes();
			w.Password_Fill("Hetero@5");
			w.SubmitType_1();w.Ok();driver.close();
		}
	}
}
