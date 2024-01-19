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

public class TC_02_Good_Recipt_With_PO_ReInitiate extends BaseClass {

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception {
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
			// Data_Mapping from Purchase Order Entry
			// *******************************************************************************************************			
			String PurchaseOrder_Number = xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_Number", i);
			String MaterialMasterRM = xls.getCellData("Excel_Data", "MaterialMasterRM", i);// For RAW Material Master																																				
			String DCInvoiceNumber_Edit = xls.getCellData("Goods_ReceiptWith_WithOut", "DCInvoiceNumber_Edit", i);
			// *******************************************************************************************************			
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// *******************************************************************************************************			
			w.WareHouse();
			w.Goods_Receipt();
			// *******************************************************************************************************
			w.SearchBox(PurchaseOrder_Number);Thread.sleep(1000);
			//w.SearchBox("IWN24000003");Thread.sleep(1000);
			// *******************************************************************************************************
			Thread.sleep(2000);
			w.Edit_Action_Button();Thread.sleep(5000);
			w.DCEInvoiceNumber(DCInvoiceNumber_Edit+"A");
			w.Proceed_Button();
			w.Yes();
			w.Password_Fill(InitiatorPassword);
			w.Submit_Button();
			w.Ok();
			// *******************************************************************************************************
			w.SearchBox(PurchaseOrder_Number);
			//w.SearchBox("IWN24000003");Thread.sleep(1000);
			// *******************************************************************************************************
			w.Eye_FF_01();
		}
//		driver.close();
	}
}
