package T2_Transactions_Return;

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

public class TC_02_Good_Recipt_With_PO_Return extends BaseClass {

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
			String MaterialMasterRM =xls.getCellData("Excel_Data", "MaterialMasterRM", i);//For RAW Material Masters only

			//***************************************************************************************************************
			//Data_Mapping from Purchase Order Entry				
			String PurchaseOrder_Number =xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_Number", i);
			//***************************************************************************************************************
			//***************************************************************************************************************
			//Data_Mapping			
			String Vendor_Name_Manufacturer =xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier =xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			//***************************************************************************************************************
			//***************************************************************************************************************
			String Today_Date =xls.getCellData("Changable_Data", "Today_Date", i);
			String OneMonthLater =xls.getCellData("Changable_Data", "OneMonthLater", i);
			String OneYearLater =xls.getCellData("Changable_Data", "OneYearLater", i);
			String Past_Date =xls.getCellData("Changable_Data", "Past_Date", i);
			//***************************************************************************************************************
			//***************************************************************************************************************
			String Date1MB =xls.getCellData("Date", "Date1MB", i);
			String DateToday =xls.getCellData("Date", "DateToday", i);
			String Date1ML =xls.getCellData("Date", "Date1ML", i);
			String Date2ML =xls.getCellData("Date", "Date2ML", i);
			String Date6ML =xls.getCellData("Date", "Date6ML", i);
			//***************************************************************************************************************
			//***************************************************************************************************************
			//***************************************************************************************************************
			String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);
			//***************************************************************************************************************


			

			WMPS_Login("Approver_ID","Approver_Password");	
			w.Second_Level();
			w.ReviewApprovalCategory("Goods Receipt Release");
			w.Search_Button();
			//**********************************************************************************************************
			w.SearchBox(MaterialMasterRM);			Thread.sleep(2000);
			//***************************************************************************************************
			Thread.sleep(2000);
			w.Edit_Action_Button();
			w.Comments("Good_Recipt_With_PO_Returned");
			Thread.sleep(2000);
			w.ActionLevelApproverAction("Return");
			w.Save();w.Yes();
			w.Password_Fill(ApproverPassword);
			// w.SubmitType_2();w.Ok();
			//driver.close();

		}
	}
}
