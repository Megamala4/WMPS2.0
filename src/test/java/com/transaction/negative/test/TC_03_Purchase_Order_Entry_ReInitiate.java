package com.transaction.negative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_03_Purchase_Order_Entry_ReInitiate extends BaseClass
{

	@org.testng.annotations.Test
	public static void Purchase_Order_Entry_ReInitiate() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Requested_Quantity =xls.getCellData("PurchaseOrderEntry", "Requested_Quantity_E", i);
			String Received_Quantity =xls.getCellData("PurchaseOrderEntry", "Received_Quantity", i);
			String Remarks =xls.getCellData("PurchaseOrderEntry", "Remarks", i);
			
			//Changable_Data
			String PurchaseOrder_Number =xls.getCellData("Negative_Transaction", "PurchaseOrder_Number", i);
			String Current_Date =xls.getCellData("Negative_Transaction", "Current_Date", i);

			//Data_Mapping			
			String Vendor_Name_Manufacturer =xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier =xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);

			WMPS_Login("441111","Password");
			w.Menu_Navigate();
			w.Transactions();
			w.Purchase_Order();
			w.Purchase_Order_Entry();
			w.SearchBox(PurchaseOrder_Number);
			w.Edit_Action_Button();
			driver.findElement(By.xpath("//*[@formcontrolname='requestQuantity']")).clear();
			driver.findElement(By.xpath("//*[@formcontrolname='requestQuantity']")).sendKeys(Requested_Quantity);Thread.sleep(2000);
			Select RequestUom = new Select (driver.findElement(By.xpath("//*[@formcontrolname='requestUOMId']")));
			RequestUom.selectByIndex(1);
			w.Remarks("Purchase_Order_Entry_ReInitiate");			
			driver.findElement(By.id("Purchse-entry-add")).click();Thread.sleep(2000);//Add_Button
			w.UpdateButton();Thread.sleep(2000);
			E_Signature_Masters("Password");			
		}}}
