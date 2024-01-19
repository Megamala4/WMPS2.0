package T1_Transactions_Positive;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;

public class TC_02_Good_Recipt_With_PO_Split_1_Containter extends BaseClass {

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);
		// ***************************************************************************************************************
		WMPS_Login("Initiator", "Initiator_Password");
		w.WareHouse();
		w.Goods_Receipt();
		Thread.sleep(500);
		// ***************************************************************************************************************
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {

			String po_date = xls.getCellData("PurchaseOrderEntry", "po_date", i);
			String supplier = xls.getCellData("Manufacturer_Assignment", "Name_Of_Supplier", i);
			String material_Description = xls.getCellData("Manufacturer_Assignment", "Material_Name", i);
			String Manufaturer = xls.getCellData("Manufacturer_Assignment", "Manufacturer_name", i);
			String Requested_Quantity = xls.getCellData("PurchaseOrderEntry", "Requested_Quantity", i);
			String Received_Quantity = xls.getCellData("PurchaseOrderEntry", "Received_Quantity", i);
			String UOM = xls.getCellData("PurchaseOrderEntry", "UOM", i);
			String remarks = xls.getCellData("PurchaseOrderEntry", "remarks", i);
			String nu_of_container = xls.getCellData("Goods_ReceiptWith_WithOut", "no_of_container", i);
			String delivery_challan_No = xls.getCellData("Goods_ReceiptWith_WithOut", "delivery_challan_No", i);
			String manufacturing_date = xls.getCellData("Goods_ReceiptWith_WithOut", "manufacturing_date", i);
			String vendor_Retest = xls.getCellData("Goods_ReceiptWith_WithOut", "vendor_Retest", i);

			// ***************************************************************************************************************
			// Data_Mapping from Purchase Order Entry
			String PurchaseOrder_Number = xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_Number", i);
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			// Data_Mapping
			String Vendor_Name_Manufacturer = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);
			String Vendor_Name_Supplier = xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);
			String Material_Description = xls.getCellData("Excel_Data", "Material_Description", i);
			
			String Material_Description_Edit = xls.getCellData("Excel_Data", "Material_Description", i);
			String Vendor_Name_Manufacturer_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer_Edit", i);
			String Vendor_Name_Supplier_Edit = xls.getCellData("Excel_Data", "Vendor_Name_Supplier_Edit", i);
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			String Today_Date = xls.getCellData("Changable_Data", "Today_Date", i);
			String OneMonthLater = xls.getCellData("Changable_Data", "OneMonthLater", i);
			String OneYearLater = xls.getCellData("Changable_Data", "OneYearLater", i);
			String Past_Date = xls.getCellData("Changable_Data", "Past_Date", i);
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			String Date1MB = xls.getCellData("Date", "Date1MB", i);
			String DateToday = xls.getCellData("Date", "DateToday", i);
			String Date1ML = xls.getCellData("Date", "Date1ML", i);
			String Date2ML = xls.getCellData("Date", "Date2ML", i);
			String Date6ML = xls.getCellData("Date", "Date6ML", i);
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ***************************************************************************************************************
			Thread.sleep(1000);
			w.Menu_Navigate();
			Thread.sleep(1000);
			w.Create();
			Thread.sleep(2000);
			Select GoodsReceipt = new Select(driver.findElement(By.xpath("//*[@class='form-control']")));
			GoodsReceipt.selectByVisibleText("Goods Receipt With PO");
			Thread.sleep(2000);
			w.PO_Number(PurchaseOrder_Number);
			// driver.findElement(By.xpath("//input[@formcontrolname='PONumber']")).sendKeys(PurchaseOrder_Number);Thread.sleep(2000);
			// driver.findElement(By.xpath("//input[@formcontrolname='PONumber']")).sendKeys("877877678");Thread.sleep(2000);
			w.Get_Button();

			Select InwardType = new Select(driver.findElement(By.xpath("//select[@formcontrolname='InwardType']")));
			InwardType.selectByIndex(2);
			Thread.sleep(2000);

			Select MaterialType = new Select(driver.findElement(By.xpath("//select[@formcontrolname='materialType']")));
			MaterialType.selectByIndex(2);
			Thread.sleep(2000);

			WebElement MaterialDescription = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
			MaterialDescription.sendKeys(Material_Description);
			Thread.sleep(2000);
			MaterialDescription.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(2000);

			WebElement VendorBatchNumber = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
			VendorBatchNumber.sendKeys("8596855");
			Thread.sleep(4000);

			WebElement ManufactureName = driver.findElement(By.xpath("(//input[@type='text'])[6]"));
			ManufactureName.sendKeys(Vendor_Name_Manufacturer_Edit);
			Thread.sleep(4000);
			ManufactureName.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(2000);

			WebElement SupplierName = driver.findElement(By.xpath("(//input[@type='text'])[7]"));
			SupplierName.sendKeys(Vendor_Name_Supplier_Edit);
			Thread.sleep(4000);
			SupplierName.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
			Thread.sleep(2000);

			Select StorageLocation = new Select(
					driver.findElement(By.xpath("//select[@formcontrolname='storageLocation']")));
			StorageLocation.selectByIndex(2);
			Thread.sleep(2000);

			// ***************************************************************************************************************
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			driver.findElement(By.xpath("//input[@formcontrolname='noofContainers']")).sendKeys("1");
			Thread.sleep(2000);
			// Depends on how much Batch Number u have to split
			// If we are giving Noc=3 its means [1] it will create 3 Batch number [2]the
			// received PO Quantity will be divided into
			// 3parts but for that we have to click on Add button and divide the quantity
			// according to our convenience

			// ***************************************************************************************************************
			// ***************************************************************************************************************
			// ***************************************************************************************************************
			Select mdformat = new Select(driver.findElement(By.xpath("//*[@formcontrolname='mfgDateFormat']")));
			Thread.sleep(2000);
			mdformat.selectByIndex(2);

			// **************************************
			driver.findElement(By.xpath("//input[@formcontrolname='manufactureDate']")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@formcontrolname='manufactureDate']")).sendKeys(DateToday);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='retestDate']")).sendKeys(Date1ML);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
