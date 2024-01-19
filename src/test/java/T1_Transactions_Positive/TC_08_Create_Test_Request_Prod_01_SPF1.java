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

public class TC_08_Create_Test_Request_Prod_01_SPF1 extends BaseClass {

	@org.testng.annotations.Test
	public static void Bill_Of_Material() throws Exception {
		WMPS_OBJECT w = new WMPS_OBJECT(driver);
		HomePage hp = new HomePage(driver);
		Common_Xpath cxp = new Common_Xpath(driver);
		PWO_Xpath p = new PWO_Xpath(driver);
		DataFields df = new DataFields(driver);
		Master_Xpaths mp = new Master_Xpaths(driver);

		WMPS_Login("Initiator", "Initiator_Password");
		w.Menu_Navigate();
		w.Menu_Navigate();
		w.Production();
		w.Create_Test_Request_Production();
		Thread.sleep(2000);
		w.Create();

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for (int i = 2; i <= 2; i++) {
			// ******************************************************************************************************
			String InitiatorPassword = xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword = xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword = xls.getCellData("Changable_Data", "WrongPassword", i);
			// ******************************************************************************************************
			String MaterialMasterSFP = xls.getCellData("Excel_Data", "MaterialMasterSFP", i); // New Semifinished
			String Batch_Number_I = xls.getCellData("Dependency", "Batch_Number_I", i);// **************************
			String Batch_Number_II = xls.getCellData("Dependency", "Batch_Number_II", i);// **************************

			// ******************************************************************************************************
			// Material Upper Part
			String Date = xls.getCellData("Goods_ReceiptWith_WithOut", "manufacturing_date", i);
			String Quantity = xls.getCellData("Material_Indent", "requested_Quantity", i);
			// ******************************************************************************************************
			// Mapping
			String BatchSize = xls.getCellData("Bill_Of_Material", "BatchSize", i);
			// ******************************************************************************************************
			String Date1MB = xls.getCellData("Date", "Date1MB", i);
			String DateToday = xls.getCellData("Date", "DateToday", i);
			String Date1ML = xls.getCellData("Date", "Date1ML", i);
			String Date2ML = xls.getCellData("Date", "Date2ML", i);
			// ******************************************************************************************************

			// ******************************************************************************************************
			// w.TT_1_AD_E(MaterialMasterSFP);
			w.TT_1_AD_E(Pro.getProperty("SemiFinished_Product1"));
			// ******************************************************************************************************
			w.TT_4_AD_E(Batch_Number_I);
			// ******************************************************************************************************

			Select Manufacture_Block = new Select(
					driver.findElement(By.xpath("//*[@formcontrolname='manifactureBlockId']")));
			Manufacture_Block.selectByIndex(1);
			Thread.sleep(2000);

			w.ManufacturingDate(DateToday);

			Select Inspection_Type = new Select(
					driver.findElement(By.xpath("//*[@formcontrolname='inspectionTypeId']")));
			Inspection_Type.selectByIndex(1);
			Thread.sleep(2000);

			w.Quantity(BatchSize);
			w.TT_06_AD_E("KG");

			Select PharmaCopeia = new Select(driver.findElement(By.xpath("//*[@formcontrolname='pharmaCopeiaId']")));
			PharmaCopeia.selectByIndex(1);
			Thread.sleep(2000);

			Select Packing_Type = new Select(driver.findElement(By.xpath("//*[@formcontrolname='packingTypeId']")));
			Packing_Type.selectByIndex(1);
			Thread.sleep(2000);

			w.Container_No("1");
			w.Remarks("Create_Test_Request");
			Thread.sleep(2000);

			w.Submit();
			w.Yes();
			w.Password_Fill(InitiatorPassword);
			// w.Submit_Button();w.Ok();
			w.Eye_FF_01();
			w.Back_Button();
		}
	}
}
