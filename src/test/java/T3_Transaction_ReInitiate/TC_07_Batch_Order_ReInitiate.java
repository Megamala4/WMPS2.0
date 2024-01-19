package T3_Transaction_ReInitiate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_07_Batch_Order_ReInitiate extends BaseClass {

	@org.testng.annotations.Test
	public static void Bill_Of_Material() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);

		WMPS_Login("Initiator", "Initiator_Password");

		// ********************************************************************************************************************
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// ****************************************************************************************************

			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);

			// ********************************************************************************************************************
			String MaterialMasterSFP = xls.getCellData("Excel_Data", "MaterialMasterSFP", i);
			// ********************************************************************************************************************
			String Batch_Number_I = xls.getCellData("Dependency", "Batch_Number_I", i);
			String Market = xls.getCellData("ProductRequirement", "Market", i);
			String OrderType = xls.getCellData("Material_Indent", "OrderType", i);
			String Material_Description = xls.getCellData("Material_Master", "Material_Description", i);
			// ****************************************************************************************************
			// ****************************************************************************************************
			// ****************************************************************************************************
			w.Menu_Navigate();
			w.Menu_Navigate();
			w.Production();
			w.BatchOrder();
			// *******************************************************************************************************
//			w.Search_Button(); //**not working
			w.SearchBox(Batch_Number_I);
			// *******************************************************************************************************
			w.Edit_Action_Button();
			Thread.sleep(4000);
			w.Remarks("NA");
			Thread.sleep(4000);
			w.Submit();
			Thread.sleep(4000);
			w.Yes();
			w.Password_Fill(InitiatorPassword);
			w.SubmitType12();w.Ok();
		}
	}
}
