package com.transaction.negative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_10_Quality_Inspection_Reject extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=3; i<=rowcount;i++)
		{ 			
			String BatchNoFromGoodRecipt =xls.getCellData("VVI", "BatchNoFromGoodRecipt", i);
			
			WMPS_Login("441122","Password");			
			w.Menu_Navigate();w.Second_Level();w.Menu_Navigate();						
			Select Review_Approval_Category=new Select(driver.findElement(By.xpath("//*[@formcontrolname='Category']")));
			Review_Approval_Category.selectByIndex(23);Thread.sleep(2000);			
			w.Search_Button();
			w.SearchBox(BatchNoFromGoodRecipt);
			driver.findElement(By.xpath("(//*[@actiontype='editAction'])[1]")).click();Thread.sleep(2000);			
			Select Action_Level_Select=new Select(driver.findElement(By.xpath("//*[@formcontrolname='AnalysisStatus']")));
			Action_Level_Select.selectByIndex(2);Thread.sleep(2000);			
			w.Comments("Quality_Inspection_Release");Thread.sleep(2000);
			w.Submit();Thread.sleep(2000);
		//	w.Yes();w.Password_Fill("321");w.TYPE_SUBMIT2();w.OK_BUTTON();
}}}
