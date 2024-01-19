package T1_Transactions_Positive;

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


public class TC_11_Bill_Of_Material2 extends BaseClass
{

	@org.testng.annotations.Test
	public static void Bill_Of_Material() throws Exception
	{
		WMPS_OBJECT w=new WMPS_OBJECT(driver);
		HomePage hp=new HomePage(driver);
		Common_Xpath cxp=new Common_Xpath(driver);
		PWO_Xpath p=new PWO_Xpath(driver);
		DataFields df=new DataFields(driver);
		Master_Xpaths mp =new Master_Xpaths(driver);



		WMPS_Login("441111","Password");
		w.Menu_Navigate();w.Menu_Navigate();
		w.Production();w.BillOfMaterial();
		w.Create();

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)		
		{
			String MaterialMasterFP =xls.getCellData("Excel_Data", "MaterialMasterFP", i);//Raw Material
			String MaterialMasterSFP=xls.getCellData("Excel_Data", "MaterialMasterSFP", i);	//New Semifinished Middle Part	
			String MaterialMasterRM=xls.getCellData("Excel_Data", "MaterialMasterRM", i);//Lower Material

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

//Always Change			
String BPR_Number_I =xls.getCellData("Bill_Of_Material", "BPR_Number_I", i);


          String Version_NumberRM =xls.getCellData("Bill_Of_Material", "Version_NumberRM", i);
	 	String BPR_Number_II =xls.getCellData("Bill_Of_Material", "BPR_Number_II", i);//Issue

        String VersionNumber_II =xls.getCellData("Dependency", "VersionNumber_II", i);



			String BatchSize =xls.getCellData("Bill_Of_Material", "BatchSize", i);//BOM??Baatch order(static) // create test request



			String Remarks =xls.getCellData("PurchaseOrderEntry", "remarks", i);
			String Number_Of_Lots =xls.getCellData("Bill_Of_Material", "numberLots", i);

			String BPR_Type =xls.getCellData("Bill_Of_Material", "BPR_Type", i);
			String StandardQuantity =xls.getCellData("Bill_Of_Material", "statnderdQuantity", i);
			String High =xls.getCellData("Bill_Of_Material", "High", i);
			String Low =xls.getCellData("Bill_Of_Material", "low", i);
			String material_name =xls.getCellData("Goods_ReceiptWith_WithOut", "material_name", i);

			String BatchNoFromGoodRecipt =xls.getCellData("VVI", "BatchNoFromGoodRecipt", i);
			String delivery_challan_No =xls.getCellData("Goods_ReceiptWith_WithOut", "delivery_challan_No", i);
			String manufacturing_date =xls.getCellData("Goods_ReceiptWith_WithOut", "manufacturing_date", i);
			String vendor_Retest =xls.getCellData("Goods_ReceiptWith_WithOut", "vendor_Retest", i);
			String Vendor_name_Manufacturer =xls.getCellData("Vendor_Supplier", "Vendor_name_Manufacturer", i);
			String Vendor_name_Supplier =xls.getCellData("Vendor_Supplier", "Vendor_name_Supplier", i);
			String PurchaseOrder_number =xls.getCellData("PurchaseOrderEntry", "PurchaseOrder_number", i);//Purchase Order Entry


			WebElement ProductName = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[1]"));
			ProductName.sendKeys(MaterialMasterFP);Thread.sleep(2000);
			ProductName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);

			w.BatchSize("5000");

			Select UOM1= new Select (driver.findElement(By.xpath("//select[@formcontrolname='uomId']")));
			UOM1.selectByIndex(0);
			
			//w.BPR_Number(BPR_NumberII);
			w.BPR_Number(VersionNumber_II);
			w.Version_Number(VersionNumber_II);
			
			w.BPRType(BPR_Type);

//			Select BPRType = new Select (driver.findElement(By.xpath("//*[@formcontrolname='bprTypeId']")));
//			BPRType.selectByVisibleText(BPR_Type);
			//	BPR_Type.selectByIndex(3);Thread.sleep(2000);//Commercial

//********************************************************************************************************************************					
			//If we select VALIDATION REQUEST in Dropdown this dynamic field protocol number will come
			//VALIDATION REQUEST
			try {
				w.Protocol_Number(BPR_Number_I);
			} catch (Exception e) {
				e.printStackTrace();
			}
//********************************************************************************************************************************			
			
			//w.Remarks(BPR_NumberII);
			w.Remarks("VersionNumber_II");

