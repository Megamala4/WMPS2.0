package com.master.neagative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_20_Supplier_Assignment_Release extends BaseClass
{

	@org.testng.annotations.Test
	public static void Supplier_Assignment_Release() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=3; i<=rowcount;i++)
		{ 			
			String Name_of_the_Supplier =xls.getCellData("Excel_Data", "Vendor_name_Supplier", i);
			WMPS_Login("441122","Password");
			w.Menu_Navigate();w.Second_Level();w.Menu_Navigate();						
			Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@formcontrolname='Category']")));
			Review_Approval_Category.selectByIndex(5);Thread.sleep(2000);
			w.Search_Button();
			w.SearchBox(Name_of_the_Supplier);
			w.Edit_Action_Button();	
			w.Comments("Supplier_Assignment_Release");Thread.sleep(2000);			
			Select Action_Level_Select=new Select(driver.findElement(By.xpath("//*[@formcontrolname='status']")));
			Action_Level_Select.selectByIndex(1);Thread.sleep(2000);
			w.Submit();Thread.sleep(2000);
		//S	w.Yes();w.Password_Fill("321");w.TYPE_SUBMIT2();w.OK_BUTTON();
}}}