//			driver.findElement(By.xpath("//*[@formcontrolname='expiryDate']")).sendKeys(Date6ML);Thread.sleep(2000);//NotRequired
//			Thread.sleep(2000);Thread.sleep(2000);Thread.sleep(2000);
			// *************************************
			driver.findElement(By.xpath("//*[@formcontrolname='dcDate']")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@formcontrolname='dcDate']")).sendKeys(DateToday);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@formcontrolname='challanNumber']")).sendKeys(delivery_challan_No);
			Thread.sleep(2000);

			Select condition = new Select(driver.findElement(By.xpath("//*[@formcontrolname='storageCondition']")));
			condition.selectByIndex(2);
			Thread.sleep(2000);

			try {
				p.CB_1();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Thread.sleep(2000);
			w.Split_Button();

			// ******************************************************************************************************************
			// w.Plus_Button_FFPC();
			// w.Plus_Button_FFPC();
			//
			// w.TT_18_CSE("2000");
			// w.TT_19_CSE("1");
			//
			// w.TT_22_CSE("3000");
			// w.TT_23_CSE("1");
			//
			// driver.findElement(By.xpath("(//*[@type='date'])[8]")).sendKeys(DateToday);Thread.sleep(2000);//Manufacturing
			// Date
			// driver.findElement(By.xpath("(//*[@type='date'])[9]")).sendKeys(OneMonthLater);Thread.sleep(2000);//Vendor
			// Retest Date
			// driver.findElement(By.xpath("(//*[@type='date'])[10]")).sendKeys(OneYearLater);Thread.sleep(2000);//Vendor
			// Expiry Date
			//
			// driver.findElement(By.xpath("(//*[@type='date'])[11]")).sendKeys(DateToday);Thread.sleep(2000);//Manufacturing
			// Date
			// driver.findElement(By.xpath("(//*[@type='date'])[12]")).sendKeys(OneMonthLater);Thread.sleep(2000);//Vendor
			// Retest Date
			// driver.findElement(By.xpath("(//*[@type='date'])[13]")).sendKeys(OneYearLater);Thread.sleep(2000);//Vendor
			// Expiry Date

			// ******************************************************************************************************************
			Thread.sleep(2000);
			w.Proceed_Button();
			w.Yes();
			w.Password_Fill.sendKeys(Pro.getProperty("Initiator_Password"));
			w.SubmitType_1();
			w.Ok();
			// driver.close();

		}
	}
}
