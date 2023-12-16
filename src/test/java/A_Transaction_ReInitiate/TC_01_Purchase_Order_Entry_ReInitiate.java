package A_Transaction_ReInitiate;
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

public class TC_01_Purchase_Order_Entry_ReInitiate extends BaseClass {

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
		for (int i = 2; i <= 2; i++) {
			String PurchaseOrder_Number = xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_Number", i);// Unique

			String DateToday = xls.getCellData("Date", "DateToday", i);// Today

			String Vendor_Name_Supplier = xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);// Mapping
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);// Mapping

			String Requested_Quantity_Edit = xls.getCellData("PurchaseOrderEntry", "Requested_Quantity_Edit", i);
			String RequestUOM = xls.getCellData("PurchaseOrderEntry", "RequestUOM", i);
			String Received_Quantity_Edit = xls.getCellData("PurchaseOrderEntry", "Received_Quantity_Edit", i);
			String ReceivedUOM = xls.getCellData("PurchaseOrderEntry", "RequestUOM", i);
			String Remarks = xls.getCellData("PurchaseOrderEntry", "Remarks", i);

			WMPS_Login("441111", "Password");
			w.Purchase_Order();
			w.Purchase_Order_Entry();
			w.Edit_Action_Button();
			w.RequestQuantity(Requested_Quantity_Edit);
			w.ReceivedQuantity(Received_Quantity_Edit);
			w.Remarks(Remarks);
			driver.findElement(By.id("Purchse-entry-add")).click();
			Thread.sleep(2000); // add
			w.UpdateButton();
			Thread.sleep(2000);
			w.Yes();
			w.Password_Fill("321");
			w.SubmitType_1();
			w.Ok();
			driver.close();
		}
	}
}
