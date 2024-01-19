package X_Masters_Creation;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_02_Vendor_Master_Manufacturer extends BaseClass
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
		for(int i=2; i<=rowcount;i++)
		{ 
			String materialtype =xls.getCellData("Material_Master", "Material_Type", i);
			String Material_Description =xls.getCellData("Material_Master", "Material_Description", i);
			String Material_Long_Description =xls.getCellData("Material_Master", "Material_Long_Description", i);
			String Stage =xls.getCellData("Material_Master", "Stage", i);
			String Purchase_UOM =xls.getCellData("Material_Master", "Purchase_UOM", i);
			String Material_Code =xls.getCellData("Material_Master", "Material_Code", i);
			String Material_Number =xls.getCellData("Material_Master", "Material_Number", i);
			String Basic_Unit_Of_Measurement =xls.getCellData("Material_Master", "Basic_Unit_Of_Measurement", i);
			String Production_Starting_Yrear =xls.getCellData("Material_Master", "Production_Starting_Yrear", i);
			String Procurement_Type =xls.getCellData("Material_Master", "Procurement_Type", i);
			String Storage_Conditions =xls.getCellData("Material_Master", "Storage_Conditions", i);
			String Specification_STP_No =xls.getCellData("Material_Master", "Specification_STP_No", i);
			String Rounding =xls.getCellData("Material_Master", "Rounding", i);	
			String Inspectiontype =xls.getCellData("Datafields_ALL", "Inspectiontype", i);
			String Edit_InspectionType =xls.getCellData("Datafields_ALL", "Edit_InspectionType", i);
			
			
			
			String Vendor_type =xls.getCellData("Vendor_Supplier", "Vendor_type", i);
			
			String Vendor_name =xls.getCellData("Vendor_Supplier", "Vendor_name", i);
			String Street =xls.getCellData("Vendor_Supplier", "Street", i);
			String Street1 =xls.getCellData("Vendor_Supplier", "Street1", i);
			String Street2 =xls.getCellData("Vendor_Supplier", "Street2", i);
			String City =xls.getCellData("Vendor_Supplier", "City", i);	
			String Postal_Code =xls.getCellData("Vendor_Supplier", "Postal_Code", i);	
			String Countries =xls.getCellData("Vendor_Supplier", "Country", i);	
			String State =xls.getCellData("Vendor_Supplier", "State", i);
			


			WMPS_Login("441111","Password");

			w.Menu();

			mp.Vendor_Master();
			w.Create();

			Select Vendor_Type_DDselect=new Select(driver.findElement(By.xpath("//*[@formcontrolname='vendorType']")));
			Vendor_Type_DDselect.selectByIndex(0);Thread.sleep(2000);
			
			mp.Vendor_Name_SK(Vendor_name);
			
			driver.findElement(By.xpath("//*[@formcontrolname='street']")).sendKeys(Street);Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@formcontrolname='street1']")).sendKeys(Street1);Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@formcontrolname='street2']")).sendKeys(Street2);Thread.sleep(1000);
			
			
			Select country=new Select(driver.findElement(By.xpath("//*[@formcontrolname='country']")));country.selectByIndex(4);Thread.sleep(2000);
			Select state=new Select(driver.findElement(By.xpath("//*[@formcontrolname='state']")));state.selectByIndex(2);Thread.sleep(2000);
			Select city=new Select(driver.findElement(By.xpath("//*[@formcontrolname='cityId']")));city.selectByIndex(2);Thread.sleep(2000);

			
			mp.Postal_Code(Postal_Code);Thread.sleep(2000);
			
//			w.Submit();
//			w.Not_Create();
//			
//			driver.findElement(By.xpath("//*[contains(text(),'Clear ')]")).click();
//			
//			mp.Vendor_Type_DDselect();
//			mp.Vendor_Name_SK(Vendor_name);
//			driver.findElement(By.xpath("//*[@formcontrolname='street']")).sendKeys("sStreet");Thread.sleep(1000);
//			driver.findElement(By.xpath("//*[@formcontrolname='street1']")).sendKeys("sStreet1");Thread.sleep(1000);
//			driver.findElement(By.xpath("//*[@formcontrolname='street2']")).sendKeys("sStreet2");Thread.sleep(1000);
//
//			Select country1=new Select(driver.findElement(By.xpath("//*[@formcontrolname='country']")));country1.selectByIndex(4);Thread.sleep(2000);
//			Select state1=new Select(driver.findElement(By.xpath("//*[@formcontrolname='state']")));state1.selectByIndex(2);Thread.sleep(2000);
//			Select city1=new Select(driver.findElement(By.xpath("//*[@formcontrolname='cityId']")));city1.selectByIndex(2);Thread.sleep(2000);
//			
//			mp.postalSend(Postal_Code);
//			w.Submit();Thread.sleep(2000);
//			w.Not_Create();Thread.sleep(2000);Thread.sleep(2000);
//			
//			driver.findElement(By.xpath("//*[contains(text(),' Back ')]")).click();Thread.sleep(2000);
//			w.Create();
//			mp.Vendor_Type_DDselect();
//			mp.Vendor_Name_SK(Vendor_name);
//			driver.findElement(By.xpath("//*[@formcontrolname='street']")).sendKeys("sStreet");Thread.sleep(1000);
//			driver.findElement(By.xpath("//*[@formcontrolname='street1']")).sendKeys("sStreet1");Thread.sleep(1000);
//			driver.findElement(By.xpath("//*[@formcontrolname='street2']")).sendKeys("sStreet2");Thread.sleep(4000);
//			
//			Select country2=new Select(driver.findElement(By.xpath("//*[@formcontrolname='country']")));country2.selectByIndex(4);Thread.sleep(2000);
//			Select state2=new Select(driver.findElement(By.xpath("//*[@formcontrolname='state']")));state2.selectByIndex(2);Thread.sleep(2000);
//			Select city2=new Select(driver.findElement(By.xpath("//*[@formcontrolname='cityId']")));city2.selectByIndex(2);Thread.sleep(2000);
//			mp.postalSend(Postal_Code);
//			w.Submit();
//			w.Not_Create();
			
			w.Submit();
			
			E_Signature1("Password");

		}}}
