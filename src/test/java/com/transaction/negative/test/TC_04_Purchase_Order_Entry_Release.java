package com.transaction.negative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_04_Purchase_Order_Entry_Release extends BaseClass
{

	@org.testng.annotations.Test
	public static void Purchase_Order_Entry_Return() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 			
			String PurchaseOrder_Number =xls.getCellData("Negative_Transaction", "PurchaseOrder_Number", i);
			WMPS_Login("441122","Password");
			w.Menu_Navigate();
			w.Second_Level();						
			Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@formcontrolname='Category']")));
			Review_Approval_Category.selectByIndex(8);Thread.sleep(2000);
			w.Search_Button();
			w.SearchBox(PurchaseOrder_Number);
			w.Edit_Action_Button();
			w.Comments("Purchase_Order_Entry_Release");Thread.sleep(2000);			
			Select Action_Level_Select=new Select(driver.findElement(By.xpath("//*[@formcontrolname='status']")));
			Action_Level_Select.selectByIndex(1);//Release
			Thread.sleep(2000);
			w.Submit();Thread.sleep(2000);			
			Save("Password");
		}}}
