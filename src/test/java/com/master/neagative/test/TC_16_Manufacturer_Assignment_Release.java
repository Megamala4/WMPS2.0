package com.master.neagative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_16_Manufacturer_Assignment_Release extends BaseClass
{

	@org.testng.annotations.Test
	public static void Manufacturer_Assignment() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Vendor_name =xls.getCellData("Excel_Data", "Vendor_name_Manufacturer", i);

			WMPS_Login("441122","Password");
			w.Menu_Navigate();w.Second_Level();w.Menu_Navigate();
			Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@formcontrolname='Category']")));
			Review_Approval_Category.selectByIndex(4);Thread.sleep(2000);
			w.Search_Button();w.SearchBox(Vendor_name);w.Edit_Action_Button();			
			w.Comments("Manufacturer_Assignment_Release");Thread.sleep(2000);			
			Select Action_Level_Select=new Select(driver.findElement(By.xpath("//*[@formcontrolname='status']")));
			Action_Level_Select.selectByIndex(1);Thread.sleep(2000);
			w.Submit();Thread.sleep(2000);
		//	w.Yes();w.Password_Fill("321");w.TYPE_SUBMIT2();w.OK_BUTTON();
		}}}
