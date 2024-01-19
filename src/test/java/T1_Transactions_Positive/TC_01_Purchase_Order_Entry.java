package T1_Transactions_Positive;

import org.openqa.selenium.By;
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

public class TC_01_Purchase_Order_Entry extends BaseClass {

	@org.testng.annotations.Test
	public static void Purchase_Order_Entry() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);

		WMPS_Login("Initiator", "Initiator_Password");
		w.Purchase_Order();
		w.Purchase_Order_Entry();
		Thread.sleep(4000);

		for (int i = 2; i <= 2; i++) {
			// ********************************************************************************************************************
			String PurchaseOrder_Number = xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_Number", i);// Unique
			String DateToday = xls.getCellData("Date", "DateToday", i);// Today
			// ********************************************************************************************************************
			String Vendor_Name_Supplier_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Supplier_Edit", i);
			String Vendor_Name_Manufacturer_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer_Edit", i);
			String MaterialMasterRM_Edit = xls.getCellData("Excel_Data", "MaterialMasterRM_Edit", i);

			String Vendor_Name_Supplier = xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);// Mapping
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);// Mapping
			
			String Requested_Quantity = xls.getCellData("PurchaseOrderEntry", "Requested_Quantity", i);
			String RequestUOM = xls.getCellData("PurchaseOrderEntry", "RequestUOM", i);
			String Received_Quantity = xls.getCellData("PurchaseOrderEntry", "Received_Quantity", i);
			String ReceivedUOM = xls.getCellData("PurchaseOrderEntry", "RequestUOM", i);
			String Remarks = xls.getCellData("PurchaseOrderEntry", "Remarks", i);
			// ********************************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ********************************************************************************************************************
			Thread.sleep(4000);
			w.Entry_Button();
			w.PurchaseOrderNumber(PurchaseOrder_Number);
			// w.Remarks(Material_Description);
			w.PurchaseOrderDate(DateToday);
			w.DD_01(Vendor_Name_Supplier_Edit);
			w.DD_02(MaterialMasterRM_Edit);
			w.DD_03(Vendor_Name_Manufacturer_Edit);
			w.RequestQuantity(Requested_Quantity);
			w.ReceivedQuantity(Received_Quantity);
			w.RequestUOM_SK(RequestUOM);
			w.RecievedUOM_SK(ReceivedUOM);
			w.Remarks(Remarks);
			w.Add_Button();
			w.Save_Button();
			w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Initiator_Password"));
			w.Submit_Button();
			w.Ok();
			// ******************************************************************************************************
			//w.SearchBox(Vendor_Name_Supplier);
			w.SearchBox(PurchaseOrder_Number);
			// ******************************************************************************************************
			w.ViewButton();scrollPagedown();

		}
		// driver.close();
	}
}
