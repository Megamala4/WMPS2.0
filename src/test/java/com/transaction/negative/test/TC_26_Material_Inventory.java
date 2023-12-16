package com.transaction.negative.test;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_26_Material_Inventory extends BaseClass
{

	@org.testng.annotations.Test
	public static void Material_Inventory() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		WMPS_Login("441111","Password");

		w.Menu_Navigate();
		w.Transactions();
		w.WareHouse();
		w.Material_Inventory();
		w.Menu_Navigate();

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Batch_Number =xls.getCellData("Changable_Data", "Batch_Number", i);

			w.SearchBox(Batch_Number);
		scrollPagedown();
		}}}
