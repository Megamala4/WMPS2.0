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


public class TC_06_Product_Requirement_Return extends BaseClass
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
			String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);			

			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);

			String materialtype =xls.getCellData("Material_Master", "Material_Type", i);
			//String Material_Description =xls.getCellData("Material_Master", "Material_Description", i);
			String Material_Long_Description =xls.getCellData("Material_Master", "Material_Long_Description", i);
			String Stage =xls.getCellData("Material_Master", "Stage", i);
			String Purchase_UOM =xls.getCellData("Material_Master", "Purchase_UOM", i);
			String Material_Code =xls.getCellData("Material_Master", "Material_Code", i);
			String Material_Number =xls.getCellData("Material_Master", "Material_Number", i);
			String Basic_Unit_Of_Measurement =xls.getCellData("Material_Master", "Basic_Unit_Of_Measurement", i);
			String Production_Starting_Yrear =xls.getCellData("Material_Master", "Production_Starting_Yrear", i);
			String Procurement_Type =xls.getCellData("Material_Master", "Procurement_Type", i);
			String Storage_Conditions =xls.getCellData("Material_Master", "Storage_Conditions", i);
			String Specification_STP_No =xls.getCellData("Material_Master", "Specification_STP_No", i);
			String Rounding =xls.getCellData("Material_Master", "Rounding", i);	
			String Inspectiontype =xls.getCellData("Datafields_ALL", "Inspectiontype", i);
			String Edit_InspectionType =xls.getCellData("Datafields_ALL", "Edit_InspectionType", i);

			WMPS_Login_Release("441122","ApproverPassword");			
			w.Second_Level();	
			w.ReviewApprovalCategory("Product Requirement Release");
			w.Search_Button();	
			w.SearchBox(Material_Description);Thread.sleep(2000);Thread.sleep(2000);
			w.Edit_Action_Button();	
			w.Comments("Manufacture_Master_Release");Thread.sleep(2000);			
			w.ActionLevel("Return");
			w.Submit();Thread.sleep(2000);w.Yes();
			w.Password_Fill(Pro.getProperty("ApproverPassword"));
			//w.Submit_Text();w.Ok();	
		}}}
