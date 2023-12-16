package com.transaction.negative.test;

import org.openqa.selenium.By;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_07_Good_Recipt_With_PO_ReInitiate extends BaseClass
{

	@org.testng.annotations.Test
	public static void Good_Recipt_With_PO() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 			
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);


			WMPS_Login("441111","Password");
			w.Menu_Navigate();
			w.Transactions();
			w.WareHouse();
			w.Goods_Receipt();
			w.Menu_Navigate();	
			w.SearchBox(Material_Description);
			w.Edit_Action_Button();	
			driver.findElement(By.xpath("//input[@formcontrolname='noofContainers']")).sendKeys("3");Thread.sleep(2000);			
			driver.findElement(By.xpath("(//input[@type='text'])[13]")).sendKeys("Good_Recipt_With_PO_ReInitiate");Thread.sleep(2000);				driver.findElement(By.xpath("//*[contains(text(),' Proceed ')]")).click();Thread.sleep(2000);	
			E_Signature_Masters("Password");		
		}}}
