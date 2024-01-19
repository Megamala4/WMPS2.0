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


public class TC_15_Quality_Inspection3 extends BaseClass
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

			String AR_Number_III =xls.getCellData("Dependency", "AR_Number_III", i);
			WMPS_Login("441111","Password");
			w.Quality_Control();w.Quality_Inspection();		
			w.SMPL(); 
			//w.ActionType_EditAction_Button2();
			driver.findElement(By.xpath("//input[@formcontrolname='ARNumber']")).sendKeys(AR_Number_III);Thread.sleep(2000);
			Select Action=new Select(driver.findElement(By.xpath("//select[@formcontrolname='AnalysisStatus']")));
			Action.selectByIndex(3);Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@formcontrolname='SampledQuantity']")).clear();

			driver.findElement(By.xpath("//input[@formcontrolname='SampledQuantity']")).sendKeys("4");Thread.sleep(2000);
			Select ReceivedUom = new Select (driver.findElement(By.xpath("//select[@formcontrolname='SampledQuantityUOM']")));
			ReceivedUom.selectByIndex(1);
			w.Comments("Quality_Inspection_Passed");
			w.Submit();w.Yes();
			w.Password_Fill(InitiatorPassword);
			//w.SubmitType12();w.Ok();
		}}}
