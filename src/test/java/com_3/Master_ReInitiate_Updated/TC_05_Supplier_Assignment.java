package com_3.Master_ReInitiate_Updated;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_05_Supplier_Assignment extends BaseClass
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
		
		WMPS_Login("Initiator","Password");

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 		
			String MaterialMasterRM =xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String Vendor_Name_Manufacturer =xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier =xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			String Password=xls.getCellData("Changable_Data", "Password", i);
			
			//String Today_Date =xls.getCellData("Changable_Data", "Today_Date", i);
			String DateToday =xls.getCellData("Date", "DateToday", i);
		
			mp.Master_Click();
			mp.Supplier_Assignment();
			w.Create();	
			mp.Material_Description_Text(MaterialMasterRM);			
			mp.Manfacturer_Name_Text(Vendor_Name_Manufacturer);			
			mp.Name_of_the_Supplier(Vendor_Name_Supplier);
			w.VendorStatusDD("Approved");
			w.qualifiedDate(DateToday);			
			w.Save();
			w.Yes();
			//w.Password_Fill("");w.Submit_Type();w.Ok();
			//w.Password_Fill(WrongPassword);w.Submit_Type();
			w.Password_Fill(Password);
			w.Submit_Type();w.Ok();
		}}}
