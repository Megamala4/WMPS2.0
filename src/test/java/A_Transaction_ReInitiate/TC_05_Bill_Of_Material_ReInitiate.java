package A_Transaction_ReInitiate;

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


public class TC_05_Bill_Of_Material_ReInitiate extends BaseClass
{

	@org.testng.annotations.Test
	public static void Bill_Of_Material() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		WMPS_Login("441111","Password");
		w.Menu_Navigate();w.Menu_Navigate();
		w.Production();w.BillOfMaterial();
		//w.Create();
       w.Edit_Action_Button();
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)		
		{
			String MaterialMasterSFP=xls.getCellData("Excel_Data", "MaterialMasterSFP", i);	//New Semifinished Material Upper Part				
			String VersionNumber_I =xls.getCellData("Dependency", "VersionNumber_I", i);//Change Everytime					
//Always Change
			String Version_Number =xls.getCellData("Bill_Of_Material", "Version_Number", i);
			String BPR_Number_I =xls.getCellData("Bill_Of_Material", "BPR_Number_I", i);

			String MaterialMasterRM =xls.getCellData("Excel_Data", "MaterialMasterRM", i);//Low
			String BatchSize =xls.getCellData("Bill_Of_Material", "BatchSize", i);//BOM??Baatch order(static) // create test request
			String Remarks =xls.getCellData("PurchaseOrderEntry", "remarks", i);
			String Number_Of_Lots =xls.getCellData("Bill_Of_Material", "numberLots", i);
			String BPR_Type =xls.getCellData("Bill_Of_Material", "BPR_Type", i);
			String StandardQuantity =xls.getCellData("Bill_Of_Material", "statnderdQuantity", i);
			String High =xls.getCellData("Bill_Of_Material", "High", i);
			String Low =xls.getCellData("Bill_Of_Material", "low", i);
			String material_name =xls.getCellData("Goods_ReceiptWith_WithOut", "material_name", i);
			String BatchNoFromGoodRecipt =xls.getCellData("VVI", "BatchNoFromGoodRecipt", i);
			String delivery_challan_No =xls.getCellData("Goods_ReceiptWith_WithOut", "delivery_challan_No", i);
			String manufacturing_date =xls.getCellData("Goods_ReceiptWith_WithOut", "manufacturing_date", i);
			String vendor_Retest =xls.getCellData("Goods_ReceiptWith_WithOut", "vendor_Retest", i);
			String Vendor_name_Manufacturer =xls.getCellData("Vendor_Supplier", "Vendor_name_Manufacturer", i);
			String Vendor_name_Supplier =xls.getCellData("Vendor_Supplier", "Vendor_name_Supplier", i);
			String PurchaseOrder_number =xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_number", i);//Purchase Order Entry

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);



			
			w.BPR_Number("1");//***********************UNIQUE	
			w.Remarks(BPR_Number_I);
			w.Submit();w.Yes();
			w.Password_Fill(InitiatorPassword);
		//	w.SubmitType_1();w.Ok();	

		}}}