			driver.findElement(By.xpath("//*[@id='BOM-proceed']")).click();Thread.sleep(2000);
			//*************************************************************************************************************************************			



			WebElement MaterialName = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[2]"));
			MaterialName.sendKeys(MaterialMasterSFP);
			driver.findElement(By.xpath("//*[@role=\"option\"]")).click();
			//MaterialName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);


			//Number_Of_Lots
			driver.findElement(By.xpath("(//input[@type='search'])[4]")).sendKeys(Number_Of_Lots);Thread.sleep(2000);
			//StandardQuantity//TT8 if we select Validation Request
			driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys(StandardQuantity);Thread.sleep(2000);
			


			Select UOM11 = new Select (driver.findElement(By.xpath("(/html/body/app-root/div/div/app-bom/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr/td[6]/select)[1]")));
			UOM11.selectByIndex(0);Thread.sleep(2000);

			//driver.findElement(By.xpath("(//*[@type='checkbox'])[1]")).click();Thread.sleep(2000);

			//Add
			driver.findElement(By.xpath("(/html/body/app-root/div/div/app-bom/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr/td[8]/button[1])[1]")).click(); Thread.sleep(2000);		

			

//			w.Type_Search_01(High);
//			w.Type_Search_02(Low);
//			w.Type_Search_04(High);
//			w.Type_Search_03(Low);
			
			//Lots Filling
//w.Type_Number_01(High);		
//w.Type_Number_02(Low);
//w.Type_Number_03(High);
//w.Type_Number_04(Low);


			driver.findElement(By.xpath("(//*[@title='Edit'])[11]")).click();
			Thread.sleep(2000);//add Button
			
			WebElement ProductName1 = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[3]"));
			ProductName1.sendKeys(MaterialMasterRM);Thread.sleep(2000);
			ProductName1.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);
			

			
			//Number_Of_Lots
			driver.findElement(By.xpath("(//input[@type='search'])[6]")).sendKeys(Number_Of_Lots);Thread.sleep(2000);
			//StandardQuantity//TT15 if we select Validation Request
			driver.findElement(By.xpath("(//input[@type='text'])[15]")).sendKeys(StandardQuantity);Thread.sleep(2000);

			Select UOM2 = new Select (driver.findElement(By.xpath("(/html/body/app-root/div/div/app-bom/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr/td[6]/select)[2]")));
			UOM2.selectByIndex(0);Thread.sleep(2000);
			
			driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();Thread.sleep(2000);
			driver.findElement(By.xpath("(/html/body/app-root/div/div/app-bom/div/div[2]/div[2]/div/div[2]/div/div/table/tbody/tr/td[8]/button[1])[2]")).click(); Thread.sleep(2000);		

			
			

			//			driver.findElement(By.xpath("(//input[@type='text'])[12]")).sendKeys(material_name);
			//			Thread.sleep(2000);
			//
			//			driver.findElement(By.xpath("(//div[@role='option'])[1]")).click();
			//			Thread.sleep(2000);

			//			Thread.sleep(2000);
			//			driver.findElement(By.xpath("(//input[@type='search'])[14]")).sendKeys(numberLots);
			////			tp.highrangeSend(Pro1.getProperty("high_range"));
			//			Thread.sleep(2000);
			//			driver.findElement(By.xpath("(//input[@type='search'])[15]")).sendKeys(statnderdQuantity);
			//			Thread.sleep(2000);
			//			
			//			Select uom2 = new Select (driver.findElement(By.xpath("/html/body/app-root/div/div/app-bom/div/div[2]/div/div[2]/div[2]/div/div/table/tbody[2]/tr[1]/td[6]/select")));
			//			uom2.selectByIndex(0);
			//			Thread.sleep(2000);
			//			
			////			driver.findElement(By.xpath("(//*[@type='checkbox'])[2]")).click();
			////		    Thread.sleep(2000);	
			//			
			//	         driver.findElement(By.xpath("(//button[contains(text(),'Add')])[2]")).click();
			//	         Thread.sleep(2000);
			//	         driver.findElement(By.xpath("(//input[@type='number'])[3]")).sendKeys(High);
			//	         Thread.sleep(2000);
			//	         driver.findElement(By.xpath("(//input[@type='number'])[4]")).sendKeys(low);
			//	         Thread.sleep(2000);


			w.Submit();w.Yes();
			w.Password_Fill(InitiatorPassword);
		//	w.SubmitType_1();w.Ok();


		}}}
