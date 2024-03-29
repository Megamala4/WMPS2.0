package T4_Transactions_Release;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_05_Batch_Order_Release extends BaseClass {

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);

		WMPS_Login("Approver_ID", "Approver_Password");

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// *******************************************************************************************************************
			String Batch_Number_I = xls.getCellData("Dependency", "Batch_Number_I", i);
			String Batch_Number_II = xls.getCellData("Dependency", "Batch_Number_II", i);
			// *******************************************************************************************************************
			// *******************************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// *******************************************************************************************************************
			w.Menu_Navigate();
			w.Menu_Navigate();
			w.Second_Level();
			w.ReviewApprovalCategory("Batch Order Release");
			w.Search_Button();
			w.SearchBox(Batch_Number_I);
			w.EDIT_TITLE();
			w.Comments("Batch_Order_Release");
			Thread.sleep(2000);
			w.ActionLevelApproverAction("Release");
			w.Submit();
			w.Yes();
			Thread.sleep(2000);
			w.Password_Fill(ApproverPassword);
			w.SubmitType_1();
			w.Ok();

		}
	}
}
