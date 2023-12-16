
package X_Masters_Creation;

import org.openqa.selenium.By;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_01_Material_Master extends BaseClass
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
			String materialtype =xls.getCellData("Material_Master", "Material_Type", i);
			String Material_Description =xls.getCellData("Material_Master", "Material_Description", i);
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

			WMPS_Login("441111","Password");
			w.Menu();
			mp.Material_Master();
			w.Create();
			mp.Meterial_Type_Text(materialtype);//mp.DropDown_Select();			
			//mp.Material_Code_SK(Material_Code);
			//mp.Stage_SK(Stage);
			mp.Material_Description_SK(Material_Description);
			mp.Material_Long_Description_SK(Material_Long_Description);
			mp.Purchase_UOM_Text(Purchase_UOM);mp.DropDown_Select();
			//mp.Purchase_UOM_Select();
			mp.Material_Number_SK(Material_Number);
			mp.Basic_Unit_of_Measurement_Text(Basic_Unit_Of_Measurement);mp.DropDown_Select();
			//mp.Basic_Unit_of_Measurement_Select();
			mp.Storage_Conditions_Text(Storage_Conditions);mp.DropDown_Select();
			//mp.Storage_Conditions_Select();
			mp.Specification_STP_No_SK(Specification_STP_No);
			mp.Procurement_Type_Text("I");mp.DropDown_Select();
			//mp.Procurement_Type_Select();
			mp.Rounding_Text(Rounding);mp.DropDown_Select();
			//mp.Procurement_Type_Select();
			mp.Production_Starting_Year(Production_Starting_Yrear);
			mp.Remarks_SK("Remarks");
			mp.Alternate_UOM_X("1");
			mp.Alternate_UOM_Y("1");
			mp.Alt_UOM_DD_Select("L");
			mp.Altuomyear("");
			//Quality Management
			mp.QualityManagement_Click();Thread.sleep(2000);
			mp.Inspect_Intervel_Period_SK("45Days");Thread.sleep(2000);
			//mp.inspectYear(pro2.getProperty("inspectYear"));Thread.sleep(2000);
//			mp.inspectiontype();Thread.sleep(2000);
//			mp.inspectiontypeClick();Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();Thread.sleep(2000);
			mp.Storage_Locations_Click();
			mp.Storageclick();
		//	mp.Storage();
			driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
			w.Submit();
			E_Signature_Masters("Password");

		}}}
