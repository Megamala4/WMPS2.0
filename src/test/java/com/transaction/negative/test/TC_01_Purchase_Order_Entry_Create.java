package com.transaction.negative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_01_Purchase_Order_Entry_Create extends BaseClass
{

	@org.testng.annotations.Test
	public static void Purchase_Order_Entry_Create() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			String Requested_Quantity =xls.getCellData("PurchaseOrderEntry", "Requested_Quantity", i);
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
			w.Entry_Button();
			driver.findElement(By.xpath("//*[@formcontrolname='purchaseOrderNumber']")).sendKeys(PurchaseOrder_Number);Thread.sleep(2000);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='purchaseOrderDate']")).click();Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='purchaseOrderDate']")).sendKeys(Current_Date);Thread.sleep(2000);
			WebElement VendorSupplier = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[1]"));
			VendorSupplier.sendKeys(Vendor_Name_Supplier);Thread.sleep(2000);w.DropDown1Select();
			WebElement MaterialDescription = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[2]"));
			MaterialDescription.sendKeys(Material_Description);Thread.sleep(2000);w.DropDown1Select();
			WebElement Manufacturer = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[3]"));
			Manufacturer.sendKeys(Vendor_Name_Manufacturer);Thread.sleep(2000);
			Manufacturer.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='requestQuantity']")).sendKeys(Requested_Quantity);Thread.sleep(2000);
			Select RequestUom = new Select (driver.findElement(By.xpath("//*[@formcontrolname='requestUOMId']")));
			//RequestUom.selectByVisibleText(RequestUOM);Thread.sleep(2000);
			RequestUom.selectByIndex(2);
			driver.findElement(By.xpath("//*[@formcontrolname='receivedQuantity']")).sendKeys(Received_Quantity);Thread.sleep(2000);
			Select ReceivedUom = new Select (driver.findElement(By.xpath("//select[@formcontrolname='uomId']")));
			ReceivedUom.selectByIndex(2);
			//uom2.selectByVisibleText(UOM);Thread.sleep(2000);
			w.Remarks(Remarks);
			driver.findElement(By.id("Purchse-entry-add")).click();Thread.sleep(2000); //add
			w.Submit();Thread.sleep(2000);
			E_Signature_Masters("Password");			
		}}}
