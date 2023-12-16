package com.transaction.negative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_17_Quality_Inspection_1 extends BaseClass
{

	@org.testng.annotations.Test
	public static void Quality_Inspection() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
//Data_Mapping			
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);
			String VendorBatch_Number =xls.getCellData("Negative_Transaction", "VendorBatch_Number", i);			

			WMPS_Login("441111","Password");
			w.Menu_Navigate();
			w.Transactions();
			w.Quality_Control();
			w.Quality_Inspection();
			w.Menu_Navigate();			
			w.SearchBox(Material_Description);
			w.ActionType_EditAction_Button2();
			Select Pharmacopoeia=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pharmacopoeiaId']")));
			Pharmacopoeia.selectByIndex(2);Thread.sleep(2000);			
			driver.findElement(By.xpath("//input[@formcontrolname='ARNumber']")).sendKeys(VendorBatch_Number);Thread.sleep(2000);			
			Select Action=new Select(driver.findElement(By.xpath("//select[@formcontrolname='AnalysisStatus']")));
			Action.selectByIndex(2);Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@formcontrolname='SampledQuantity']")).clear();
			driver.findElement(By.xpath("//input[@formcontrolname='SampledQuantity']")).sendKeys("10");Thread.sleep(2000);	//less thn batch Quantity		
			Select ReceivedUom = new Select (driver.findElement(By.xpath("//select[@formcontrolname='SampledQuantityUOM']")));
			ReceivedUom.selectByIndex(1);			
			w.Comments("Quality_Inspection_Passed");
			w.Submit();
			E_Signature_Masters("Password");
			}}}
			