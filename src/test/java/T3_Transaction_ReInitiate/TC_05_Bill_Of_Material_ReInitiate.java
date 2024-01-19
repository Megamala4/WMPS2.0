package T3_Transaction_ReInitiate;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_05_Bill_Of_Material_ReInitiate extends BaseClass {

	@org.testng.annotations.Test
	public static void Bill_Of_Material() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);
		// ***************************************************************************************************************
		// *************************************************************************************************

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// *************************************************************************************************
			String MaterialMasterSFP = xls.getCellData("Excel_Data", "MaterialMasterSFP", i);
			String BPR_Number_I = xls.getCellData("Dependency", "BPR_Number_I", i);																		// Material Upper Part
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			WMPS_Login("Initiator", "Initiator_Password");
			w.Menu_Navigate();
			w.Menu_Navigate();
			w.Production();
			w.BillOfMaterial();
			// *************************************************************************************************
			//w.SearchBox(BPR_Number_I);Thread.sleep(2000);
			w.SearchBox("BOM-RITONAVIR (FORM-I)-088-");Thread.sleep(2000);//REMOVE LAST TWO NUMBERS
			// *************************************************************************************************
			w.Edit_Action_Button();
			w.Remarks("BOM Reinitiated");
			w.Submit_Button();
			w.Yes();
			w.Password_Fill(InitiatorPassword);
			w.Submit_Button2();w.Ok();
			// *************************************************************************************************
			//w.SearchBox(BPR_Number_I);Thread.sleep(2000);
			w.SearchBox("BOM-RITONAVIR (FORM-I)-088-");Thread.sleep(2000);//REMOVE LAST TWO NUMBERS
			// *************************************************************************************************
			w.Eye_FF_01();
		}
	}
}
