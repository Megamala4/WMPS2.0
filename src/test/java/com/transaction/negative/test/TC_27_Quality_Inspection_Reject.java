package com.transaction.negative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_27_Quality_Inspection_Reject extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=rowcount;i++)
		{ 			
			String Batch_Number =xls.getCellData("Changable_Data", "Batch_Number", i);

			WMPS_Login("441122","Password");			
			w.Menu_Navigate();w.Second_Level();w.Menu_Navigate();						
			Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@formcontrolname='Category']")));
			Review_Approval_Category.selectByIndex(23);Thread.sleep(2000);			
			w.Search_Button();Thread.sleep(2000);
			w.SearchBox(Batch_Number);Thread.sleep(2000);
			w.ActionType_EditAction_Button();Thread.sleep(2000);
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
//			w.OK_BUTTON();w.ActionType_EditAction_Button();
			w.ActionType_EditAction_Button();
		}}}
