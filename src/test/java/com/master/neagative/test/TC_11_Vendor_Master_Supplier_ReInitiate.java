package com.master.neagative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_11_Vendor_Master_Supplier_ReInitiate extends BaseClass
{

	@org.testng.annotations.Test
	public static void Vendor_Master() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=rowcount;i++)
		{ 
			
			String Vendor_name =xls.getCellData("Excel_Data", "Vendor_name_Supplier", i);
			String Street_Edit =xls.getCellData("Excel_Data", "Street", i);
			
			WMPS_Login("441111","Password");
			w.Menu();
			mp.Vendor_Master();
			w.SearchBox(Vendor_name);
			w.Edit_Action_Button();
			w.Comments("Vendor_Master_Supplier_ReInitiate");
			w.UpdateButton();
		//	w.OK_BUTTON();	
			driver.findElement(By.xpath("//*[@formcontrolname='street']")).clear();
			driver.findElement(By.xpath("//*[@formcontrolname='street']")).sendKeys(Street_Edit);Thread.sleep(1000);
			w.UpdateButton();
			E_Signature1("Password");
		}}}