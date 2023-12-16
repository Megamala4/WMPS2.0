package com.transaction.negative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_05_Good_Recipt_With_PO extends BaseClass
{

	@org.testng.annotations.Test
	public static void Good_Recipt_With_PO() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 			
			String nu_of_container =xls.getCellData("Goods_ReceiptWith_WithOut", "no_of_container", i);
			String delivery_challan_No =xls.getCellData("Goods_ReceiptWith_WithOut", "delivery_challan_No", i);
			String manufacturing_date =xls.getCellData("Goods_ReceiptWith_WithOut", "manufacturing_date", i);
			String vendor_Retest =xls.getCellData("Goods_ReceiptWith_WithOut", "vendor_Retest", i);
			
			//NEW_data
			String VendorBatch_Number =xls.getCellData("Negative_Transaction", "VendorBatch_Number", i);			

			//Data_Mapping	
			String PurchaseOrder_Number =xls.getCellData("Negative_Transaction", "PurchaseOrder_Number", i);
			String Vendor_Name_Manufacturer =xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier =xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			String Material_Description =xls.getCellData("Excel_Data", "Material_Description", i);
			
			WMPS_Login("441111","Password");
			w.Menu_Navigate();
			w.Transactions();
			w.WareHouse();
			w.Goods_Receipt();
			w.Menu_Navigate();
			w.Create();Thread.sleep(2000);				
			Select GoodsReceipt=new Select(driver.findElement(By.xpath("//*[@class='form-control']")));
			GoodsReceipt.selectByVisibleText("Goods Receipt With PO");Thread.sleep(2000);			
			driver.findElement(By.xpath("//input[@formcontrolname='PONumber']")).sendKeys(PurchaseOrder_Number);Thread.sleep(2000);			
			w.Get_Button();
			Select InwardType=new Select(driver.findElement(By.xpath("//select[@formcontrolname='InwardType']")));
			InwardType.selectByIndex(2);Thread.sleep(2000);			
			Select MaterialType=new Select(driver.findElement(By.xpath("//select[@formcontrolname='materialType']")));
			MaterialType.selectByIndex(2);Thread.sleep(2000);
			WebElement MaterialDescription = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
			MaterialDescription.sendKeys(Material_Description);Thread.sleep(2000);
			MaterialDescription.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);
			WebElement VendorBatchNumber = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
			VendorBatchNumber.sendKeys(VendorBatch_Number);Thread.sleep(4000);						
			WebElement ManufactureName = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
			ManufactureName.sendKeys(Vendor_Name_Manufacturer);Thread.sleep(4000);
			ManufactureName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);			
			WebElement SupplierName = driver.findElement(By.xpath("(//input[@type='text'])[7]"));
			SupplierName.sendKeys(Vendor_Name_Supplier);Thread.sleep(4000);
			SupplierName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);
			Select StorageLocation=new Select(driver.findElement(By.xpath("//select[@formcontrolname='storageLocation']")));
			StorageLocation.selectByIndex(2);Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@formcontrolname='noofContainers']")).sendKeys("2");Thread.sleep(2000);			
			Select mdformat=new Select(driver.findElement(By.xpath("//*[@formcontrolname='mfgDateFormat']")));Thread.sleep(2000);
			mdformat.selectByIndex(2);
			driver.findElement(By.xpath("//input[@formcontrolname='manufactureDate']")).sendKeys(manufacturing_date);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='retestDate']")).sendKeys(vendor_Retest);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='expiryDate']")).sendKeys(vendor_Retest);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='dcDate']")).sendKeys(manufacturing_date);Thread.sleep(2000);			
			driver.findElement(By.xpath("//input[@formcontrolname='challanNumber']")).sendKeys(delivery_challan_No);Thread.sleep(2000);			
			Select condition=new Select(driver.findElement(By.xpath("//*[@formcontrolname='storageCondition']")));
			condition.selectByIndex(2);Thread.sleep(2000);			
			w.Radio_Button_1();
			driver.findElement(By.xpath("//*[contains(text(),' Proceed ')]")).click();Thread.sleep(2000);	
			E_Signature_Masters("Password");		
		}}}
			