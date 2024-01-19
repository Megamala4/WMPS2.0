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

public class TC_04_Bill_Of_Material_Release extends BaseClass {

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);

		WMPS_Login("Approver_BOM", "Password_BOM");

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// *************************************************************************************************
			String MaterialMasterSFP = xls.getCellData("Excel_Data", "MaterialMasterSFP", i);
			String BPR_Number_I = xls.getCellData("Bill_Of_Material", "BPR_Number_I", i); // ***********************//
			// *************************************************************************************************

			String DateToday = xls.getCellData("Date", "DateToday", i);

			String OneMonthLater = xls.getCellData("Changable_Data", "OneMonthLater", i);
			String OneYearLater = xls.getCellData("Changable_Data", "OneYearLater", i);
			String Past_Date = xls.getCellData("Changable_Data", "Past_Date", i);
			// *************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			String BOM_Password = xls.getCellData("Changable_Data", "BOM_Password", i);
			// *************************************************************************************************
			// *************************************************************************************************
			w.Second_Level();
			w.ReviewApprovalCategory("Bill Of Material Release");
			w.Search_Button();
			// *************************************************************************************************
			w.SearchBox(BPR_Number_I);
			// *************************************************************************************************
			w.Edit_Action_Button();
			w.EffectiveDate(DateToday);// today date required
			w.Comments("BOM_Inspection_Release");
			Thread.sleep(2000);
			w.ActionLevelApproverAction("Release");
			w.Submit();
			w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Password_BOM"));
			w.SubmitType_2();
			w.Ok();
		}
	}
}
