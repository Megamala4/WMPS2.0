package com.master.neagative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Master_Xpaths;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_05_Vendor_Master_Manufacturer extends BaseClass
{

	@org.testng.annotations.Test
	public static void Vendor_Master() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=rowcount;i++)
		{ 
			
			String Vendor_name =xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Street_Edit =xls.getCellData("Excel_Data", "Street", i);

			String Street =xls.getCellData("Vendor_Supplier", "Street", i);
			String Street1 =xls.getCellData("Vendor_Supplier", "Street1", i);
			String Street2 =xls.getCellData("Vendor_Supplier", "Street2", i);
			String City =xls.getCellData("Vendor_Supplier", "City", i);	
			String Postal_Code =xls.getCellData("Vendor_Supplier", "Postal_Code", i);	
			String Countries =xls.getCellData("Vendor_Supplier", "Country", i);	
			String State =xls.getCellData("Vendor_Supplier", "State", i);
			
			WMPS_Login("441111","Password");
			w.Menu();
			mp.Vendor_Master();
			w.Create();
			Select Vendor_Type_DDselect=new Select(driver.findElement(By.xpath("//*[@formcontrolname='vendorType']")));
			Vendor_Type_DDselect.selectByIndex(0);Thread.sleep(2000);			
			mp.Vendor_Name_SK(Vendor_name);			
			driver.findElement(By.xpath("//*[@formcontrolname='street']")).sendKeys(Street);Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@formcontrolname='street1']")).sendKeys(Street1);Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@formcontrolname='street2']")).sendKeys(Street2);Thread.sleep(1000);					
			Select country=new Select(driver.findElement(By.xpath("//*[@formcontrolname='country']")));country.selectByIndex(4);Thread.sleep(2000);
			Select state=new Select(driver.findElement(By.xpath("//*[@formcontrolname='state']")));state.selectByIndex(2);Thread.sleep(2000);
			Select city=new Select(driver.findElement(By.xpath("//*[@formcontrolname='cityId']")));city.selectByIndex(2);Thread.sleep(2000);		
			mp.Postal_Code(Postal_Code);Thread.sleep(2000);
			w.Submit();			
			E_Signature1("Password");
		}}}



		
