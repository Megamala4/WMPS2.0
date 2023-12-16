package Transactions_Positive;

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


public class TC_01_Purchase_Order_Entry extends BaseClass
{

	@org.testng.annotations.Test
	public static void Purchase_Order_Entry() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 						
			String PurchaseOrder_Number =xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_Number", i);//Unique
			
			String DateToday =xls.getCellData("Date", "DateToday", i);//Today
			
			String Vendor_Name_Supplier =xls.getCellData("Excel_Data", "Vendor_Name_Supplier", i);//Mapping
			String MaterialMasterRM =xls.getCellData("Excel_Data", "MaterialMasterRM", i);
			String Vendor_Name_Manufacturer =xls.getCellData("Excel_Data", "Vendor_Name_Manufacturer", i);//Mapping
			
			String Requested_Quantity =xls.getCellData("PurchaseOrderEntry", "Requested_Quantity", i);
			String RequestUOM =xls.getCellData("PurchaseOrderEntry", "RequestUOM", i);
			String Received_Quantity =xls.getCellData("PurchaseOrderEntry", "Received_Quantity", i);
			String ReceivedUOM =xls.getCellData("PurchaseOrderEntry", "RequestUOM", i);		
			String Remarks =xls.getCellData("PurchaseOrderEntry", "Remarks", i);


			WMPS_Login("441111","Password");
			w.Purchase_Order();
			w.Purchase_Order_Entry();
			//w.Entry_Button();	
			w.Type_Button_2();
			w.PurchaseOrderNumber.sendKeys(PurchaseOrder_Number);Thread.sleep(2000);
			//w.Remarks(Material_Description);
			WebElement textbox = driver.findElement(By.xpath("//*[@formcontrolname='purchaseOrderDate']"));Thread.sleep(2000);
			textbox.click();Thread.sleep(2000);
			try {
				textbox.sendKeys(DateToday);Thread.sleep(2000);
			} catch (InterruptedException e1)
			{
				e1.printStackTrace();
			}
			WebElement VendorSupplier = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[1]"));
			try {
				VendorSupplier.sendKeys(Vendor_Name_Supplier);Thread.sleep(2000);
				VendorSupplier.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//			w.TT_4(Material_Description);
			//			w.TT_5(Vendor_Name_Manufacturer);
			WebElement MaterialDescription = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[2]"));
			MaterialDescription.sendKeys(MaterialMasterRM);Thread.sleep(2000);w.DropDown1Select();
			MaterialDescription.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);

			WebElement Manufacturer = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[3]"));
			Manufacturer.sendKeys(Vendor_Name_Manufacturer);Thread.sleep(2000);
			Manufacturer.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);
			w.RequestQuantity(Requested_Quantity);
			Select RequestUom = new Select (driver.findElement(By.xpath("//*[@formcontrolname='requestUOMId']")));
			//RequestUom.selectByVisibleText(RequestUOM);Thread.sleep(2000);
			RequestUom.selectByIndex(1);
			w.ReceivedQuantity(Received_Quantity);

			Select ReceivedUom = new Select (driver.findElement(By.xpath("//select[@formcontrolname='uomId']")));
			ReceivedUom.selectByIndex(1); 
			//uom2.selectByVisibleText(UOM);Thread.sleep(2000);

			scrollPagedown();
//			AttachFile();
//			UploadFile("C:\\Users\\rahul.a\\TestFiles\\02");


			Thread.sleep(2000);
			//						scrollPagedown();	
			//						w.Eye_FF_01();
			//						Thread.sleep(1000);
			//						Close_Opened_File();


			w.Remarks(Remarks);
			driver.findElement(By.id("Purchse-entry-add")).click();Thread.sleep(2000); //add


			w.Submit();Thread.sleep(2000);w.Yes();						
			w.Password_Fill("321");
		//	w.SubmitType_1();w.Ok();driver.close();	


		}}}
