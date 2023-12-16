package com.master.neagative.test;

import org.openqa.selenium.By;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_19_Supplier_Assignment_ReInitiate extends BaseClass
{

	@org.testng.annotations.Test
	public static void Supplier_Assignment() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=rowcount;i++)
		{ 
			String ToDate_Edit1 =xls.getCellData("Manufacturer_Assignment", "ToDate_Edit1", i);
			String Name_of_the_Supplier =xls.getCellData("Excel_Data", "Vendor_name_Supplier", i);

			WMPS_Login("441111","Password");
			w.Menu();
			mp.Supplier_Assignment();
			w.SearchBox(Name_of_the_Supplier);
			w.Edit_Action_Button();
			w.Remarks("Reinitiate the record");
			w.UpdateButton();
			//w.OK_BUTTON();
			driver.findElement(By.xpath("//*[@formcontrolname='qualifiedDate']")).sendKeys(ToDate_Edit1);Thread.sleep(4000);
			w.UpdateButton();
			E_Signature_Masters("Password");
		}}}
