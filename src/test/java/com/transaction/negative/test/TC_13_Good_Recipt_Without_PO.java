package com.transaction.negative.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_13_Good_Recipt_Without_PO extends BaseClass
{

	@org.testng.annotations.Test
	public static void Good_Recipt_Without_PO() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);


		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 			
			String No_of_Container =xls.getCellData("Goods_ReceiptWith_WithOut", "No_of_Container", i);
			String delivery_challan_No =xls.getCellData("Goods_ReceiptWith_WithOut", "delivery_challan_No", i);
			String Manufacturing_Date =xls.getCellData("Goods_ReceiptWith_WithOut", "Manufacturing_Date", i);
			String Vendor_Retest =xls.getCellData("Goods_ReceiptWith_WithOut", "Vendor_Retest", i);
			String Expiry_Date =xls.getCellData("Goods_ReceiptWith_WithOut", "Expiry_Date", i);
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
			Select gr=new Select(driver.findElement(By.xpath("//*[@class='form-control']")));
			gr.selectByVisibleText("Other Goods Receipt");Thread.sleep(2000);		
			Select InwardType=new Select(driver.findElement(By.xpath("//select[@formcontrolname='InwardType']")));
			InwardType.selectByIndex(2);Thread.sleep(2000);			
			Select MaterialType=new Select(driver.findElement(By.xpath("//select[@formcontrolname='materialType']")));
			MaterialType.selectByIndex(2);Thread.sleep(2000);
			WebElement MaterialDescription = driver.findElement(By.xpath("(//input[@type='text'])[1]"));
			MaterialDescription.sendKeys(Material_Description);Thread.sleep(2000);
			MaterialDescription.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);
			WebElement VendorBatchNumber = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
			VendorBatchNumber.sendKeys(PurchaseOrder_Number);Thread.sleep(4000);						
			WebElement ManufactureName = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
			ManufactureName.sendKeys(Vendor_Name_Manufacturer);Thread.sleep(4000);
			ManufactureName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);						
			WebElement SupplierName = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
			SupplierName.sendKeys(Vendor_Name_Supplier);Thread.sleep(4000);
			SupplierName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);
			Select StorageLocation=new Select(driver.findElement(By.xpath("//select[@formcontrolname='storageLocation']")));
			StorageLocation.selectByIndex(2);Thread.sleep(2000);			
			driver.findElement(By.xpath("//input[@formcontrolname='receivedQuantity']")).sendKeys("1000");Thread.sleep(2000);
			Select RequestUom = new Select (driver.findElement(By.xpath("//*[@formcontrolname='uom']")));
			RequestUom.selectByIndex(2);
			driver.findElement(By.xpath("//input[@formcontrolname='noofContainers']")).sendKeys(No_of_Container);Thread.sleep(2000);		
			Select mdformat=new Select(driver.findElement(By.xpath("//*[@formcontrolname='mfgDateFormat']")));Thread.sleep(2000);
			mdformat.selectByIndex(2);						
			driver.findElement(By.xpath("//input[@formcontrolname='manufactureDate']")).sendKeys(Manufacturing_Date);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='retestDate']")).sendKeys(Vendor_Retest);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='expiryDate']")).sendKeys(Expiry_Date);Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='dcDate']")).sendKeys(Manufacturing_Date);Thread.sleep(2000);			
			driver.findElement(By.xpath("//input[@formcontrolname='challanNumber']")).sendKeys(delivery_challan_No);Thread.sleep(2000);			
			Select condition=new Select(driver.findElement(By.xpath("//*[@formcontrolname='storageCondition']")));
			condition.selectByIndex(2);Thread.sleep(2000);			
			w.Radio_Button_1();w.Split_Button();w.Plus_Button_FFPC();
			driver.findElement(By.xpath("(//*[@type='number'])[4]")).sendKeys("800");Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@type='text'])[14]")).sendKeys("5");Thread.sleep(2000);
			//driver.findElement(By.xpath("(//*[@type='text'])[15]")).sendKeys("5");Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@type='text'])[16]")).sendKeys("CF-001");Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[@type='date'])[8]")).click();Thread.sleep(2000);Thread.sleep(2000);Thread.sleep(2000);
			Thread.sleep(2000);Thread.sleep(2000);Thread.sleep(5000);Thread.sleep(3000);
			w.Proceed_Button();
		//	w.Yes();w.Password_Fill("321");w.TYPE_SUBMIT();w.OK_BUTTON();
			}}}
			