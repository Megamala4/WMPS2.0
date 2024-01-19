package T3_Transaction_ReInitiate;
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
		WMPS_Login("Initiator", "Initiator_Password");
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// ********************************************************************************************************************
			String PurchaseOrder_Number = xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_Number", i);// Unique
			// ********************************************************************************************************************
			String Requested_Quantity_Edit = xls.getCellData("PurchaseOrderEntry", "Requested_Quantity_Edit", i);
			String RequestUOM = xls.getCellData("PurchaseOrderEntry", "RequestUOM", i);
			String Received_Quantity_Edit = xls.getCellData("PurchaseOrderEntry", "Received_Quantity_Edit", i);
			String ReceivedUOM = xls.getCellData("PurchaseOrderEntry", "RequestUOM", i);
			String Remarks = xls.getCellData("PurchaseOrderEntry", "Remarks", i);
			// ********************************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ********************************************************************************************************************
			w.Purchase_Order();
			w.Purchase_Order_Entry();
			// ********************************************************************************************************************
			w.SearchBox(PurchaseOrder_Number);Thread.sleep(2000);
			// ********************************************************************************************************************
			w.Edit_Action_Button();
			w.RequestQuantity(Requested_Quantity_Edit+"0");//12000
			w.ReceivedQuantity(Received_Quantity_Edit);//same 10000
			w.Remarks(Remarks);
			w.Add_Button();
			w.Update_Button();w.Yes();
			w.Password_Fill(InitiatorPassword);
			w.Submit_Button();w.Ok();
			w.Eye_FF_01();
		}
		driver.close();
	}
}
