package com.transaction.negative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_06_Good_Recipt_With_PO_Return extends BaseClass
{

	@org.testng.annotations.Test
	public static void Good_Recipt_With_PO_Return() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);

			WMPS_Login("441122","Password");
			w.Menu_Navigate();
			w.Second_Level();
			Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@formcontrolname='Category']")));
			Review_Approval_Category.selectByIndex(9);Thread.sleep(2000);			
			w.Search_Button();
			w.SearchBox(Material_Description);
			w.Edit_Action_Button();			
		    w.Comments("Good_Recipt_With_PO_Return");Thread.sleep(2000);
			Select Action_Level_Select=new Select(driver.findElement(By.xpath("//*[@formcontrolname='status']")));
			Action_Level_Select.selectByIndex(2);Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[contains(.,' Save ')])[2]")).click();Thread.sleep(3000);			
			Save("Password");
		}}}
