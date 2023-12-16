package com.master.neagative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_04_Material_Master_Release extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);//*************************8

			WMPS_Login("441122","Password");			
			w.Menu_Navigate();
			w.Second_Level();
			w.Menu_Navigate();			
			Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@formcontrolname='Category']")));
			Review_Approval_Category.selectByIndex(2);Thread.sleep(2000);			
			w.Search_Button();			
			w.SearchBox(Material_Description);
			w.Edit_Action_Button();		
			w.Comments("Material_Master_Release");Thread.sleep(2000);			
			Select Action_Level_Select=new Select(driver.findElement(By.xpath("//*[@formcontrolname='approverAction']")));
			Action_Level_Select.selectByIndex(1);Thread.sleep(2000);//Release
			w.Submit();Thread.sleep(2000);
			E_Signature1("Password");
		}}}
