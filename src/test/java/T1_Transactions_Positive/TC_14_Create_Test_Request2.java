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


public class TC_14_Create_Test_Request2 extends BaseClass
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
		//w.Menu_Navigate();w.Menu_Navigate();

		w.Production();
		w.Create_Test_Request_Production();Thread.sleep(2000);
		w.Create();


		int rowcount = xls.getRowCount("Material_Master");

		System.out.println(rowcount);
		for(int i=2; i<=2;i++)		
		{ 
			String Batch_Number_II =xls.getCellData("Dependency", "Batch_Number_II", i);

			String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

			String MaterialMasterFP=xls.getCellData("Excel_Data", "MaterialMasterFP", i);	//New Semifinished Material Upper Part		

			String Date =xls.getCellData("Goods_ReceiptWith_WithOut", "manufacturing_date", i);
			String DateToday =xls.getCellData("Date", "DateToday", i);

			String Quantity =xls.getCellData("Material_Indent", "requested_Quantity", i);
			//Mapping


			String BatchSize =xls.getCellData("Bill_Of_Material", "BatchSize", i);//BOM??Baatch order(static) // create test request

			w.TT_1_AD_E(MaterialMasterFP);			
			w.TT_4_AD_E(Batch_Number_II);

			Select Manufacture_Block = new Select (driver.findElement(By.xpath("//*[@formcontrolname='manifactureBlockId']")));
			Manufacture_Block.selectByIndex(1);Thread.sleep(2000);

			w.ManufacturingDate(DateToday);	

			Select inspection_type = new Select (driver.findElement(By.xpath("//*[@formcontrolname='inspectionTypeId']")));
			inspection_type.selectByIndex(1);Thread.sleep(2000);

			w.Quantity(BatchSize);

			w.TT_5_AD_E("KG");

			Select PharmaCopeia = new Select (driver.findElement(By.xpath("//*[@formcontrolname='pharmaCopeiaId']")));
			PharmaCopeia.selectByIndex(1);Thread.sleep(2000);

			w.NumberOfContainers("1");

			Select Packing_Type = new Select (driver.findElement(By.xpath("//*[@formcontrolname='packingTypeId']")));
			Packing_Type.selectByIndex(1);Thread.sleep(2000);
			w.Remarks(BatchSize);
			w.Submit();w.Yes();
			w.Password_Fill(InitiatorPassword);
			//	w.SubmitType_1();w.Ok();driver.close();

		}}}
