package Transactions_Positive;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class TC_04_Quality_Inspection2_SkipSampling extends BaseClass
{

	@org.testng.annotations.Test
	public static void Ordertypr() throws Exception
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


String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

			String BatchNoFromGoodRecipt =xls.getCellData("VVI", "BatchNoFromGoodRecipt", i);
			String delivery_challan_No =xls.getCellData("Goods_ReceiptWith_WithOut", "delivery_challan_No", i);
			String manufacturing_date =xls.getCellData("Goods_ReceiptWith_WithOut", "manufacturing_date", i);
			String vendor_Retest =xls.getCellData("Goods_ReceiptWith_WithOut", "vendor_Retest", i);
			String Vendor_name_Manufacturer =xls.getCellData("Vendor_Supplier", "Vendor_name_Manufacturer", i);
			String Vendor_name_Supplier =xls.getCellData("Vendor_Supplier", "Vendor_name_Supplier", i);
			String Material_Description =xls.getCellData("Material_Master", "Material_Description", i);
			String PurchaseOrder_number =xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_number", i);//Purchase Order Entry
//Data_Mapping			
			
			

			

			WMPS_Login("441111","Password");
			
			driver.findElement(By.xpath("//a[@id='menuNavigate']")).click();Thread.sleep(2000); 
			driver.findElement(By.xpath("//*[contains(text(),' Transactions ')]")).click();Thread.sleep(2000);
			driver.findElement(By.xpath("(//*[contains(text(),' Quality-Control')])")).click();Thread.sleep(2000); //warehouse
			driver.findElement(By.xpath("(//*[contains(text(),'Quality Inspection ')])")).click();Thread.sleep(2000); //GoodsReceipt
			driver.findElement(By.xpath("//*[@id='menuNavigate']")).click();Thread.sleep(2000); //right align
			
			w.SearchBox(BatchNoFromGoodRecipt);
			driver.findElement(By.xpath("(//*[@actiontype=\"editAction\"])[2]")).click();Thread.sleep(2000);//************************************
 
			Select Pharmacopoeia=new Select(driver.findElement(By.xpath("//select[@formcontrolname='pharmacopoeiaId']")));
			Pharmacopoeia.selectByIndex(2);Thread.sleep(2000);

			
			driver.findElement(By.xpath("//input[@formcontrolname='ARNumber']")).sendKeys(BatchNoFromGoodRecipt);Thread.sleep(2000);
			
			w.CheckBox_1();
			
//			Select Action=new Select(driver.findElement(By.xpath("//select[@formcontrolname='AnalysisStatus']")));
//			Action.selectByIndex(2);Thread.sleep(2000);
//
//	
//
//			driver.findElement(By.xpath("//input[@formcontrolname='SampledQuantity']")).sendKeys("500");Thread.sleep(2000);
//			
//			Select ReceivedUom = new Select (driver.findElement(By.xpath("//select[@formcontrolname='SampledQuantityUOM']")));
//			ReceivedUom.selectByIndex(1);
			
			w.Comments("Quality_Inspection_Passed");
			
	
		w.Submit();
		//E_Signature_Masters("Password");
			
			
		}}}
			