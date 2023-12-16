package Transactions_Positive;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.pageobjects.Common_Xpath;
import com.pageobjects.DataFields;
import com.pageobjects.HomePage;
import com.pageobjects.Master_Xpaths;
import com.pageobjects.PWO_Xpath;
import com.pageobjects.WMPS_OBJECT;
import com.utilities.BaseClass;


public class TC_18_Material_Transfer_Receipt extends BaseClass
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

		WMPS_Login("441111","Password");
		w.WareHouse();
		w.Material_Transfer_Receipt();

		int rowcount = xls.getRowCount("Material_Master");
		System.out.println(rowcount);
		for(int i=2; i<=2;i++)		
		{ 
			String MaterialMasterFP=xls.getCellData("Excel_Data", "MaterialMasterFP", i);//New Semifinished Material Upper Part		

String InitiatorPassword =xls.getCellData("Changable_Data", "InitiatorPassword", i);
String ApproverPassword=xls.getCellData("Changable_Data", "ApproverPassword", i);
String WrongPassword =xls.getCellData("Changable_Data", "WrongPassword", i);

        w.SearchBox("");
        w.Edit_Action_Button();
		Select Action_Level_Select=new Select(driver.findElement(By.xpath("//*[@formcontrolname='status']")));
		Action_Level_Select.selectByIndex(2);Thread.sleep(2000);
		w.Comments("Material_Transfer_Receipt");
		w.Submit();w.Yes();
		w.Password_Fill(InitiatorPassword);
		//w.SubmitType12();w.Ok();
		}}}
