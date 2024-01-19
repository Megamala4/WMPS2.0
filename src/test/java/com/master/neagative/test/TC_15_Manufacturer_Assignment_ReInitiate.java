package com.master.neagative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_15_Manufacturer_Assignment_ReInitiate extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=rowcount;i++)
		{ 
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);
			String Vendor_name =xls.getCellData("Excel_Data", "Vendor_name_Manufacturer", i);
			String fromdate =xls.getCellData("Manufacturer_Assignment", "fromdate", i);
			String ToDate_Edit =xls.getCellData("Manufacturer_Assignment", "ToDate_Edit", i);
			WMPS_Login("441111","Password");
			w.Menu();
			mp.Manufacture_Master();
			w.SearchBox(Vendor_name);w.Edit_Action_Button();	
			mp.Material_Description_Text(Material_Description);
			mp.Manfacturer_Name_Text(Vendor_name);			
			Select vs=new Select(driver.findElement(By.xpath("//*[@formcontrolname='vendorStatus']")));vs.selectByIndex(2);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='fromDate']")).sendKeys(fromdate);Thread.sleep(4000); // from date
			driver.findElement(By.xpath("//*[@formcontrolname='todate']")).sendKeys(ToDate_Edit);Thread.sleep(4000); // to date
			w.Comments("A strategic plan this year to reinitiate the accreditation process");
			w.Update_Button();
			E_Signature_Masters("Password");
		}}}
