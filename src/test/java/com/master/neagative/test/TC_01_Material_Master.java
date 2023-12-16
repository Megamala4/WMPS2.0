package com.master.neagative.test;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_01_Material_Master extends BaseClass
{

	@org.testng.annotations.Test
	public static void Material_Master() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);//*************************8
			
			String Material_Type =xls.getCellData("Excel_Data", "Material_Type", i);
			String Material_Long_Description =xls.getCellData("Excel_Data", "Material_Long_Description", i);
			
			String Material_Code =xls.getCellData("Excel_Data", "Material_Code", i);//Sometimes not while Raw_Material
			
			String Stage =xls.getCellData("Material_Master", "Stage", i);
			String Purchase_UOM =xls.getCellData("Material_Master", "Purchase_UOM", i);
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
			mp.Meterial_Type_Text(Material_Type);//Keys_Enter					
			//mp.Material_Code_SK(Material_Code);//nakko in Raw Material			
			//mp.Stage_SK(Stage);//nakko in Raw Material
			mp.Material_Description_SK(Material_Description);
			mp.Material_Long_Description_SK(Material_Long_Description);
			mp.Purchase_UOM_Text(Purchase_UOM);mp.DropDown_Select();
			mp.Material_Number_SK(Material_Number);
			mp.Basic_Unit_of_Measurement_Text(Basic_Unit_Of_Measurement);mp.DropDown_Select();
			mp.Storage_Conditions_Text(Storage_Conditions);mp.DropDown_Select();
			mp.Specification_STP_No_SK(Specification_STP_No);
			mp.Procurement_Type_Text(" EXTERNAL ");mp.DropDown_Select();
			mp.Rounding_Text(Rounding);mp.DropDown_Select();
			//mp.Production_Starting_Year(Production_Starting_Yrear);//nakko in Raw Material		
			mp.Remarks_SK("Remarks");
			mp.Alternate_UOM_X("1");
			mp.Alternate_UOM_Y("1");
		//	mp.Alt_UOM_DD("L");
			mp.Altuomyear("");
			mp.QualityManagement_Click();Thread.sleep(2000);
			mp.Inspect_Intervel_Period_SK("45Days");Thread.sleep(2000);
			//mp.inspectYear(pro2.getProperty("inspectYear"));Thread.sleep(2000);
	//		mp.inspectiontype();Thread.sleep(2000);
//			mp.inspectiontypeClick();Thread.sleep(2000);
			w.CheckBox_1();w.CheckBox_2();w.CheckBox_3();
			mp.Storage_Locations_Click();
			mp.Storageclick();
		//	mp.Storage();
			w.CheckBox_4();w.Submit();
			//E_Signature_Masters("Password");
		}}}
