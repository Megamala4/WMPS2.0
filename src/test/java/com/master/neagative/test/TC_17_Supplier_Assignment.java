package com.master.neagative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_17_Supplier_Assignment extends BaseClass
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
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);
			String Vendor_name_Manufacturer =xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Name_of_the_Supplier =xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			
			String ToDate_Edit =xls.getCellData("Manufacturer_Assignment", "ToDate_Edit", i);
			
			WMPS_Login("441111","Password");
			w.Menu();
			mp.Supplier_Assignment();
			w.Create();			
			mp.Material_Description_Text(Material_Description);			
			mp.Manfacturer_Name_Text(Vendor_name_Manufacturer);			
			mp.Name_of_the_Supplier(Name_of_the_Supplier);
			Select vs=new Select(driver.findElement(By.xpath("//*[@formcontrolname='supplierStatus']")));vs.selectByIndex(1);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='qualifiedDate']")).sendKeys(ToDate_Edit);Thread.sleep(4000);
			w.Submit();
			E_Signature_Masters("Password");
		}}}
