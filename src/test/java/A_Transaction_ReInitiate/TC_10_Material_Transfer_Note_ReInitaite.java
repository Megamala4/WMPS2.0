package A_Transaction_ReInitiate;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_10_Material_Transfer_Note_ReInitaite extends BaseClass
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
		w.Production();
		w.Material_Transfer_Note();
		w.Create();
				
		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)		
		{ 
			String MaterialMasterFP=xls.getCellData("Excel_Data", "MaterialMasterFP", i);//New Semifinished Material Upper Part		

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

			WebElement ProductName = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[1]"));
			ProductName.sendKeys(MaterialMasterFP);Thread.sleep(2000);Thread.sleep(2000);Thread.sleep(2000);
			ProductName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);
			String Batch_Number_II =xls.getCellData("Dependency", "Batch_Number_II", i);

			String Batch_Number =xls.getCellData("Changable_Data", "Batch_Number_II", i);//Batch no is als from bill of material
			String Transferring_Department =xls.getCellData("MaterialTransforNote", "Tranferring_Department", i);
			String Block =xls.getCellData("MaterialTransforNote", "Block", i);
			String HandlingLoss =xls.getCellData("MaterialTransforNote", "HandlingLoss", i);
			String UOM =xls.getCellData("MaterialTransforNote", "UOM", i);
		
			w.TT_2_AD_E("");

			
//		WebElement Stage=driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[2]"));
//		//Stage.sendKeys("I");Thread.sleep(2000);
//		Stage.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);
//		
		w.TT_4_AD_E(Batch_Number_II);
//		WebElement BatchNumber=driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[3]"));
//		BatchNumber.sendKeys(Batch_Number_II);Thread.sleep(2000);
//		BatchNumber.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);
		//w.DropDown2Select();Thread.sleep(2000);
		w.TT_5_AD_E("W");
//		WebElement TransferringDepartment =driver.findElement(By.xpath("(//input[@type='text'])[5]"));
//		TransferringDepartment.sendKeys("W");Thread.sleep(2000);w.DropDown1Select();Thread.sleep(2000);
//						
//		WebElement TransferringBlock =driver.findElement(By.xpath("(//input[@type='text'])[6]"));
//		TransferringBlock.sendKeys(Block);Thread.sleep(2000);w.DropDown1Select();Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@formcontrolname='handlingLoss']")).sendKeys("1");Thread.sleep(2000);
w.TT_10_AD_E("K");
//		WebElement Uom =driver.findElement(By.xpath("(//input[@type='text'])[10]"));
//		Uom.sendKeys("K");w.DropDown1Select();Thread.sleep(2000);

		w.Comments("Material_Transfer_Note");
		
		w.Submit();w.Yes();
		w.Password_Fill(InitiatorPassword);
		//w.SubmitType12();w.Ok(); 
		




		}}}
