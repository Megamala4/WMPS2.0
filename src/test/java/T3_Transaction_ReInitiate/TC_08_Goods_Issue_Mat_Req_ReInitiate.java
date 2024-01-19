package T3_Transaction_ReInitiate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_08_Goods_Issue_Mat_Req_ReInitiate extends BaseClass {

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
			String BOM_BatchNo_I = xls.getCellData("Dependency", "BOM_BatchNo_I", i);
			// ************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// *************************************************************************************************

			WMPS_Login("Initiator", "Initiator_Password");
			w.Menu_Navigate();
			w.Menu_Navigate();
			w.WareHouse();
			w.Goods_Issue_Mat_Req();
			w.SearchBox(BOM_BatchNo_I);
			w.Edit_Action_Button();
			w.Issue_Button();
			w.Yes();
			w.Password_Fill(InitiatorPassword);
			// w.SubmitType12();w.Ok();
		}
	}
}
