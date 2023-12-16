package com.master.neagative.test;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_03_Material_Master_ReInitiate extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);
			String Material_Type =xls.getCellData("Excel_Data", "Material_Type", i);
			String Material_Long_Description =xls.getCellData("Excel_Data", "Material_Long_Description", i);
			String Material_Code =xls.getCellData("Excel_Data", "Material_Code", i);

			String Material_Description_Edit =xls.getCellData("Excel_Data", "Material_Description_Edit", i);
			String Material_Code_Edit =xls.getCellData("Excel_Data", "Material_Code_Edit", i);
			String Material_Long_Description_Edit =xls.getCellData("Excel_Data", "Material_Long_Description_Edit", i);

			WMPS_Login("441111","Password");
			w.Menu();
			mp.Material_Master();			
			w.SearchBox(Material_Description);
			w.Edit_Action_Button();
//			mp.Material_Code_SK(Material_Code_Edit);			
//			mp.Material_Description_SK(Material_Description_Edit);
//			mp.Material_Long_Description_SK(Material_Long_Description_Edit);
			w.Remarks("ReInitiate the record");
			w.Submit();
			E_Signature_Masters("Password");
		}}}
