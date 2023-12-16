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


public class TC_06_Batch_Order extends BaseClass
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
		w.BatchOrder();	
		w.Create();


		//********************************************************************************************************************			
		int rowcount = xls.getRowCount("Material_Master");

		System.out.println(rowcount);
		for(int i=2; i<=2;i++)
		{ 
			//****************************************************************************************************		

			String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
			String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
			String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

			//********************************************************************************************************************
			String MaterialMasterSFP=xls.getCellData("Excel_Data", "MaterialMasterSFP", i);			

			String Batch_Number_I =xls.getCellData("Dependency", "Batch_Number_I", i);
			String Market =xls.getCellData("ProductRequirement", "Market", i);
			String OrderType =xls.getCellData("Material_Indent", "OrderType", i);
			String Material_Description =xls.getCellData("Material_Master", "Material_Description", i);

			w.TT_1_AD_E(MaterialMasterSFP);				
			w.TT_2("");//manufacture block

			WebElement MarketName = driver.findElement(By.xpath("(//*[@aria-autocomplete='list'])[3]"));
			MarketName.sendKeys("INDIA");Thread.sleep(2000);//should be same as of master we have given as product requirement*****
			MarketName.sendKeys(Keys.ARROW_DOWN,Keys.ENTER);Thread.sleep(2000);

			w.TT_4_AD_E("");
			w.Batch_Number(Batch_Number_I);//**********************Malli  use
			w.TT_11_AD_E(OrderType);//If we select Approved in Manufacture Assignment then we have to select commercial but if we select tentative then anything other thn commercial like validation re	
			w.BatchPlanningDate();Thread.sleep(7000);Thread.sleep(2000);//Manually
			w.Get_Button();
			driver.findElement(By.xpath("(//*[@title='Edit'])[1]")).click();Thread.sleep(2000);  //Edit Button


			//Selecting LotsSelecting LotsSelecting LotsSelecting LotsSelecting LotsSelecting LotsSelecting LotsSelecting LotsSelecting LotsSelecting LotsSelecting Lots
			//**********************************************************************************************************************************************************			

			w.CheckBox_2();			
			w.CheckBox_3();




			WebElement RequestedQuantity = driver.findElement(By.xpath("/html/body/app-root/div/div/app-material-indent-create/div/div[3]/div[1]/div/table/tbody/tr/app-transactions-pop-up[2]/div/div/div/div[2]/div/div/div[2]/div/table/tbody/tr[1]/td[6]/input"));
			RequestedQuantity.clear();RequestedQuantity.sendKeys("50");
			Thread.sleep(2000);  Thread.sleep(2000);  Thread.sleep(2000);



			WebElement RequestedQuantity1 = driver.findElement(By.xpath("/html/body/app-root/div/div/app-material-indent-create/div/div[3]/div[1]/div/table/tbody/tr/app-transactions-pop-up[2]/div/div/div/div[2]/div/div/div[2]/div/table/tbody/tr[2]/td[6]/input"));
			RequestedQuantity1.clear();RequestedQuantity1.sendKeys("50");
			Thread.sleep(2000);  Thread.sleep(2000);  Thread.sleep(2000);






			w.TITLE_SUBMIT();Thread.sleep(2000); //Select lot before submitting
			w.CheckBox_1();

			w.Submit();w.Yes();
			w.Password_Fill(InitiatorPassword);
		//	w.SubmitType12();w.Ok();



			//			driver.findElement(By.xpath("(//*[@title='Edit'])[1]")).click();Thread.sleep(2000);  //Edit Button
			//			
			//			
			//			WebElement RequestedQuantity2 = driver.findElement(By.xpath("(//*[@type='number'])[4]"));RequestedQuantity.clear();
			//			RequestedQuantity2.sendKeys("60");
			//			driver.findElement(By.xpath("(//*[@type='checkbox'])[3]")).click(); //Select checkbox
			//			w.Yes();
			//			
			//			driver.findElement(By.xpath("(//*[@type='checkbox'])[3]")).click(); //Select checkbox
			//			driver.findElement(By.xpath("//*[@title='Submit']")).click(); 
			//			Thread.sleep(2000); 
			//			w.Yes();
			//			driver.findElement(By.xpath("//*[@title='Submit']")).click(); 






		}}}
