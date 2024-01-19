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


public class TC_09_Create_Test_Request_ReInitiate extends BaseClass
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
		//w.Menu_Navigate();w.Menu_Navigate();

		w.Production();
		w.Create_Test_Request_Production();Thread.sleep(2000);
//w.Edit_Action_Button();
w.FFP_01();
		int rowcount = xls.getRowCount("Material_Master");

		System.out.println(rowcount);
		for(int i=2; i<=2;i++)		
		{ 	
			String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

			String MaterialMasterSFP=xls.getCellData("Excel_Data", "MaterialMasterSFP", i);	//New Semifinished Material Upper Part		
			String Date =xls.getCellData("Goods_ReceiptWith_WithOut", "manufacturing_date", i);
			String Quantity =xls.getCellData("Material_Indent", "requested_Quantity", i);
			//Mapping
			String Batch_Number_I =xls.getCellData("Dependency", "Batch_Number_I", i);
			//COPIED FROM OTHER
			String BatchSize =xls.getCellData("Bill_Of_Material", "BatchSize", i);//BOM??Baatch order(static) // create test request

			String Date1MB =xls.getCellData("Date", "Date1MB", i);
			String DateToday =xls.getCellData("Date", "DateToday", i);
			String Date1ML =xls.getCellData("Date", "Date1ML", i);
			String Date2ML =xls.getCellData("Date", "Date2ML", i);

		
			w.Remarks(Batch_Number_I);
			w.Submit();w.Yes();
			w.Password_Fill(InitiatorPassword);
		//	w.SubmitType_1();w.Ok();driver.close();

		}}}
