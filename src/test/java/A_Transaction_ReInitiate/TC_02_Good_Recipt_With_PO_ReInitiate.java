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


public class TC_02_Good_Recipt_With_PO_ReInitiate extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 

			String po_date =xls.getCellData("PurchaseOrderEntry", "po_date", i);
			String supplier =xls.getCellData("Manufacturer_Assignment", "Name_Of_Supplier", i);
			String material_Description =xls.getCellData("Manufacturer_Assignment", "Material_Name", i);
			String Manufaturer =xls.getCellData("Manufacturer_Assignment", "Manufacturer_name", i);
			String Requested_Quantity =xls.getCellData("PurchaseOrderEntry", "Requested_Quantity", i);
			String Received_Quantity =xls.getCellData("PurchaseOrderEntry", "Received_Quantity", i);
			String UOM =xls.getCellData("PurchaseOrderEntry", "UOM", i);
			String remarks =xls.getCellData("PurchaseOrderEntry", "remarks", i);
			String nu_of_container =xls.getCellData("Goods_ReceiptWith_WithOut", "no_of_container", i);
			String DCInvoiceNumber_Edit =xls.getCellData("Goods_ReceiptWith_WithOut", "DCInvoiceNumber_Edit", i);
			String manufacturing_date =xls.getCellData("Goods_ReceiptWith_WithOut", "manufacturing_date", i);
			String vendor_Retest =xls.getCellData("Goods_ReceiptWith_WithOut", "vendor_Retest", i);
			
			//Data_Mapping from Purchase Order Entry				
			String PurchaseOrder_Number =xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_Number", i);

//Data_Mapping			
			String Vendor_Name_Manufacturer =xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier =xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);
			
			
			String Today_Date =xls.getCellData("Changable_Data", "Today_Date", i);
			String OneMonthLater =xls.getCellData("Changable_Data", "OneMonthLater", i);
			String OneYearLater =xls.getCellData("Changable_Data", "OneYearLater", i);
			String Past_Date =xls.getCellData("Changable_Data", "Past_Date", i);
			
			//***********************************************************************************************************************************
			String Date1MB =xls.getCellData("Date", "Date1MB", i);
			String DateToday =xls.getCellData("Date", "DateToday", i);
			String Date1ML =xls.getCellData("Date", "Date1ML", i);
			String Date2ML =xls.getCellData("Date", "Date2ML", i);
			String Date6ML =xls.getCellData("Date", "Date6ML", i);

//***********************************************************************************************************************************

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);


			WMPS_Login("441111","Password");
			w.WareHouse();w.Goods_Receipt();
			w.Menu_Navigate();
 			w.Edit_Action_Button();	
			w.DCEInvoiceNumber(DCInvoiceNumber_Edit);
			w.Proceed_Button();
			w.Yes();						
			w.Password_Fill(InitiatorPassword);
			//w.SubmitType_1();w.Ok();driver.close();
		}}}
			