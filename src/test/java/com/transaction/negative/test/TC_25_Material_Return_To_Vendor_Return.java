package com.transaction.negative.test;

import org.openqa.selenium.By;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_25_Material_Return_To_Vendor_Return extends BaseClass
{

	@org.testng.annotations.Test
	public static void Material_Return_To_Vendor() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		WMPS_Login("441111","Password");

		w.Menu_Navigate();
		w.Transactions();
		w.WareHouse();
		w.Material_Return_To_Vendor();
		w.Menu_Navigate();

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);
			String Batch_Number =xls.getCellData("Changable_Data", "Batch_Number", i);

			w.SearchBox(Material_Description);Thread.sleep(2000);Thread.sleep(2000);
			w.ActionType_EditAction_Button3();            
		}}}
