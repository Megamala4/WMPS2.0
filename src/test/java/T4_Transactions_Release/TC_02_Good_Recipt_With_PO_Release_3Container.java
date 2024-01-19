package T4_Transactions_Release;

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

public class TC_02_Good_Recipt_With_PO_Release_3Container extends BaseClass {

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
			// *****************************************************************************************************************
			String PurchaseOrder_Number = xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_Number", i);
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);// For RAW Material Masters
			// *****************************************************************************************************************
			// *****************************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// *****************************************************************************************************************

			WMPS_Login("Approver_ID", "Approver_Password");
			w.Second_Level();
			w.ReviewApprovalCategory("Goods Receipt Release");
			w.Search_Button();
			w.SearchBox(MaterialMasterRM);
			Thread.sleep(3000);
			w.Edit_Action_Button();
			w.Comments("Good_Recipt_With_PO_Release");
			Thread.sleep(2000);
			w.ActionLevelApproverAction("Release");
			// w.Save2();
			w.Yes();
			w.Password_Fill(ApproverPassword);
			w.SubmitType_2();
			w.Ok();
			Thread.sleep(4000);

			w.ActionType_EditAction_Button2();
			w.Comments("Good_Recipt_With_PO_Release");
			Thread.sleep(2000);
			w.ActionLevelApproverAction("Release");
			// w.Save2();
			w.Yes();
			w.Password_Fill(ApproverPassword);
			w.SubmitType_2();
			w.Ok();
			Thread.sleep(4000);

			w.ActionType_EditAction_Button3();
			w.Comments("Good_Recipt_With_PO_Release");
			Thread.sleep(2000);
			w.ActionLevelApproverAction("Release");
			// w.Save2();
			w.Yes();
			w.Password_Fill(ApproverPassword);
			w.SubmitType_2();
			w.Ok();
			Thread.sleep(4000);

			// driver.close();
		}
	}
}
