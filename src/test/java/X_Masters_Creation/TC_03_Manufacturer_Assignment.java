package X_Masters_Creation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_03_Manufacturer_Assignment extends BaseClass
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
			
			
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);//**************
			String Vendor_Name_Manufacturer =xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier =xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);


//			String materialtype =xls.getCellData("Material_Master", "Material_Type", i);
//			String Material_Long_Description =xls.getCellData("Material_Master", "Material_Long_Description", i);
//			String Stage =xls.getCellData("Material_Master", "Stage", i);
//			String Purchase_UOM =xls.getCellData("Material_Master", "Purchase_UOM", i);
//			String Material_Code =xls.getCellData("Material_Master", "Material_Code", i);
//			String Material_Number =xls.getCellData("Material_Master", "Material_Number", i);
//			String Basic_Unit_Of_Measurement =xls.getCellData("Material_Master", "Basic_Unit_Of_Measurement", i);
//			String Production_Starting_Yrear =xls.getCellData("Material_Master", "Production_Starting_Yrear", i);
//			String Procurement_Type =xls.getCellData("Material_Master", "Procurement_Type", i);
//			String Storage_Conditions =xls.getCellData("Material_Master", "Storage_Conditions", i);
//			String Specification_STP_No =xls.getCellData("Material_Master", "Specification_STP_No", i);
//			String Rounding =xls.getCellData("Material_Master", "Rounding", i);	
//			String Inspectiontype =xls.getCellData("Datafields_ALL", "Inspectiontype", i);
//			String Edit_InspectionType =xls.getCellData("Datafields_ALL", "Edit_InspectionType", i);
//			String Vendor_type =xls.getCellData("Vendor_Supplier", "Vendor_type", i);	
//			String Street =xls.getCellData("Vendor_Supplier", "Street", i);
//			String Street1 =xls.getCellData("Vendor_Supplier", "Street1", i);
//			String Street2 =xls.getCellData("Vendor_Supplier", "Street2", i);
//			String City =xls.getCellData("Vendor_Supplier", "City", i);	
//			String Postal_Code =xls.getCellData("Vendor_Supplier", "Postal_Code", i);	
//			String Countries =xls.getCellData("Vendor_Supplier", "Country", i);	
//			String State =xls.getCellData("Vendor_Supplier", "State", i);
//			String Material_Name =xls.getCellData("Manufacturer_Assignment", "Material_Name", i);
//			String Manufacturer_name =xls.getCellData("Manufacturer_Assignment", "Manufacturer_name", i);


			//String Material_Description =xls.getCellData("Material_Master", "Material_Description", i);
			String Vendor_name =xls.getCellData("Vendor_Supplier", "Vendor_name", i);
			
			String fromdate =xls.getCellData("Manufacturer_Assignment", "fromdate", i);
			String todate =xls.getCellData("Manufacturer_Assignment", "todate", i);
			
			WMPS_Login("441111","Password");

			mp.Master_Click();

			mp.Manufacture_Master();
			w.Create();			

	
			mp.Material_Description_Text(Material_Description);
			mp.Manfacturer_Name_Text(Vendor_Name_Manufacturer);
			
			Select vs=new Select(driver.findElement(By.xpath("//*[@formcontrolname='vendorStatus']")));vs.selectByIndex(2);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='fromDate']")).sendKeys(fromdate);Thread.sleep(4000); // from date
			driver.findElement(By.xpath("//*[@formcontrolname='todate']")).sendKeys(todate);Thread.sleep(4000); // to date
			w.Comments("Created");
			w.Submit();
			
			w.Yes();
			
//			w.Password_Fill("");w.Submit_Type();
//			w.Password_Fill(WrongPassword);w.Submit_Type();w.Ok();
			
			w.Password_Fill("321");w.Submit_Type();w.Ok();	
			
			//E_Signature_Masters("Password");

		}}}
