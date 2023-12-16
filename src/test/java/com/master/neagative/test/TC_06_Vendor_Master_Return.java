package com.master.neagative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_06_Vendor_Master_Return extends BaseClass
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

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=3; i<=rowcount;i++)
		{ 
			String Vendor_name =xls.getCellData("Excel_Data", "Vendor_name_Manufacturer", i);

			WMPS_Login("441122","Password");                              
			w.Menu_Navigate();
			w.Second_Level();
			w.Menu_Navigate();			
			Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@formcontrolname='Category']")));
			Review_Approval_Category.selectByIndex(3);Thread.sleep(2000);
			w.Search_Button();
			w.SearchBox(Vendor_name);
			w.Edit_Action_Button();			
			w.Comments("Vendor_Master_Return");Thread.sleep(2000);			
			Select Action_Level_Select=new Select(driver.findElement(By.xpath("//*[@formcontrolname='status']")));
			Action_Level_Select.selectByIndex(2);Thread.sleep(2000);
			w.Submit();Thread.sleep(2000);
			//w.Yes();w.Password_Fill("321");w.TYPE_SUBMIT2();
			w.Ok();
		}}}
