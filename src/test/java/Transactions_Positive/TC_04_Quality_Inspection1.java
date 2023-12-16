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


public class TC_04_Quality_Inspection1 extends BaseClass
{

	@org.testng.annotations.Test
	public static void Quality_Inspection() throws Exception
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
		
			String Pharmacopoeia =xls.getCellData("Quality_Inspection", "Pharmacopoeia", i);
			String Action =xls.getCellData("Quality_Inspection", "Action", i);
			String Sampled_Quantity =xls.getCellData("Quality_Inspection", "Sampled_Quantity", i);
			String SampledQuantityUOM =xls.getCellData("Quality_Inspection", "SampledQuantityUOM", i);	
			
			//************************************************************************************************************
			//Unique First AR Number in Raw Material Flow
			String AR_Number_I =xls.getCellData("Dependency", "AR_Number_I", i);					
			
			WMPS_Login("441111","Password");
			w.Quality_Control();w.Quality_Inspection();		
		//	w.SearchBox("");
			w.SMPL(); 			
			w.PharmacopoeiaId(Pharmacopoeia);			
			w.ARNumber(AR_Number_I);//****************************************************				
			w.Action(Action);			
			System.out.println(Action);
			boolean t= driver.findElement(By.xpath("//input[@formcontrolname='SampledQuantity']")).isDisplayed();
			if(t)
			{
		     System.out.println(Action);
		     
			w.SampledQuantity(Sampled_Quantity);
			w.SampledQuantityUOM(SampledQuantityUOM);
			}			
			System.out.println(Action);
			boolean tt= driver.findElement(By.xpath("//input[@formcontrolname='SampledQuantity']")).isDisplayed();
			if(tt)
			{
		     System.out.println(Action);

		     w.Comments("Quality_Inspection_Passed");
			}						
//			w.SampledQuantity(Sampled_Quantity);
//			w.SampledQuantityUOM(SampledQuantityUOM);						
			w.Comments("Quality_Inspection_Passed");	
			w.Submit();w.Yes();
			w.Password_Fill(InitiatorPassword);
	//	w.SubmitType_1();w.Ok();driver.close();	
		}}}
