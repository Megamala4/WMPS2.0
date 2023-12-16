package com.transaction.negative.test;

import org.openqa.selenium.By;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_19_Material_Inventory_1 extends BaseClass
{

	@org.testng.annotations.Test
	public static void Material_Inventory_1() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		WMPS_Login("441111","Password");

		w.Menu_Navigate();
		w.Transactions();
		w.WareHouse();
		w.Material_Inventory();
		w.Menu_Navigate();

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);

			scrollPagedown();
			w.SearchBox(Material_Description);
			driver.findElement(By.xpath("(//*[@class='my_class1'])[1]")).click();Thread.sleep(2000);	
			w.Inventory_Card();
		}}}
