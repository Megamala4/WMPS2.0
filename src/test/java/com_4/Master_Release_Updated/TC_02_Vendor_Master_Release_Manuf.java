package com_4.Master_Release_Updated;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_02_Vendor_Master_Release_Manuf extends BaseClass {

	@org.testng.annotations.Test
	public static void Vendor_Master_Release_Manuf() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("VendorMaster");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);

			WMPS_Login("Approver_ID","Approver_Password");
			w.Second_Level();
			w.ReviewApprovalCategory("Vendor Master Release");
			w.Search_Button();
			// w.SearchBox(Vendor_Name_Manufacturer);Thread.sleep(2000);
			// w.SearchBox(" Created");Thread.sleep(2000);Thread.sleep(2000);
			w.Edit_Action_Button();
			w.Comments("Vendor_Master_Release");
			w.ActionLevel("Release");
			w.Submit();
			w.Yes();
			w.Password_Fill("Hetero@5");
			w.SubmitType_2();
			w.Ok();
			driver.close();
		}
	}
}
