package T2_Transactions_Return;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_01_Purchase_Order_Entry_Return extends BaseClass {

	@org.testng.annotations.Test
	public static void Purchase_Order_Entry_Release() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// ********************************************************************************************************************
			// ********************************************************************************************************************
			String Status_Return = xls.getCellData("Changable_Data", "Status_Return", i);// Release//Block//Return
			// Data_Mapping from Purchase Order Entry
			String PurchaseOrder_Number = xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_Number", i);
			// ********************************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ********************************************************************************************************************

			WMPS_Login("Approver_ID", "Approver_Password");
			w.Second_Level();
			w.ReviewApprovalCategory("Purchase Order Release");
			w.Search_Button();
			w.SearchBox(PurchaseOrder_Number);
			Thread.sleep(2000);
			w.Edit_Action_Button();
			w.Comments("Purchase_Order_Entry_Release");
			Thread.sleep(2000);
			w.ActionLevelApproverAction(Status_Return);
			w.Save();
			w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Approver_Password"));
			w.SubmitType_2();
			w.Ok();

		}
//		driver.close();
	}
}
